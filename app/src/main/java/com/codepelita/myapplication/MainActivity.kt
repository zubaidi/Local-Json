package com.codepelita.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepelita.myapplication.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    var firstName: ArrayList<String> = ArrayList()
    var lastName: ArrayList<String> = ArrayList()
    var gender: ArrayList<String> = ArrayList()
    var age: ArrayList<String> = ArrayList()
    var number: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.listData.layoutManager = linearLayoutManager
        try {
            var obj = JSONObject(loadJSon())
            var jsonArray = obj.getJSONArray("people")
            for (i in 0 until jsonArray.length()) {
                val userDetail = jsonArray.getJSONObject(i)
                firstName.add("Nama Depan : ${userDetail.getString("firstName")}")
                lastName.add("Nama Belakang : ${userDetail.getString("lastName")}")
                gender.add("Jenis Kelamin : ${userDetail.getString("gender")}")
                age.add("Usia : ${userDetail.getString("age")}")
                number.add("Nomor ID : ${userDetail.getString("number")}")
            }
        } catch (ex : JSONException) {
            ex.printStackTrace()
        }
        val peopleAdapter = PeopleAdapter(this@MainActivity, firstName, lastName, gender, age, number)
        binding.listData.adapter = peopleAdapter
    }

    private fun loadJSon(): String? {
        val json: String?
        try {
            val inputStream = assets.open("data_people.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

}