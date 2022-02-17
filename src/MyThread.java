public class MyThread implements Runnable {
    Thread t;
    String name;
    private boolean exit;
    MyThread(String threadName){
        this.name = threadName;
        t = new Thread(this, this.name);
        System.out.println("Creating new Thread: " + t);
        Threads.createdThreads++;
        exit = false;
        t.start();
    }

    public void stop(){
        this.exit = true;
    }

    public void run(){
        while(!exit) {
            try {
                Thread.sleep(1);
            }
            catch(Exception e){
                System.out.println("Caught " + e);
            }
        }
        Threads.destroyedThreads+=1;
        System.out.println("Destroying thread: " + this.name);
    }
}
