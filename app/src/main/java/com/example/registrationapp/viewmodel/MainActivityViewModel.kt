package com.example.registrationapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registrationapp.model.Registration

class MainActivityViewModel: ViewModel {
    var first_name = ObservableField<String>("")
    var last_name = ObservableField<String>("")
    var phone_no = ObservableField<String>("")
    var email = ObservableField<String>("")
    var password = ObservableField<String>("")
    var confirm_password = ObservableField<String>("")
     var resultdata = MutableLiveData<String>()

    constructor() : super()

    fun registerData(register:Registration){
        var name:String=""

        if(register.first_name.equals("shivam"))
        {
            name ="Valid User"

        }
        resultdata.value = name

    }

    fun getRegisterUser():MutableLiveData<String>{
        return resultdata
    }
}