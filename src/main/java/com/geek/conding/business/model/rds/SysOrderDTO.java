package com.geek.conding.business.model.rds;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:09
 * @Version v1.0
 * @Description 订单Model
 */
@Data
@Accessors(chain = true)
@TableName("sys_order")
public class SysOrderDTO implements Serializable {

    private static final long serialVersionUID = -8247678550303825480L;

    /**
     * orderName : 订单名称（说明）
     * orderTime : 订单产生时间
     * orderMoney : 订单金额
     * orderId: 订单标识
     * userDto : 订单用户
     */

    private Integer id;

    private String orderId;

    private String orderName;

    private Date orderTime;

    private BigDecimal orderMoney;

    private SysUserDTO sysUserDTO;
}
