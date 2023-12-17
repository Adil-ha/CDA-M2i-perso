package org.example.thread;

class Thread1 extends Thread {

    private volatile boolean shouldTerminate = false;
    public Thread1(String name) {
        super(name);
    }

    public void terminate() {
        shouldTerminate = true;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            // La methode yield() permet de donner la main a un autre thread
//            Thread.yield();

            // La methode sleep() permet de stopper le thread pendant un temps en milliSeconde
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            // La methode destroy permet de detruire un thread
            if (i==5){
                terminate();
            }
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        for (char i = 'A'; i<'K'; i++) {
            System.out.println(i);
//            Thread.yield();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        // création d'un thread depuis la class Thread
        Thread1 t1 = new Thread1("threadNumber");

        // getName() Affiche le nom du thread
        //System.out.println(t1.getName());

        // getPriority() obtenir la priorité d'un thread
//        System.out.println("La priority de t1 est par default de : "+t1.getPriority());

        // setPriority changer la proprité d'un thread par default=5 MAX=10 ET MIN=1
//        t1.setPriority(10);

        // start() lancement du thread depuis la methode run()
        t1.start();

        t1.terminate();

        // création d'un thread depuis l'interface Runnable
        Thread2 t = new Thread2();
        Thread t2 = new Thread(t);
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(t2.getName());
//        t2.setPriority(10);
//        System.out.println("La priority de t2 est par default de : "+ t2.getPriority());

        t2.start();
        int [] array = new Array[2];


    }


}
