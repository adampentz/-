package edu.cgcc.cs260;

public class MusicQueue {
	//members
	private int maxSize;
	private Song[] queArray;
	private int front;
	private int rear;
	private int nItems;

	//member functions
	public MusicQueue(int s) {
		maxSize = s;
		queArray = new Song[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(Song j) {
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = j;
		nItems++;
	}


	public Song remove() {
		Song temp = queArray[front++];
		if (front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	public Song peekFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int size() {
		return nItems;
	}
}
