package HAJavaStudyHW01_03;
class HAJavaStudyHW01_03_03 {

	public static void main(String args[]) {
		
		System.out.println("Main method start.");
		
		 Thread[] runThread = new Thread[8];
		 
		for(int i = 0; i < 8 ;i++ ) {
			runThread[i] = new Thread(new RunnableThread(i));
			
		}
		runThread[0].start(); // boot thread
		for(int i = 1; i < 8 ;i++ ) {
			try {
				runThread[i - 1].join(); // check thread finish
	        }catch(Exception e) {
	        }
	        runThread[i].start(); // if previous thread finish, start next thread.
		}
		System.out.println("Main method end.");
	}

}