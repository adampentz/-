package edu.cgcc.cs260;

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
		System.out.println();

	}

}
