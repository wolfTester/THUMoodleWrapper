package de.wolfwarrior.thu_moodle_wrapper


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val source = intent
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("moodlemobile://link=" + source.dataString))
        val tmp = source.dataString
        if (tmp.toString() != "null") {
            if (i.resolveActivity(packageManager) != null) { //Old Version with Bug since Android 11 +
                startActivity(i)
                finish()
                return
            } else {
                Toast.makeText(this, getString(R.string.no_moodle_app), Toast.LENGTH_SHORT).show()
            }
        }else{
            setContentView(R.layout.activity_main)
            val webview = findViewById<WebView>(R.id.webview)
            webview.loadUrl("https://github.com/wolfwarrior666/THUMoodleWrapper#readme")
        }
    }
}