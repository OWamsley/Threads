import java.util.ArrayList;
import java.util.List;

public class Threads {
    public static int createdThreads = 0;
    public static int destroyedThreads = 0;
    public static boolean finished = false;
    public static void main(String args[]){
        Long timeOne = System.currentTimeMillis();
        Thread1 mythread = new Thread1("parent", 1);
        mythread.stop();
        while(!finished){
            try {
                Thread.sleep(20);
            }
            catch(Exception e){

            }
        }
        Long timeTwo = System.currentTimeMillis();
        System.out.println("Time to Complete: " + (timeTwo-timeOne) + " ms");
        System.out.println("Created Threads: " + Threads.createdThreads);
        System.out.println("Destroyed Threads: " + Threads.destroyedThreads);
    }

    public static int getThreads(int depth){
        if (depth ==1){
            return 100000;

        }
        //if (depth == 2){
         //   return 100;
        //}
        //if(depth == 3){
         //   return 10;
        //}
        return 0;
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

    public static void problemTwo(){
        Long timeOne = System.currentTimeMillis();
        Threads1 t;
        List<Threads1> threads = new ArrayList<Threads1>();

        for(int i = 0; i < 100; i++){
            t = new Threads1(Integer.toString(i));
            threads.add(t);

        }

        for(int i = 99; i >= 0; i--){
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
