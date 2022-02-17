import java.util.ArrayList;
import java.util.List;

public class Threads {
    public static int createdThreads = 0;
    public static int destroyedThreads = 0;
    public static void main(String args[]){
        problemOne();
    }


    public static void problemOne(){
        Long timeOne = System.currentTimeMillis();
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

        System.out.println("Main Thread Stopped");
        Long timeTwo = System.currentTimeMillis();
        System.out.println("Time to Complete: " + (timeTwo-timeOne) + " ms");
        System.out.println("Created Threads: " + Threads.createdThreads);
        System.out.println("Destroyed Threads: " + Threads.destroyedThreads);

    }
}
