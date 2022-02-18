import java.util.List;
import java.util.ArrayList;

public class Thread1 implements Runnable {
    Thread t;
    String name;
    private boolean exit;
    Thread1 parentThread;
    String parentThreadName;
    List<Thread1> childThreads;
    private int childThreadsAmount;
    int depth;

    Thread1(String threadName, Thread1 parentThread, int depth){
        this.depth = depth;
        this.name = threadName;
        this.parentThreadName = parentThread.name;
        this.childThreadsAmount = Threads.getThreads(depth);
        this.childThreads = new ArrayList<Thread1>();
        this.parentThread = parentThread;
        t = new Thread(this, this.name);
        System.out.println("Creating new Thread: " + t + " no: " + threadName + " p-no: " + parentThreadName);
        Threads.createdThreads++;
        exit = false;
        t.start();
    }

    Thread1(String threadName, int depth){
        this.depth = depth;
        this.name = threadName;
        this.parentThreadName = "none";
        this.childThreadsAmount = Threads.getThreads(depth);
        childThreads = new ArrayList<Thread1>();
        t = new Thread(this, this.name);
        System.out.println("Creating new Thread: " + t + " no: " + threadName + " p-no: " + parentThreadName);
        Threads.createdThreads++;
        exit = false;
        t.start();
    }


    public void run(){
        Thread1 thread;
        List<Thread1> threads = new ArrayList<Thread1>();
        synchronized (this) {
            for (int i = 0; i < this.childThreadsAmount; i++) {
                thread = new Thread1(this.name + "-" + i, this, this.depth + 1);
                threads.add(thread);
                childThreads.add(thread);
            }
        }
        do{
            try {
                Thread.sleep(1);
            }
            catch(Exception e){
            }
            synchronized (this) {
                if (!childThreads.isEmpty()) {
                    for (Thread1 child : this.childThreads) {
                        child.stop();
                    }
                }
            }


        }while(!(exit && childThreads.isEmpty()));

        if(this.parentThread != null) {
            this.parentThread.deadChild(this);
        }
        System.out.println("Destroyed Thread:  no: " + this.name + " p-no: " + parentThreadName);
        Threads.destroyedThreads++;
        if (parentThread == null){
            Threads.finished = true;
        }
    }

    public void stop(){
        this.exit = true;
    }

    public void deadChild(Thread1 thread){
        synchronized(this) {
            this.childThreads.remove(thread);
        }
    }
}
