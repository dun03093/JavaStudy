package HAJavaStudyHW01_03;
class HAJavaStudyHW01_03_01 {

	public static void main(String args[]) {
		
		System.out.println("Main method start."); // main method start.
		
		Thread[] extendedlThread = new ExtendedThread[5]; // make thread array. 
		
		for(int i = 0; i < 5 ;i++ ) {
			extendedlThread[i] = new ExtendedThread(i); // initialize each array's element.
			extendedlThread[i].start(); // start thread. *!!! PLEASE DON'T USE thread.run(); !!!*
		}
		
		System.out.println("Main method end."); // main method end.
	}

}
class ExtendedThread extends Thread {
	int index;
	public ExtendedThread(int i) // constructor
	{
		this.index = i;
	}
	public void run() {
		System.out.println("Thread #" + this.index + " start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {

        }
        System.out.println("Thread #" + this.index + " end.");
	}
}