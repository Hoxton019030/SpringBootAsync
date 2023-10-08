package com.example.asyncpractice.Task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    @Async
    public void testAsync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("非同步測試執行，執行緒為：" + Thread.currentThread().getName());
    }

    @Async
    public void sendEmail(int mailNumber) {
        for (int i = 1; i < mailNumber + 1; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("寄出第" + i + "封信，所使用的執行緒是" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    @Async
    public void asyncExecutor(ExecuteInterface executeInterface) {
        executeInterface.execute();
    }
}
