package com.example.spotif_ai;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    Button songbutton;
    Button playlistbutton;

    TextView smileprobability;
    TextView heartrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_setting);

        smileprobability = findViewById(R.id.smileprobabilityvalue);
        heartrate = findViewById(R.id.heartratevalue);

        smileprobability.setText("");
        heartrate.setText("" + " bpm");


        songbutton =  findViewById(R.id.songlink);
        playlistbutton = findViewById(R.id.playlistlink);

        songbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://spotify.com"));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

        playlistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://spotify.com"));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
                finish();

            }
        });

    }
}
