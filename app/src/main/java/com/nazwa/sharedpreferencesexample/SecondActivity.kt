package com.nazwa.sharedpreferencesexample
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nazwa.sharedpreferencesexample.databinding.ActivitySecoundBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener {
            val filename = "$packageName-${MainActivity.RPL}"
            val pref = getSharedPreferences(filename,
                MODE_PRIVATE
            )
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            binding.tvOutput.text = "$firstName $lastName "
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}