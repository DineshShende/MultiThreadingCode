package waitnotify;

public class App {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		final Worker worker=new Worker();
		
		Thread t1=new Thread(()->{try {worker.producer();} catch (InterruptedException e) {} });
		
		Thread t2=new Thread(()->{try {worker.consumer();} catch (InterruptedException e) {} });
		
		/*
		Thread t1=new Thread(new Runnable()
		{

			@Override
			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					
				}
				
			}
			
		});

		
		Thread t2=new Thread(new Runnable()
		{

			@Override
			public void run() {
				try {
					worker.consumer();
				} catch (InterruptedException e) {
					
				}
				
			}
			
		});
		*/
		
		t1.start();
		t2.start();
		
		try{
		t1.join();
		t2.join();
		}catch(Exception e)
		{
			
		}
		
	}

}
