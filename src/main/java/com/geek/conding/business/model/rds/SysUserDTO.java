package com.geek.conding.business.model.rds;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user model
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = -6226593098773490023L;

    /**
     * name: 账户名称
     * address: 收货地址
     * accountId: 账号标识（唯一）
     * memberLevel: 会员等级
     */

    private Integer id;

    private String name;

    private String address;

    private String accountId;

    private SysMemberLevelDTO memberLevel;

    private List<SysOrderDTO> orders;
}
