package chap14;

public class PrintThread extends Thread{
    //조건이용
    private boolean stop;

    @Override
    public void run() {
        while (!stop){
            System.out.println("실행 중");
        }
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }

    public void setStop(boolean stop){
        this.stop=stop;
    }
}
