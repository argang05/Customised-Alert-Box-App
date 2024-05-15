  package com.example.customisedalertboxapp

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //Creating variable for Dialog:
    lateinit var dialog : Dialog;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Initializing Dialog Box:
        dialog = Dialog(this);
        //Setting Content of Dialog Box:
        dialog.setContentView(R.layout.custom_dialog);

        //Setting customised background from drawable:
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alertbox));

        //Initializing the activity_main.xml buttons:
        var clickButton = findViewById<Button>(R.id.buttonClick);

        //Initializing the custom_dialog.xml buttons:
        var buttonGreat = dialog.findViewById<Button>(R.id.buttonGood);
        var feedbackButton = dialog.findViewById<Button>(R.id.buttonFeedback);

        buttonGreat.setOnClickListener {
            Toast.makeText(
                this,
                "Great To Know You Are Enjoying The Journey!",
                Toast.LENGTH_SHORT
                ).show();
            dialog.dismiss();
        }

        feedbackButton.setOnClickListener {
            //Open Google Forms Using Implicit Intent:
            val intent = Intent(Intent.ACTION_VIEW);
            intent.data = Uri.parse("https://forms.gle/Dq414JMS9wMprvPR8");
            startActivity(intent)
        }

        clickButton.setOnClickListener {
            //On clicking the button show the dialog:
            dialog.show();
        }
    }
}