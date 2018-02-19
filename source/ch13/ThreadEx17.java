 class ThreadEx17 {
	public static void main(String args[]) {
		ThreadEx17_1 th1 = new ThreadEx17_1("*");
		ThreadEx17_1 th2 = new ThreadEx17_1("**");
		ThreadEx17_1 th3 = new ThreadEx17_1("***");
		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000);
			th1.suspend();		
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {}
	}
}

class ThreadEx17_1 implements Runnable {
	boolean suspended = false;
	boolean stopped   = false;

	Thread th;

	ThreadEx17_1(String name) {
		th = new Thread(this, name); // Thread(Runnable r, String name)
	}

	public void run() {
		while(!stopped) {
			if(!suspended) {
                System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}			
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}

	public void suspend() { suspended = true;  }
	public void resume()  { suspended = false; }
	public void stop()    { stopped   = true;  }
	public void start()   { th.start();        }
}
