package com.example.lusen.musiclu.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.lusen.musiclu.R;
import com.example.lusen.musiclu.view.SeachView;

public class SearchActivity extends AppCompatActivity {

    ImageView backSeach;
    SeachView seachView;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        click();

    }

    private void click(){
        backSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void init(){
        actionBar = getSupportActionBar();
        actionBar.hide();
        SeachView.inflate(this,R.layout.search_layout,null);
        backSeach = (ImageView) findViewById(R.id.back_search);
    }
}
