package com.example.registrationapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registrationapp.model.Registration
import com.example.registrationapp.model.YourInfo

class YourInfoActivityViewModel: ViewModel {
    var education = ObservableField<String>("")
    var year_of_passing = ObservableField<String>("")
    var grade = ObservableField<String>("")
    var experience = ObservableField<String>("")
    var designation = ObservableField<String>("")
    var domain = ObservableField<String>("")
    var resultdata = MutableLiveData<String>()

    constructor() : super()

    fun yourInfoData(yourinfo: YourInfo){
        var name:String=""

        if(yourinfo.education.equals("Graduate"))
        {
            name ="Valid User"

        }
        resultdata.value = name

    }

    fun getYourInfo(): MutableLiveData<String> {
        return resultdata
    }
}