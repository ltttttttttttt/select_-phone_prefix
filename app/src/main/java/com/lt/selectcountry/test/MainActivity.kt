package com.lt.selectcountry.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.lt.select_country.CountryBean
import com.lt.select_country.SelectCountryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onClick(v: View?) {
        startActivityForResult(Intent(this, SelectCountryActivity::class.java), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val bean = data?.getSerializableExtra("bean") as CountryBean? ?: return
        Toast.makeText(this, bean.zh, Toast.LENGTH_SHORT).show()
    }
}
