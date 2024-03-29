package com.fave100.samples.gwtprest.shared;

import java.io.Serializable;

public class FaveItem {

	private String id;
	private String song;
	private String artist;
	private String whyline;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getWhyline() {
		return whyline;
	}
	
	public void setWhyline(String whyline) {
		this.whyline = whyline;
	}
	
}
