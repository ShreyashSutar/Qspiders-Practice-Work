package com.jspiders.musicplayer.songs;

import java.util.ArrayList;

public class Songs {
	
	private ArrayList playList = new ArrayList(); 
	private int songId;
	private String songName;
	private String singer;
	private double duration;
	
	public int getsongId() {
		return songId;
	}
	public void setsongId(int songId) {
		this.songId = songId;
	}
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public ArrayList getplayList() {
		return playList;
	}
	public void setplayList(Object o) {
		playList.add(o);
	}
	
	
	public Songs(int songId, String songName, String singer, double duration) {
		this.songId = songId;
		this.songName = songName;
		this.singer = singer;
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Song Id = " + songId + " Song Name = " + songName + " Singer Name = " + singer
				+ " Duration = " + duration;
	}
	
	
	
	
}
