package edu.cgcc.cs260;

/**
 * program entry point for cs260, wk4, le2
 * @author andrewb, cs260 class
 *
 */
public class Main {

	public static void main(String[] args) {
		//instantiate new song play list
		Playlist songPlaylist = new Playlist();
		
		//insert songs
		songPlaylist.insert("White and Nerdy");
		songPlaylist.insert("Basket Case");
		songPlaylist.insert("Pompeii");
		songPlaylist.insert("Roar");
		songPlaylist.insert("Oops! I did it again");
		
		//Show how many songs the play list has
		System.out.println("The playlist has " + songPlaylist.length() + " song(s).");
		
		//Print song list
		System.out.println();
		songPlaylist.print();
		
		//Swap a song then print after swap
		songPlaylist.swap(songPlaylist.getSongAtPosition(3), songPlaylist.getSongAtPosition(1));
		System.out.println();
		songPlaylist.print();

	}

}
