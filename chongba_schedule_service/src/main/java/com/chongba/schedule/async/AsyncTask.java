package com.chongba.schedule.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by luMingLei
 */
@Component
public class AsyncTask {
    
    @Async("mythreadpool")
    public void asyncTask(){
        
        System.out.println("spring boot async task test " +
                Thread.currentThread().getName());
    }
}
