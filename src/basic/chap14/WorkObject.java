package basic.chap14;

public class WorkObject {
    public synchronized void methodA(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+": methodA 작업실행");

        notify();//다른 스레드를 실행 상태로
        try {
            wait();
        }catch (InterruptedException e) {}
    }

    public synchronized void methodB(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+": methodB 작업실행");

        notify();//다른 스레드를 실행 상태로
        try {
            wait();
        }catch (InterruptedException e) {}
    }
}
