package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.registrationapp.databinding.ActivityMainBinding
import com.example.registrationapp.model.Registration
import com.example.registrationapp.presenter.RegistrationPresenter
import com.example.registrationapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var gendr:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        var viewmodel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        activityMainBinding!!.presenter = object : RegistrationPresenter {

            override fun nextClickone() {


//                var male:RadioButton = activityMainBinding.rbMale
//                var female:RadioButton = activityMainBinding.rbFemale

                var first_name: String = activityMainBinding.etFirstName.text.toString()
                var last_name: String = activityMainBinding.etLastName.text.toString()
                var phone_no: String = activityMainBinding.etPhoneNo.text.toString()
                var email: String = activityMainBinding.etEmail.text.toString()
                var password: String = activityMainBinding.etPassword.text.toString()
                var confirm_password: String = activityMainBinding.etConformPassword.text.toString()
                var gender:RadioGroup = activityMainBinding.radioGroup
                var selectedId: Int = gender.checkedRadioButtonId

                if(!isNameValid(first_name))
                {
                    activityMainBinding.etFirstName.setError("Please Insert First Name")
                }
                else if(!isNameValid(last_name))
                {
                    activityMainBinding.etLastName.setError("Please Insert Last Name")
                }
                else if(!isPhoneValid(phone_no))
                {
                    activityMainBinding.etPhoneNo.setError("Please Insert Valid Phone Number")
                }
                else if(!isEmailValid(email))
                {
                    activityMainBinding.etEmail.setError("Please Insert Valid Email")
                }
                else if(!isValidPassword(password))
                {
                    activityMainBinding.etPassword.setError("Please Insert Valid Password")
                }

                else if(!isValidCPassword(password,confirm_password))
                {
                    activityMainBinding.etConformPassword.setError("Password and Confirm Password should be same")
                }



//
//                else if (selectedId!=-1){
//                    val radio:RadioButton = findViewById(selectedId)
//                    gendr = "${radio.text}"
//                }



                else {
                    var register = Registration(
                        first_name,
                        last_name,
                        phone_no.toLong(),
                        email,
                        password,
                        confirm_password
                    )
                    viewmodel.registerData(register)
                }

                    showToast("Please Wait")


            }


        }
        viewmodel.getRegisterUser().observe(this, Observer {
            showToast("Next")
            val intent = Intent(this, YourInfoActivity::class.java)
            startActivity(intent)
        })
    }

    // Validating IsEmpty
    fun isEmpty(text: EditText): Boolean {
        val str: CharSequence = text.text.toString()
        return TextUtils.isEmpty(str)
    }

    // Toast Function
    fun showToast(value: String) {
        Toast.makeText(this, "" + value, Toast.LENGTH_LONG).show()
    }

    // Validating Email
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Validating Phone Number
    fun isPhoneValid(phone: String): Boolean {
        if (phone.length != 10) {
            return false
        } else {
            return android.util.Patterns.PHONE.matcher(phone).matches()
        }
    }

    // Validating Name
    fun isNameValid(name: String): Boolean {
        name?.let {
            val namePattern = "^(?=.*[a-z]).{3,}$"
            val nameMatcher = Regex(namePattern)

            return nameMatcher.find(name) != null
        } ?: return false
    }

    // Validating Password
    fun isValidPassword(password: String): Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }

    // Validating Password
    fun isValidCPassword(password: String, confirm_password: String): Boolean {
        confirm_password.let {
            password.equals(confirm_password)
            return confirm_password != null
        } ?: return false
    }
}
