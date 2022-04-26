package com.example.registrationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.registrationapp.databinding.ActivityYourInfoBinding
import com.example.registrationapp.presenter.YourInfoPresenter
import com.example.registrationapp.viewmodel.YourInfoActivityViewModel
import kotlinx.android.synthetic.main.activity_your_info.*


class YourInfoActivity : AppCompatActivity() {
    lateinit var btn: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_info)


        var yourInfoBinding =
            DataBindingUtil.setContentView<ActivityYourInfoBinding>(
                this,
                R.layout.activity_your_info
            )


        // Education
        val qualifications = resources.getStringArray(R.array.qualification)
        val arrayAdapter =
            ArrayAdapter(this@YourInfoActivity, R.layout.dropdown_menu, qualifications)
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.drop1)
        autocompleteTV.setAdapter(arrayAdapter)
        autocompleteTV.onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                val selectedValue = arrayAdapter.getItem(position)
                if (position == -1)
                    autocompleteTV.setError("Select Your Qualification")
                else
                    autocompleteTV.setError(null)
                showToast(selectedValue)

            }

        // Designation
        val designations = resources.getStringArray(R.array.designation)
        val arrayAdapter_des =
            ArrayAdapter(this@YourInfoActivity, R.layout.dropdown_menu, designations)
        val autocompleteTV_des = findViewById<AutoCompleteTextView>(R.id.drop3)
        autocompleteTV_des.setAdapter(arrayAdapter_des)
        autocompleteTV_des.onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                val selectedValue_des = arrayAdapter_des.getItem(position)
                if (position == -1)
                    autocompleteTV_des.setError("Select Designation")
                else
                    autocompleteTV_des.setError(null)
                showToast(selectedValue_des)

            }

        // Domain
        val domains = resources.getStringArray(R.array.domain)
        val arrayAdapter_dom =
            ArrayAdapter(this@YourInfoActivity, R.layout.dropdown_menu, domains)
        val autocompleteTV_dom = findViewById<AutoCompleteTextView>(R.id.drop4)
        autocompleteTV_dom.setAdapter(arrayAdapter_dom)
        autocompleteTV_dom.onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                val selectedValue_dom = arrayAdapter_dom.getItem(position)
                if (position == -1)
                    autocompleteTV_dom.setError("Select Designation")
                else
                    autocompleteTV_dom.setError(null)
                showToast(selectedValue_dom)

            }

        // Year Of Passing


////                else {
////                    var your_info = YourInfo(
////                        education,
////                        year_of_passing.toInt(),
////                        grade,
////                        experience.toInt(),
////                        designation,
////                        domain
////                    )
////                    viewmodel.yourInfoData(your_info)
////                }
//
//                showToast("Please Wait")
//
//
//            }
//
//
//        }
//        viewmodel.getYourInfo().observe(this, Observer {
//            showToast("Next")
//            val intent = Intent(this, YourInfoActivity::class.java)
//            startActivity(intent)
//        })
//
//
//        var viewmodel = ViewModelProviders.of(this).get(YourInfoActivityViewModel::class.java)
        yourInfoBinding!!.presenter = object : YourInfoPresenter {

            override fun nextClicktwo() {
                btn = yourInfoBinding.Button03
                var education: String = yourInfoBinding.drop1.text.toString()
                var year_of_passing: String = yourInfoBinding.etYop.text.toString()
                var grade: String = yourInfoBinding.etgrade.text.toString()
                var experience: String = yourInfoBinding.etExperience.text.toString()
                var designation: String = yourInfoBinding.drop3.text.toString()
                var domain: String = yourInfoBinding.drop4.text.toString()

                if(isEmpty(drop1)){
                    yourInfoBinding.drop1.setError("Please Select Your Qualification")
                }
                else if(isEmpty(etYop)){
                    yourInfoBinding.etYop.setError("Please Enter Your Year Of Passing")
                }
                else if(isEmpty(etgrade))
                {
                    yourInfoBinding.etgrade.setError("Please Enter Your Grade or Percentage")
                }
                else if(isEmpty(etExperience))
                {
                    yourInfoBinding.etExperience.setError("Please Enter Your Years of Experience")
                }
                else if(isEmpty(drop3))
                {
                    yourInfoBinding.drop3.setError("Please Select Your Designation")
                }
                else if(isEmpty(drop4))
                {
                    yourInfoBinding.drop4.setError("Please Select Your Domain")
                }
                else {

                    btn.setOnClickListener {
                        val intent = Intent(this@YourInfoActivity, YourAdressActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }


        // Toast Function
        fun showToast(value: String?) {
            Toast.makeText(this, "" + value, Toast.LENGTH_LONG).show()
        }

    // Validating IsEmpty
    fun isEmpty(text: EditText): Boolean {
        val str: CharSequence = text.text.toString()
        return TextUtils.isEmpty(str)
    }

}




