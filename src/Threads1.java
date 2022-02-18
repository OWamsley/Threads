import java.util.ArrayList;
import java.util.List;

public class Threads1 implements Runnable {
    Thread t;
    String name;

    private boolean exit;
    Threads1(String threadName){

        this.name = threadName;
        t = new Thread(this, this.name);
        Threads.createdThreads++;
        exit = false;
        t.start();
    }

    public void stop(){
        this.exit = true;
    }

    public void run(){
        while(!exit) {
            MyThread t;
            List<MyThread> threads = new ArrayList<MyThread>();

            for(int i = 0; i < 1000; i++){
                t = new MyThread(Integer.toString(i));
                threads.add(t);

            }

            for(int i = 999; i >= 0; i--){
                t = threads.get(i);
                t.stop();
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){

                }
            }
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
