package com.example.lusen.musiclu.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lusen.musiclu.R;
import com.example.lusen.musiclu.fragment.ChosenFragment;
import com.example.lusen.musiclu.fragment.MeFragment;
import com.example.lusen.musiclu.fragment.MusicFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView view;
    android.app.FragmentTransaction transaction;
    MeFragment meFragment = new MeFragment();
    MusicFragment musicFragment = new MusicFragment();
    ChosenFragment chosenFragment = new ChosenFragment();
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        menuClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.search_bar) {
            Intent intent = new Intent(MainActivity.this,SearchActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void menuClick(){
        view = (BottomNavigationView) findViewById(R.id.bottom_menu);
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_me:
                        startFragment(meFragment);
                        break;
                    case R.id.menu_chose:
                        startFragment(chosenFragment);
                        break;
                    case R.id.menu_music:
                        startFragment(musicFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void startFragment(Fragment fragment){
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.pager_frame,fragment);
        transaction.commit();
    }

}
