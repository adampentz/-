package edu.cgcc.cs260;
import java.util.Random;

public class Helper {
	//#region Members
    private Random random;
    private long startTime;
    private long endTime;
    //#endregion
    
    /**Constructor instantiates new random object with seed and sets member to it.
     * 
     */
    public Helper(){
        random = new Random(System.currentTimeMillis());
    }

    //#region MemberFunctions
    /** Generates a random int array of n(input) size.
     * @param n Integer size of random array.
     * @return int[] array
     */
    public int[] generateRandomArray(int n){
        int[] iArray = new int[n];

        for (int i = 0; i < n; i++)
            iArray[i] = (int)(Math.random() * 1000) + 10;

        return iArray;
    }

    /** Generates a random 2d int array of n(input) size.
     * @param n Integer size of random array.
     * @return int[] array
     */
    public int[][] generateRandom2dArray(int n){
        //instantiate 2d array of n size
        int[][] iArray = new int[n][];

        //for all elements, make a nested array of random size between 1 and 10
        for (int i = 0; i < iArray.length; i++){
            int randArrSize = generateRandomIntBetweenRange(1, 10);
            int[] nestedArray = generateRandomArray(randArrSize);
            iArray[i] = nestedArray;
        }

        return iArray;
    }

    /** Generates a random int between range.
     * @param min Lower bound of the random numbers possible.
     * @param max Upper bound of the random numbers possible
     * @return int result of randomly generated number between min and max
     */
    public int generateRandomIntBetweenRange(int min, int max){
        //Use init random object member
        int randomInt = random.nextInt((max - min) + 1) + min;

        return randomInt;
    }

    /** Calculates polynomial function 30n^3 + 15n^2 + 10
     * @param n Set n to value.
     * @return int result of calculating polynomial
     */
    public int polyDemo(int n){
        return (30 * (n*n*n)) + (15 * (n*n)) + 10;
    }

    /** Calculate coefficient and n^3 from 30n^3 + 15n^2 + 10
     * @param n Set n to value.
     * @return int result of calculating first term of polynomial.
     */
    public int cubeDemo(int n){
        return 30 * (n*n*n);
    }

    /** Calculate coefficient and n^2 from 30n^3 + 15n^2 + 10
     * @param n Set n to value.
     * @return int result of calculating second term of polynomial.
     */
    public int squaredDemo(int n){
        return 15 * (n * n);
    }
    
    /** Print polynomial term example
	 * @param n integer to perform polynomial calculation
	 */
	public void printPolyDemo(int n) {
		System.out.println("30n^3 + 15n^2 + 10 = " + polyDemo(n) + ", n = " + n);
		System.out.println("n^3: " + cubeDemo(n) + ", n^2: " + squaredDemo(n) + ", 10");
		System.out.println();
	}

    /** Get current time for tracker start
     */
    public void timeTrackerStart(){
        startTime = System.nanoTime();
    }

    /** Get current time for tracker end
     */
    public void timeTrackerStop(){
        endTime = System.nanoTime();
    }

    /** Get elapsed time of stored start and end time in nano seconds
     * @return long.
     */
    public long elapsedTimeInNano(){
        return endTime - startTime;
    }

    /** Get elapsed time of stored start and end time in milliseconds
     * @return long.
     */
    public long elapsedTimeInMilli(){
        return (endTime - startTime) / 1000000;
    }
    
    /**
     * Wait for n number of seconds; print . while waiting to console; print done after
     * time period has elapsed
     * @param s Number of seconds for which to wait
     */
    public static void waitForNSeconds(int s) {
    	for(int i = 0; i < s; i++) {
			try {
				Thread.sleep(1000);
				System.out.print(".");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
    	System.out.println("done");
    }
    
    /**
     * 
     * @param max maximum integer to return
     * @return randomized integer
     */
    public int getRandomInt(int max) {
    	return random.nextInt(max);
    }
    //#endregion
}
