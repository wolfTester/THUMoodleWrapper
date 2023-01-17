package de.wolfwarrior.thu_moodle_wrapper

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val source = intent
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("moodlemobile://link=" + source.dataString))
        if (i.resolveActivity(packageManager) != null) {
            startActivity(i)
            finish()
            return
        } else {
            Toast.makeText(this, "Newest version of Moodle not installed.", Toast.LENGTH_SHORT)
                .show()
        }
    }
}