package com.jspiders.musicplayer.operations;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.musicplayer.songs.Songs;

public class SongsOpernation {
	
	static Scanner sc = new Scanner (System.in);
	
	Songs song1 = new Songs(1, "Faded", "Alan Walker", 3.32);
	Songs song2 = new Songs(2, "WonderLand", "Neoni", 3.15);
	Songs song3 = new Songs(3, "DarkSide", "Neoni", 3.30);
	Songs song4 = new Songs(4, "Lily", "Alan Walker", 3.00);
	Songs song5 = new Songs(5, "Perfect", "Ed Sheeran", 3.50);
	Songs song6 = new Songs(6, "Zara Zara", "Arjun Kanungo", 4.00);
	Songs song7 = new Songs(7, "Pasoori", "Shae Gill", 3.44);
	Songs song8 = new Songs(8, "Kesariya", "Arjit Singh", 3.40);
	Songs song9 = new Songs(9, "Yeh Haseen Vadiyan", "A.R.Rahman", 4.30);
	Songs song10 = new Songs(10, "Roja", "A.R.Rahman", 5.00);
	
	ArrayList<Songs> pl = new ArrayList<Songs>();
	
	public void createPlaylist() {
		pl.add(song1);
		pl.add(song2);
		pl.add(song3);
		pl.add(song3);
		pl.add(song4);
		pl.add(song5);
		pl.add(song6);
		pl.add(song7);
		pl.add(song8);
		pl.add(song9);
		pl.add(song10);
	}
	
	public void playAll() {
		for (Songs s : pl) {
			System.out.println(s.getSongName() + " from " + s.getSinger() +" is Now Playing..!!");
		}
	}
	
	public void playRandom() {
		double dNumber = Math.random()*10;
		int randomNumber = (int) dNumber;
		
		for(Songs s : pl) {
			int id = s.getsongId();
			if(randomNumber == id) {
				System.out.println(s.getSongName() + " from " + s.getSinger() +" is Now Playing..!!");
			}
		}
	}
	
	public void chooseSong() {
		for(Songs s : pl) {
			System.out.println(s);
		}
		System.out.print("\n Choose Any Song..!!");
		int choice = sc.nextInt();
		
		for(Songs s :pl) {
			if(choice == s.getsongId()) {
				System.out.println(s.getSongName() + " from " + s.getSinger() +" is Now Playing..!!");
			}
		}
	}
	
	public void addSong() {
		System.out.print("Enter Song ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\n Enter Song Name : ");
		String songname = sc.nextLine();
		
		System.out.print("\n Enter Singer Name : ");
		String singername = sc.nextLine();
		
		System.out.print("\n Enter Duration : ");
		double duration = sc.nextDouble();
		
		Songs newSong = new Songs(id, songname, singername, duration);
		pl.add(newSong);
		System.out.println("Song has been added Successfully..!!");
	}
	
	public void removeSong() {
		for(Songs s : pl) {
			System.out.println(s);
		}
		System.out.print("Enter Song ID to Remove Song : ");
		int remove = sc.nextInt();
		
		try {
			for(Songs s : pl) {
				int id = s.getsongId();
				if(id == remove) {
					pl.remove(remove -1);
				}
			}
		}
		catch (Exception e) {
			// handled exception
		}
		System.out.println("Removed Song Successfully..!!");
	}
	
	public void editsong() {
		for(Songs s : pl) {
			System.out.println(s);
		}
		System.out.print("Enter Song Id to Edit Song : ");
		int edit = sc.nextInt();
		
		for(Songs s : pl) {
			int id = s.getsongId();
			if(id == edit) {
				System.out.print("What you want to Edit \n 1. Song Name \n 2. Singer Name");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Enter New Song Name : ");
					sc.nextLine();
					String songName = sc.nextLine();
					s.setSongName(songName);
					System.out.println("Song Updated Succesfully..!!");
					break;
				
				case 2:
					System.out.print("Enter New Singer Name : ");
					sc.nextLine();
					String singerName = sc.nextLine();
					s.setSinger(singerName);
					System.out.println("Singer Name  Updated Succesfully..!!");
					
				case 3:
					break;
					
				default:
					System.out.println("Enter Valid Option..!!");
					break;
				}
			}
		}
	}
	
}
