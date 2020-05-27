/**
 * Copyright © 2020 SCF. All rights reserved
 * @ Study 
 * @author WangY
 * 2020年5月21日
 */
package com.simple.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {

    public static void main(String[] args) {
                 //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
                 ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
                
                 //延迟1秒后每3秒执行一次
                 scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
                     public void run() {
                         System.out.println("延迟1秒后每3秒执行一次");
                     }
                }, 1, 2, TimeUnit.SECONDS);
                 
             }
    
}