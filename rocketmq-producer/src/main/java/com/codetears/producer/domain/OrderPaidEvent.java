package com.codetears.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author l'amour solitaire
 * @description TODO
 * @date 2019/12/18 下午8:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaidEvent implements Serializable {

    private String orderId;

    private BigDecimal paidMoney;
}
