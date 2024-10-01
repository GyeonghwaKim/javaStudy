package chap14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 100; i++) {
            final int idx=i;
            Future<Integer> future=executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum=0;
                    for (int j = 1; j <=idx; j++) {
                        sum+=j;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.println("[ "+thread.getName()+" ] 1~"+idx+"합 계산");
                    return sum;
                }
            });

            try{
                int result=future.get();
                System.out.println("\t리턴 값:" +result);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
