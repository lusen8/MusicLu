package com.example.lusen.musiclu.fragment;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.lusen.musiclu.R;
import com.example.lusen.musiclu.json.MyGsonUtil;
import com.example.lusen.musiclu.json.SongIdData;
import com.example.lusen.musiclu.net.ImageUtils;
import com.example.lusen.musiclu.net.MyHttpURL;

import java.io.IOException;

public class MusicPlayFragment extends Fragment {

    private ImageView showPic;
    private Switch play;
    private MediaPlayer mediaPlayer;
    int id;

    public MusicPlayFragment() {
    }
    //将音乐标识id传入，可通过此id获取歌曲歌词和链接
    public MusicPlayFragment(int id) {
        this.id = id;
        mediaPlayer = new MediaPlayer();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_play, container, false);
        showPic = (ImageView) view.findViewById(R.id.showPic);
        play = (Switch) view.findViewById(R.id.play);
        MyHttpURL.get("http://music.163.com/api/song/detail/?ids=%5B" + Integer.toString(id) + "%5D", new MyHttpURL.Callback() {
            @Override
            public void onResponse(String response) {
                SongIdData song = MyGsonUtil.parseJsonWithGson(response, SongIdData.class);

                ImageUtils.get(song.getSongs().get(0).getAlbum().getPicUrl(), new ImageUtils.Callback_img() {
                    @Override
                    public void onResponse(Bitmap response) {
                        showPic.setImageBitmap(response);
                    }
                });

                try {
                    mediaPlayer.setDataSource(song.getSongs().get(0).getMp3Url());
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        play.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }
            }
        });
        return view;
    }
}
