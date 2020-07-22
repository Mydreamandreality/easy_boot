package com.geek.conding.business.model.rds;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:09
 * @Version v1.0
 * @Description 黑名单列表
 */
@Data
@Accessors(chain = true)
@TableName("sys_log")
public class SysBlackListDTO implements Serializable {
    private static final long serialVersionUID = -6091145922494139076L;
}
