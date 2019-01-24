package com.example.logmgmt.presenter

import android.annotation.SuppressLint
import com.example.logmgmt.model.LoginResult
import com.example.logmgmt.network.NetworkClient
import com.example.logmgmt.network.NetworkInterface
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class LoginPresenterImpl(val loginView: LoginContract.LoginView) : LoginContract.LoginPresenter {

    @SuppressLint("CheckResult")
    override fun getLoginResponseFromServer(email: String, password: String) {
        var jsonObject=HashMap<String,String>()
        jsonObject.put("email",email)
        jsonObject.put("password",password)

        getObservable(jsonObject)!!.subscribeWith(getObserver())
    }


    fun getObservable(email: HashMap<String, String>): Observable<LoginResult>? {
        println("post params ")
        return NetworkClient().getRetrofit().create(NetworkInterface::class.java)
            .getLoginResponse(email)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    fun getObserver(): Observer<LoginResult> {
        return object : Observer<LoginResult> {
            override fun onSubscribe(d: Disposable) {
                println("login result is onSubscribe ${d.isDisposed}")
            }

            override fun onNext(@NonNull movieResponse: LoginResult) {
                println("login result is onNext ${movieResponse.msg}")
            }

            override fun onError(@NonNull e: Throwable) {
                println("login result is error ${e.message}")
                e.printStackTrace()
                loginView.showToast("Error fetching Movie Data")
            }

            override fun onComplete() {
                loginView.showToast(" fetching Movie Data ")
            }
        }
    }
}