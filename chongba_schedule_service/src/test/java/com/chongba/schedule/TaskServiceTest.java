package com.chongba.schedule;

import com.chongba.entity.Task;
import com.chongba.schedule.inf.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by 传智播客*黑马程序员.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
public class TaskServiceTest {
    
    @Autowired
    private TaskService taskService;
    
    @Test
    public void testAdd(){
        Task task = new Task();
        task.setTaskType(3333);
        task.setPriority(250);
        task.setParameters("taskServcieTest".getBytes());
        task.setExecuteTime(System.currentTimeMillis());
        long taskId = taskService.addTask(task);
        System.out.println("添加完成的任务id:"+taskId);
    }
    @Test
    public void testCancel(){
        taskService.cancelTask(1182220694205763585L);
    }
    
    @Test
    public void testPollTask(){
        // 添加任务数据
        Date now = new Date();

        for(int i=0;i<3;i++){
            Task task = new Task();
            task.setTaskType(250);
            task.setPriority(250);
            task.setExecuteTime(now.getTime() + 5000 * i);
            task.setParameters("testpooltask".getBytes());
            taskService.addTask(task);
        }
        
        
        //消费
        while (taskService.size(250,250) > 0){
            Task task = taskService.poll(250,250);
            if(task != null){
                System.out.println("消费了任务:"+task);
            }
            //每隔1秒钟拉取一次
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }


    @Test
    public void testSyncDate(){

        for(int i=1;i<=3;i++){
            Task task = new Task();
            task.setTaskType(250);
            task.setPriority(250);
            task.setExecuteTime(new Date().getTime() + 5000 * i);
            task.setParameters("testpooltask".getBytes());
            taskService.addTask(task);
        }
    }



    @Test
    public void testPreLoad(){
        // 添加任务数据
        Date now = new Date();
        for(int i=0;i<3;i++){
            Task task = new Task();
            task.setTaskType(250);
            task.setPriority(250);
            task.setExecuteTime(now.getTime() + 50000 * i);
            task.setParameters("testpooltask".getBytes());
            taskService.addTask(task);
        }
        // 构造了三个任务：分别在 0  50   100 秒执行
        // 第一个任务加到消费者队列 立即被消费了
        // 第二个任务被加到了ZSet集合中,50秒后被消费
        // 第三个任务还在数据库中
        // 第60秒时 第三个任务从数据库被加载到ZSet中,40秒后被消费
        // 消费拉取任务
        while (true){
            Task task = taskService.poll(250,250);
            if(task !=null){
                System.out.println("成功消费了任务:"+task.getTaskId());
            }
            //每隔一秒消费一次
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
