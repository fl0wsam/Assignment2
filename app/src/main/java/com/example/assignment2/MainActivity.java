package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button profileNameButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileNameButton = (Button) findViewById(R.id.profileButton);
        profileNameButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToProfile();

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.profileid), Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(getString(R.string.profileid),null);

        if (name == null){

            goToProfile();

        }else {
            profileNameButton.setText(name);
        }
    }

    protected void goToProfile()
    {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

}
