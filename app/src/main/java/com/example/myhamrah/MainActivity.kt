package com.example.myhamrah

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getStateLogin(this)
        var edt_phone=findViewById<EditText>(R.id.main_edt_number)
        var edt_pass=findViewById<EditText>(R.id.main_edt_pass)
        var btn_login=findViewById<Button>(R.id.btn_confirm)
        var btn_signup=findViewById<Button>(R.id.btn_signup)
        var checkbox=findViewById<CheckBox>(R.id.checkBox)
        var frm1=findViewById<FrameLayout>(R.id.frame1)
        var frm_signup=findViewById<FrameLayout>(R.id.frame_register)
        var btn_register=findViewById<Button>(R.id.frm_reg_btn_signup)


        if (checkbox.isChecked){

        }
        btn_register.setOnClickListener {

            var intent:Intent=Intent( this,log_in::class.java)
            intent.putExtra("edt_phone",edt_phone.text.toString())
            finish()
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            var intent:Intent=Intent(this,log_in::class.java)
            finish()
            startActivity(intent)
        }
        btn_signup.setOnClickListener {
            frm1.visibility= View.GONE
            frm_signup.visibility=View.VISIBLE
        }
        btn_register.setOnClickListener {
            frm_signup.visibility=View.GONE
            frm1.visibility=View.VISIBLE
        }


    }
    private fun getStateLogin(context: Context) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("state", false)) {
            var intent: Intent = Intent(this, log_in::class.java)
            finish()
            startActivity(intent)
        }
    }
}