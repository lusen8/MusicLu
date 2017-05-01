package com.example.lusen.musiclu.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lusen.musiclu.R;
import com.example.lusen.musiclu.fragment.SearchListFragment;

public class SongListActivity extends AppCompatActivity {

    ActionBar actionBar;
    private ImageView back;
    private ImageView search;
    private String songName;

    public String getSongName() {
        return songName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);


        init();
        Intent intent = getIntent();
        songName = intent.getStringExtra("name");
        replaceFragment(new SearchListFragment());

    }

    private void init(){
        actionBar = getSupportActionBar();
        actionBar.hide();
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.searchChange, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
