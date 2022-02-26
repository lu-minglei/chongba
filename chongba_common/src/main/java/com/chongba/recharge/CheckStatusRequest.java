package com.chongba.recharge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by luMingLei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckStatusRequest {

    private String supplier;

    private String orderNo;

    private String tradeNo;
}
