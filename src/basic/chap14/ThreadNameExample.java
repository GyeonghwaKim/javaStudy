package basic.chap14;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        System.out.println(main.getName()+" 실행");

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + " 실행");
                }
            };
            threadA.start();
        }

        Thread chatThread=new Thread(){
            @Override
            public void run() {
                System.out.println(getName()+" 실행");
            }
        };

        chatThread.setName("chat-thread");
        chatThread.start();
    }
}
