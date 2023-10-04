package com.example.myapplication.service.repository

import android.content.Context
import com.example.myapplication.R
import com.example.myapplication.service.listener.APIListener
import com.example.myapplication.service.model.PersonModel
import com.example.myapplication.service.repository.remote.PersonService
import com.example.myapplication.service.repository.remote.RetrofitClient

class PersonRepository(context: Context) : BaseRepository(context) {

    //chamada remota
    private val remote = RetrofitClient.getService(PersonService::class.java)

    //Tratamento de exceção de falta de conexão
    fun login(email: String, password: String, listener: APIListener<PersonModel>) {
        if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        executeCall(remote.login(email, password), listener)
    }

    fun create(name: String, email: String, password: String, listener: APIListener<PersonModel>) {
        if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        executeCall(remote.create(name, email, password), listener)
    }

}