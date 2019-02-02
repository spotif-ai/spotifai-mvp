package com.example.spotif_ai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    Button stabilizeButton, motivateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        stabilizeButton = findViewById(R.id.stabilizeButton);
        motivateButton = findViewById(R.id.motivateButton);

        stabilizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stabilize = new Intent(SettingActivity.this, CameraActivity.class);
                stabilize.putExtra("id", "stabilize");
                startActivity(stabilize);
                finish();

            }
        });
        motivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent motivate = new Intent(SettingActivity.this, CameraActivity.class);
                motivate.putExtra("id", "motivate");
                startActivity(motivate);
                finish();
            }
        });

    }

}
