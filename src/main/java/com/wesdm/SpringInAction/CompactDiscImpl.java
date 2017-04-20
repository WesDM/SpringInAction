package com.wesdm.SpringInAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("nevermind")
public class CompactDiscImpl implements CompactDisc{
	
	private static final Logger LOG = LoggerFactory.getLogger(CompactDiscImpl.class);
	private String artist;
	
	public CompactDiscImpl(@Value("${disc.artist}") String artist){
		this.artist = artist;
	}
	
	public void play() {
		
	}

	public void playTrack(int track) {
		
	}

}
