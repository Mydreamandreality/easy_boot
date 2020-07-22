package com.geek.conding.business.model.rds;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:09
 * @Version v1.0
 * @Description 订单Model
 */
@Data
@Accessors(chain = true)
@TableName("sys_member_level")
public class SysMemberLevelDTO implements Serializable {
    private static final long serialVersionUID = -5054103072136046986L;

    /**
     * levelCode: 会员等级
     * levelName: 等级名称
     * isShow: 是否展示
     * levelDes: 等级说明(会员权益等)
     * createTime: 创建时间
     */

    private Integer id;

    private Integer levelCode;

    private String levelName;

    private Integer isShow;

    private String levelDes;

    private Date createTime;
}
