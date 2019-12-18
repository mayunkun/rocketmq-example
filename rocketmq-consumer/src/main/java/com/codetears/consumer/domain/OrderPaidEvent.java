package com.codetears.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author l'amour solitaire
 * @description TODO
 * @date 2019/12/18 下午3:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaidEvent implements Serializable {

    private String orderId;

    private BigDecimal paidMoney;
}
