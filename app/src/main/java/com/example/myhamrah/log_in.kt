package com.example.myhamrah

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.media.Ringtone
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class log_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val txtview_phone:TextView=findViewById(R.id.text_number)
        val btn_internet=findViewById<ImageButton>(R.id.baste_internet)
        val btn_tarh=findViewById<ImageButton>(R.id.tarh_tashvighi)
        val btn_madar=findViewById<ImageButton>(R.id.madar_firooze)
        val btn_enteghal=findViewById<ImageButton>(R.id.enteghal)
        val mediaPlayer:MediaPlayer=MediaPlayer.create(this,R.raw.Ringtone)


        if (intent.extras!=null){

            var view_phone:String=intent.extras!!.getString("edt_phone","")
            txtview_phone.text=""+ view_phone
        }
        btn_internet.setOnClickListener { mediaPlayer.start()
        var intent:Intent=Intent(this,kharidbaste::class.java)
            finish()
            startActivity(intent)
        }
        btn_madar.setOnClickListener {

            mediaPlayer.start()
            Toast.makeText(this, "این قسمت در حال حاظر خارج از دسترس میباشد", Toast.LENGTH_LONG).show()

        }
        btn_tarh.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این قسمت در حال حاظر خارج از دسترس میباشد", Toast.LENGTH_LONG).show()
        }
        btn_enteghal.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این قسمت در حال حاظر خارج از دسترس میباشد", Toast.LENGTH_LONG).show()
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