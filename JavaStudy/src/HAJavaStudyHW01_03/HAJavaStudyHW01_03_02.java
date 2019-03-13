package HAJavaStudyHW01_03;
class HAJavaStudyHW01_03_02 {

	public static void main(String args[]) {
		
		System.out.println("Main method start.");
		
		 Thread[] runThread = new Thread[5];
		 
		for(int i = 0; i < 5 ;i++ ) {
			runThread[i] = new Thread(new RunnableThread(i));
			runThread[i].start();
		}
		
		for(int i = 0; i < 5 ;i++ ) {
			try {
				runThread[i].join(); // wait for runThread[i] end. if join() method before start() method, it has Runtime Error. 
	        }catch(Exception e) { // when use join method, must be use Exception catch.
	        }
		}
		
		System.out.println("Main method end.");
	}

}
class RunnableThread implements Runnable {
	int index;
	public RunnableThread(int i) // constructor.
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