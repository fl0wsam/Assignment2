package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    protected EditText nameEditText;
    protected Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEditText = findViewById(R.id.nameEditText);
        saveButton = findViewById(R.id.saveButton);
        
        saveButton.setOnClickListener(v -> {

            String name = nameEditText.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.profileid), Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(getString(R.string.profileid),name);


            editor.apply();

            Toast toast = Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG);
            toast.show();
        });

    }
}