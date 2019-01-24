package com.example.logmgmt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResult {

    @SerializedName("msg")
    @Expose
    var msg: String? = null

}
