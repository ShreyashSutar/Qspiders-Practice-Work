package com.jspiders.musicplayer.main;

import java.util.Scanner;

import com.jspiders.musicplayer.operations.SongsOpernation;

public class MusicPlayer {

	static Scanner sc = new Scanner(System.in);
	
	private static void musicPlayer() {
		System.out.println("====== MENU ======");
		System.out.println("1. Play a Songs");
		System.out.println("2. Add/Remove Songs");
		System.out.println("3. Edit Songs");
		System.out.println("4. Exit");
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			songPlay();
			int play = sc.nextInt();
			
			switch (play) {
			case 1:
				so.playAll();
				System.out.println("\n");
				musicPlayer();
				break;
				
			case 2:
				so.playRandom();
				System.out.println("\n");
				musicPlayer();
				break;
				
			case 3:
				so.chooseSong();
				System.out.println("\n");
				musicPlayer();
				break;
				
			case 4:
				musicPlayer();
				System.out.println("\n");
				break;
				
			default:
				System.out.println("Enter Valid Action");
				System.out.println("\n");
				musicPlayer();
				break;
			}
			break;
			
		case 2:
			addorRemove();
			int song = sc.nextInt();
			
			switch (song) {
			case 1:
				so.addSong();
				System.out.println("\n");
				musicPlayer();
				break;
				
			case 2:
				so.removeSong();
				System.out.println("\n");
				musicPlayer();
				break;
				
			case 3:
				musicPlayer();
				break;
				
			default:
				System.out.println("Enter Valid Action");
				System.out.println("\n");
				musicPlayer();
				break;
			}
			break;
		
		case 3:
			so.editsong();
			musicPlayer();
			break;
			
		case 4:
			System.out.println("Thank You..!! \n by Shreyash Sutar");
			break;
			
		default:
			System.out.println("Please Enter Valid Action..!!");
			System.out.println("\n");
			musicPlayer();
			break;
		}
	}
	
	private static void songPlay() {
		System.out.println("1. Play All Songs.");
		System.out.println("2. Play Random Songs.");
		System.out.println("3. Choose To Play.");
		System.out.println("4. Go Back.");
	}
	
	private static void addorRemove() {
		System.out.println("1. Add Song.");
		System.out.println("2. Remove Song.");
		System.out.println("3. Go Back.");
	}
	
	static SongsOpernation so = new SongsOpernation();
	
	public static void main(String[] args) {
		
		so.createPlaylist();
		
		musicPlayer();
	}
}
