package com.example.lusen.musiclu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lusen.musiclu.R;

/**
 * Created by lusen on 2017/4/24.
 */

public class MeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_me,null);
        return view;
    }

    public static MeFragment getInstance(String title){
        MeFragment meFragment  = new MeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        meFragment.setArguments(bundle);
        return meFragment;
    }
}
