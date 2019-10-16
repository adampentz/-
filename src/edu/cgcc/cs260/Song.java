package edu.cgcc.cs260;

/**
 * a song node that is used for the singly-linked play list
 * @author andrewb, cs260 class
 *
 */
public class Song {
	//members
		int id = 0;
		String name = null;
		double length = 0.0;
		Song next = null;
		String path = null;
		
		//constructor
		public Song(int i, String n, String p) {
			name = n;
			id = i;
			length = 3.0;
			path = p;
		}
		
		//member functions
}
