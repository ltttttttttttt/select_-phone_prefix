package com.lt.selectcountry.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.lt.select_country.LtSelectCountryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LtSelectCountryActivity.setSelectListener {

            return@setSelectListener false
        }

    }

    fun onClick(v: View?) {
        startActivityForResult(Intent(this, LtSelectCountryActivity::class.java), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val bean = LtSelectCountryActivity.getCountryBean(data) ?: return
            Toast.makeText(this, bean.zh, Toast.LENGTH_SHORT).show()
        }
    }
}
