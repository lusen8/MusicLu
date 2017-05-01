package com.example.lusen.musiclu.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lusen.musiclu.R;
import com.example.lusen.musiclu.activity.SongListActivity;
import com.example.lusen.musiclu.adapter.RecyclerSongsAdapter;
import com.example.lusen.musiclu.json.MyGsonUtil;
import com.example.lusen.musiclu.json.SongData;
import com.example.lusen.musiclu.net.MyHttpURL;

public class SearchListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_list, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new SpaceItemDecoration(30));  //设置item间距

        SongListActivity songListActivity = (SongListActivity) getActivity();
        String songName = songListActivity.getSongName();   //从活动中获取歌曲名称

        MyHttpURL.get(setParams(songName), new MyHttpURL.Callback() {
            @Override
            public void onResponse(String response) {
                SongData song = MyGsonUtil.parseJsonWithGson(response, SongData.class);
                recyclerView.setAdapter(new RecyclerSongsAdapter(song.getResult().getSongs()));
            }
        });

        return view;
    }

    public String setParams(String msg) {  //拼接Url
        //return "http://music.163.com/api/song/detail/?ids=%5B"  + msg + "%5D"; //歌曲链接
        return "http://music.163.com/api/search/get/web?csrf_token=hlpretag=&hlposttag=&s=" + msg + "&type=1&offset=0&total=true&limit=50";
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        int mSpace;

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }
        }

        public SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }

}
