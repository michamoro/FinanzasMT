package com.fmt.finanzasmt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Exit(View view){
        Intent exit = new Intent(this, LoginActivity.class);
        startActivity(exit);
    }
}
