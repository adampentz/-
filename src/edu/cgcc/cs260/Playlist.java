package edu.cgcc.cs260;

public class Playlist {
	//members
		Song head = null;
		
		//member functions
		/**
		 * Insert a new node into list
		 * @param name String name of song
		 */
		public void insert(String name) {
			//Create a new song
			Song new_song = new Song(createUniqueID(), name);
			
			//if there isn't a head, make new_song as head
			if(this.head == null) {
				this.head = new_song;
			}
			//else put the song at the end of the list
			else {
				Song last = this.head;
				while(last.next != null) {
					last = last.next;
				}
				
				//insert the new_song at last position
				last.next = new_song;
			}
		}
		
		/**
		 * Remove from Singly-linked list by key or unique identifier
		 * @param id integer identify of Song node
		 */
		public void removeById(int id) {
			//start at first song and track prevSong
			Song currSong = this.head;
			Song prevSong = null;
			
			//Case 1:
			//first song holds the key to be deleted
			if(currSong != null && currSong.id == id) {
				this.head = currSong.next;
				
				System.out.println(currSong.name + "(" + currSong.id + ") found and deleted.");
				
				return;
			}
			
			//Case 2:
			//If the key is in some other node
			while(currSong != null && currSong.id != id) {
				//if currSong song does not hold key
				//continue to next song and track previous song
				prevSong = currSong;
				currSong = currSong.next;
			}
			
			//If the id is present, remove it
			if(currSong != null) {
				prevSong.next = currSong.next;
				
				//Display notice to user
				System.out.println(currSong.name + "(" + currSong.id + ") was found and deleted.");
			}
			
			//Case 3:
			//If the id wasn't found let us know
			if(currSong == null) {
				//Display notice
				System.out.println("(" + id + ") Song not found.");
			}
		}
		
		/**
		 * Remove Song from play list at a given position
		 * @param i integer representing position of song in list
		 */
		public void removeAtPosition(int i) {
			int position = 0; //index of song in list
			Song currSong = this.head; //start with the head as current song
			
			//Go through list until position is found
			while(currSong != null) {
				if(position == i) {
					removeById(currSong.id);
					return;
				}
				position++;
				currSong = currSong.next;
			}
			
			System.out.println("No song was found at position: " + i);
		}
		
		/**
		 * Print song information by position in list
		 * @param i integer of song position in play list
		 */
		public Song getSongAtPosition(int i) {
			int position = 0;
			Song currSong = this.head;
			
			//Case 1: head is null thus no song can be found
			if(currSong == null) {
				System.out.println("Playlist is empty.");
				return null;
			}
			
			//Case 2: Go through list until position is found
			while(currSong != null) {
				if(position == i) {
					return currSong;
				}
				position++;
				currSong = currSong.next;
			}
			
			//Case 3: position doesn't exist in the play list
			System.out.println("No song was found at position: " + i);
			return null;
		}
		
		/**
		 * Print song information by ID in list
		 * @param i integer representing Song id
		 */
		public Song getSongById(int i) {
			Song currSong = head;
			
			//Case 1: head is null so return null
			if(currSong == null) {
				return null;
			}
			
			//Case 2: go through list until song is found
			while(currSong != null) {
				if(currSong.id == i) {
					return currSong;
				}
			}
			
			//Case 3: song doesn't exist in the play list with given ID
			System.out.println("No song was found with ID: " + i);
			return null;
		}
		
		/**
		 * create a unique ID for song
		 * @return unique ID based on existing values in list
		 */
		private int createUniqueID() {
			Song currSong = this.head;
			int id = 100;
			
			//Return starting ID if no head exists
			if(currSong == null) {
				return id;
			}
			
			//traverse through the song list
			while(currSong != null) {
				//get the highest id in the list
				if(currSong.id > id) {
					id = currSong.id;
				}
				
				//go to next node
				currSong = currSong.next;
			}
			
			//quick and dirty increment
			return id * 3 + 1;
		}
		
		/**
		 * Get the number of Songs in the list
		 * @return integer number of Songs in play list
		 */
		public int length() {
			int count = 0;
			Song currSong = this.head;
			
			if(currSong == null) {
				return count;
			}
			
			while(currSong != null) {
				count++;
				currSong = currSong.next;
			}
			
			return count;
		}
		
		/**
		 * Swap song positions in list
		 * @param first first song needing to be swapped
		 * @param second second song needing to be swapped
		 */
		public void swap(Song first, Song second) {
			//Case 1: if songs are the same, don't swap them
			if(first == second) {
				return;
			}
			
			//Find firstSong
			Song prevFirst = null;
			Song currFirst = this.head;
			
			while(currFirst != null && currFirst != first) {
				prevFirst = currFirst;
				currFirst = currFirst.next;
			}
			
			//Find secondSong
			Song prevSecond = null;
			Song currSecond = this.head;
			
			while(currSecond != null && currSecond != second) {
				prevSecond = currSecond;
				currSecond = currSecond.next;
			}
			
			//Case 2: either node is null, do nothing
			if(currFirst == null || currSecond == null) {
				return;
			}
			
			//Case 3: if first is not head of linked list
			if(prevFirst != null) {
				prevFirst.next = currSecond;
			}
			else {
				this.head = currSecond;
			}
			
			//Case 4: if second is not head of linked list
			if(prevSecond != null) {
				prevSecond.next = currFirst;
			}
			else {
				this.head = currFirst;
			}
			
			//Swap the next pointers
			Song temp = currFirst.next;
			currFirst.next = currSecond.next;
			currSecond.next = temp;
		}
		
		/**
		 * randomly shuffle the play list
		 */
		public void shuffle() {
			Helper helper = new Helper();
			
			for(int i = 0; i < length(); i++) {
				swap(getSongAtPosition(i), getSongAtPosition(helper.getRandomInt(length() -1)));
			}
		}
		
		/**
		 * Representation of playing the play list in console
		 */
		public void play() {
			Song currSong = this.head;
			
			while(currSong != null) {
				System.out.print("Playing: " + currSong.name);
				Helper.waitForNSeconds((int)currSong.length);
				currSong = currSong.next;
			}
			
			System.out.println("Playlist finished");
		}
		
		/**
		 * Print the song list to console
		 */
		public void print() {
			Song currSong = this.head;
			
			System.out.println("Song List: ");
			
			//traverse through the song list
			while(currSong != null) {
				//print out song name to console
				System.out.print("(" + currSong.id + ")" + currSong.name);
				System.out.print("  ");
				
				//go to next node
				currSong = currSong.next;
			}
			System.out.println();
		}
}
