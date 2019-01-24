package com.example.logmgmt.network

import com.example.logmgmt.model.LoginResult
import io.reactivex.Observable
import retrofit2.http.*

interface NetworkInterface {

    @Headers("Content-Type:application/json")
    @POST("public/validate-login-api")
    fun getLoginResponse(@Body objectsa: HashMap<String, String>): Observable<LoginResult>

}