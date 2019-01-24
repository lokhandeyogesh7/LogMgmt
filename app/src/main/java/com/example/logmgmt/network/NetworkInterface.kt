package com.example.logmgmt.network

import com.example.logmgmt.model.LoginResult
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.http.*

interface NetworkInterface {

    @Headers("Content-Type:application/json")
    @POST("public/validate-login-api")
    fun getLoginResponse(@Body objectsa: JSONObject): Observable<LoginResult>

}