package com.example.lusen.musiclu.json;

import java.util.List;

public class SongData {

    private  int code;     //1
    private Result result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "SongData{" +
                "code=" + code +
                ", result=" + result +
                '}';
    }

    public void setResult(Result result) {
        this.result = result;
    }
    //*************************************************************************
    public class Result {

        private List<Song> songs;
        private int songCount;

        public List<Song> getSongs() {
            return songs;
        }  //<----歌曲列表

        public void setSongs(List<Song> songs) {
            this.songs = songs;
        }

        public int getSongCount() {
            return songCount;
        }

        public void setSongCount(int songCount) {
            this.songCount = songCount;
        }
        //***************************************************************************
        public class Song {

            private int id;   //2
            private String name;  //3
            private List<Artist> artists;
            private Album album;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Artist> getArtists() {
                return artists;
            }

            public void setArtists(List<Artist> artists) {
                this.artists = artists;
            }

            public Album getAlbum() {
                return album;
            }

            public void setAlbum(Album album) {
                this.album = album;
            }
            //***************************************************************
            public class Artist {
                private int id;
                private String name;  //4
                private String img1v1Url;   //5

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }
            }

            public class Album {
                private int id;
                private String name;  //歌曲描述 || Album专辑描述

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

        }

    }

}
