package music_player.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import music_player.operation.MusicPlayerOperator;
import music_player.song.Songs;

public class MusicPlayerMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Songs songs = new Songs();
		
		MusicPlayerOperator musicPlayerOperator = new MusicPlayerOperator();
		
		Scanner scanner = new Scanner(System.in);
		

		boolean condition = true;

		do {

			System.out.println(
					"======== MENU ========  \n1. Play a Song. \n2. Add/Remove Song. \n3. Edit Song. \n4. Exit.");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {

				System.out.println("Enter ID : ");
				songs.setId(scanner.nextInt());
				
				musicPlayerOperator.getSongsId(songs);

			}
				break;

			case 2: {
				
				boolean flag = true;
				
				do {
					
					System.out.println("Enter Your Choice : \n1. Add Song. \n2. Remove Song. \n3. Back to Menu.");
					int ch = scanner.nextInt();

					switch (ch) {
					case 1: {

						System.out.println("Enter ID : ");
						songs.setId(scanner.nextInt());
						
						System.out.println("Enter Song Name : ");
						songs.setName(scanner.next());
						
						System.out.println("Enter Singer Name : ");
						songs.setSinger(scanner.next());
						
						System.out.println("Enter Duration : ");
						songs.setDuration(scanner.next());
						
						musicPlayerOperator.addSong(songs);

					}
						break;

					case 2: {

						System.out.println("Enter ID : ");
						songs.setId(scanner.nextInt());
						
						musicPlayerOperator.removeSong(songs);

					}
						break;

					default:
						flag = false;
						
					}
					
				} while (flag);	

			}
				break;

			case 3: {

				System.out.println("Edited a Song");

			}
				break;

			default:
				condition = false;
			}

		} while (condition);

	}

}
