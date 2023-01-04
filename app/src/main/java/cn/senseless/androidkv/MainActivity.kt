package cn.senseless.androidkv

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidKV.init(applicationContext)
        val textView = findViewById<TextView>(R.id.text)
        Cache.token = "abc"
        textView.text = Cache.token
    }
}