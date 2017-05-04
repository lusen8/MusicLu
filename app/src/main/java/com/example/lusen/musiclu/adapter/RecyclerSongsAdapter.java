package com.example.lusen.musiclu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lusen.musiclu.R;
import com.example.lusen.musiclu.activity.SongListActivity;
import com.example.lusen.musiclu.fragment.MusicPlayFragment;
import com.example.lusen.musiclu.json.SongData;

import java.util.ArrayList;
import java.util.List;

public class RecyclerSongsAdapter extends RecyclerView.Adapter<RecyclerSongsAdapter.ViewHolder> {

    private List<SongData.Result.Song> songDataList = new ArrayList<>();

    public RecyclerSongsAdapter(List<SongData.Result.Song> songDataList) {
        this.songDataList = songDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_song_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = songDataList.get(holder.getAdapterPosition()).getId();
                SongListActivity songListActivity = (SongListActivity) parent.getContext();
                songListActivity.replaceFragment(new MusicPlayFragment(id));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SongData.Result.Song song = songDataList.get(position);
        holder.songView.setText(song.getName() + "-" + song.getArtists().get(0).getName());
        holder.songDetail.setText(song.getAlbum().getName());
    }

    @Override
    public int getItemCount() {
        return songDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView songView;
        TextView songDetail;
        ImageView showPic;

        public ViewHolder(View itemView) {
            super(itemView);
            songView = (TextView) itemView.findViewById(R.id.songData);
            songDetail = (TextView) itemView.findViewById(R.id.songDetail);
        }
    }

}
