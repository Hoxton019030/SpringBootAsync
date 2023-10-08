package com.example.asyncpractice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class AsyncService {

    @Async
    void print() throws InterruptedException {
        Thread.sleep(5000);
        Date data = new Date();
        System.out.println(data+"非同步執行");
    }
}
