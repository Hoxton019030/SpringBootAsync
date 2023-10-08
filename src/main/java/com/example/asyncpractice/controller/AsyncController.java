package com.example.asyncpractice.controller;

import com.example.asyncpractice.Task.AsyncTask;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor()
public class AsyncController {

    private final AsyncTask asyncTask;

    /**
     * 透過觀查打印順序，理解非同步
     * @return
     */
    @GetMapping("/")
    public String testAsync() {
        System.out.println("開始測試，執行緒為 - " + Thread.currentThread().getName());
        asyncTask.testAsync();
        System.out.println("測試結束，執行緒為 - " + Thread.currentThread().getName());
        return "非同步測試";
    }

    @GetMapping("/email")
    public String sendEmail() {
        System.out.println("開始測試，執行緒為 - " + Thread.currentThread().getName());
        asyncTask.sendEmail(10);
        System.out.println("測試結束，執行緒為 - " + Thread.currentThread().getName());
        return "非同步寄出Email";
    }

    @GetMapping("/executor")
    public String executeAsyncTask(){
        asyncTask.asyncExecutor(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("我在做非同步工作耶！");
        });

        return "非同步執行器";
    }


}
