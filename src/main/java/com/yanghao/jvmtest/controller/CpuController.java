package com.yanghao.jvmtest.controller;

import com.yanghao.jvmtest.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: jvmtest
 * @description:死循环例子
 * @author: yanghao
 * @create: 2019-03-15 14:33
 **/
@RestController
public class CpuController {

    /**演示死循环
     * -Xmx 32M  -Xms 32M
     * @return
     */
    @GetMapping("/death")
    public String death(){
        for (int i = 0;i<Integer.MAX_VALUE;i++){
            System.out.println(Thread.currentThread().getName()+"::"+i);
        }
        return "success death";
    }

    /**演示死锁
     * -Xmx 32M  -Xms 32M
     * @return
     */
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    @GetMapping("/deathlock")
    public String deathlock(){
        new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                    synchronized (lock2){
                        System.out.println("Thread1 over!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1000);
                    synchronized (lock1){
                        System.out.println("Thread2 over!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return "success deathlock";
    }
}
