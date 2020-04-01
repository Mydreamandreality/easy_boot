package com.geek.conding.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user model
 */
@Data
@TableName("sys_user")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6226593098773490023L;

    private Integer id;

    private String name;
}
