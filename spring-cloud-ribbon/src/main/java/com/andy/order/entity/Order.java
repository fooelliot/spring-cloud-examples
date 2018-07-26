package com.andy.order.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author: Mr.lyon
 * @createBy: 2018-06-21 21:30
 **/
@Data
@ApiModel("订单模型")
public class Order {

    private Long id;

    private String orderId;

    private String receiveId;

    private String buyerNick;

    private Integer postFee;

    private Integer totalFee;

    private String buyerRate;

    private Byte status;

    private String remark;

    private String outTradeNum;

    private String createIp;

    private String description;

    private Date createTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private Date payTime;

}
