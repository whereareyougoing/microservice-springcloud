package com.demo.eureka.order.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 宋艾衡
 * @date 2019/5/23 16:32
 * @desc
 */
public class Order {

    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private Double price;
    @Getter@Setter
    private String receiverName;
    @Getter@Setter
    private String receiverAddress;
    @Getter@Setter
    private String receiverPhone;




}
