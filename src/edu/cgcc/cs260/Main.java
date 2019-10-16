package edu.cgcc.cs260;
import java.util.Scanner;
import org.geeksforgeeks.*;

/**
 * program entry point for cs260, wk4, le2
 * @author andrewb, cs260 class
 *
 */
public class Main {

	public static void main(String[] args) {
		//instantiate new song play list
		Playlist songPlaylist = new Playlist();
		String root = "E:\\git\\cs260_wk4_le2_prep\\bin\\edu\\cgcc\\cs260\\";
		
		
		//insert songs
		songPlaylist.insert("Algorithms", root + "algorithms.wav");
		songPlaylist.insert("Moonwalk", root + "moonwalk.wav");
		songPlaylist.insert("Crescents", root + "crescents.wav");
		
		//Show how many songs the play list has
		System.out.println("The playlist has " + songPlaylist.length() + " song(s).");
		
		//Print song list
		System.out.println();
		songPlaylist.print();
		
		//Swap a song then print after swap
		songPlaylist.swap(songPlaylist.getSongAtPosition(2), songPlaylist.getSongAtPosition(1));
		System.out.println();
		songPlaylist.print();
		
		
		
		//Test audio play
		try {
			SimpleAudioPlayer player;
        	Scanner sc = new Scanner(System.in);
			
            for(int i = 0; i < songPlaylist.length(); i++) {
            	player = new SimpleAudioPlayer(songPlaylist.getSongAtPosition(i).path);
            	System.out.println();
            	System.out.println("Playing " + songPlaylist.getSongAtPosition(i).name);
            	 System.out.println("1. pause"); 
                 System.out.println("2. resume"); 
                 System.out.println("3. restart"); 
                 System.out.println("4. stop"); 
                 System.out.println("5. Jump to specific time");
            	while (true) 
                { 
                    
                    int c = sc.nextInt(); 
                    player.gotoChoice(c); 
                    if (c == 4) 
                    break; 
                } 
                
            	System.out.println("done");
            }
            
            sc.close(); 
		}
		catch(Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace()[0]);
		}

	}

}
