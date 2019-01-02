package com.example.gwclt24.armanhuntna1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    private Button JGbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //transition from Play to JoinGame
        JGbutton = (Button) findViewById(R.id.JGbutton); //find the join game button
        JGbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openJoinGameActivity();
            }
        });
    }
    public void openJoinGameActivity()
    {
        Intent intent = new Intent(this, JoinGameActivity.class);
        startActivity(intent);
    }
}
