package edu.cgcc.cs260;

public class MusicStack {
	//members
	private int top;
	public int maxSize;
	public Song[] stackArray;
	
	//member functions
	public MusicStack(int s) {
		maxSize = s;
		stackArray = new Song[maxSize];
		top = -1;
	}
	
	public void push(Song s) {
		if(isFull())
			pop();
		stackArray[++top] = s;
	}
	
	public Song pop() {
		return stackArray[top--];
	}
	
	public Song peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize -1);
	}
	
}
