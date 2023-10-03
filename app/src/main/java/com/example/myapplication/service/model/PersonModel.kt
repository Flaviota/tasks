package com.example.myapplication.service.model

import com.google.gson.annotations.SerializedName

class PersonModel {

    //info do json, quando fizer o login ou a criação
    @SerializedName("token")
    lateinit var token: String

    @SerializedName("personKey")
    lateinit var personKey: String

    @SerializedName("name")
    lateinit var name: String

}