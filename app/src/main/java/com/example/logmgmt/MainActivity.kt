package com.example.logmgmt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.logmgmt.presenter.LoginContract
import com.example.logmgmt.presenter.LoginPresenterImpl

class MainActivity : AppCompatActivity(), LoginContract.LoginView {


    var loginPresenter: LoginPresenterImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpMVP()
        checkforLogin()
    }

    private fun checkforLogin() {

        loginPresenter?.getLoginResponseFromServer("yogesh.lokhande@enyotalearning.com","YDftpAny")
    }

    private fun setUpMVP() {
        loginPresenter = LoginPresenterImpl(this@MainActivity)
    }

    override fun showProgress() {

    }

    override fun showToast(message: String) {
        println("response is $message")
    }
}
