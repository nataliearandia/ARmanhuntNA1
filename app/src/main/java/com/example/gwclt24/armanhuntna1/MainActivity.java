package com.example.gwclt24.armanhuntna1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button PlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayButton = (Button) findViewById(R.id.PlayButton); //find the Play button
        PlayButton.setOnClickListener(new View.OnClickListener()
           {
            @Override
            public void onClick(View v)
            {
                openPlayActivity();
            }
           });
    }
    public void openPlayActivity()
    {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

}
