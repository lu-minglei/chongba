package com.chongba.schedule.utils;

import lombok.Data;

import java.util.List;

/**
 * Created by luMingLei
 */
@Data
public class SqlBean {

    private int db_count;//数据库数量

    private int taskinfo_count;//taskinfo表数量

    private List<String> taskinfo_logs_monthList;//takinfo_logs表后缀集合
}
