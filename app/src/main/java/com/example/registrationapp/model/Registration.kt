package com.example.registrationapp.model

class Registration {
    var first_name:String = ""
    var last_name:String = ""
    var phone_no:Long
    var email:String = ""
    var password:String = ""
    var confirm_password:String = ""

    constructor(
        first_name: String,
        last_name: String,
        phone_no: Long,
        email: String,
        password: String,
        confirm_password: String
    ) {
        this.first_name = first_name
        this.last_name = last_name
        this.phone_no = phone_no
        this.email = email
        this.password = password
        this.confirm_password = confirm_password
    }
}