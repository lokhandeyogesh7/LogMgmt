package com.example.logmgmt.presenter

interface LoginContract {

    interface LoginView {

        fun showProgress()

        fun showToast(message: String)

    }


    interface GetLoginResponse {

    }


    interface LoginPresenter {

        fun getLoginResponseFromServer(email: String, password: String)

    }
}