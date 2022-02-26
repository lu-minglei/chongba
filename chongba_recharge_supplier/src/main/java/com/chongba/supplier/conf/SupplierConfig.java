package com.chongba.supplier.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by luMingLei
 */
@Data
@ConfigurationProperties(prefix = "supplier")
@Component
public class SupplierConfig {
    
    private Map<String,String> apis;

    private int maxrepeat;//最大重试次数

    private Map<String,String> checkStateApis;
    
    private int stateCheckTime; //订单充值状态检查时间
}
