package com.geek.conding.business.model.rds;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.aspectj.weaver.ast.Or;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:09
 * @Version v1.0
 * @Description 日志Model
 */
@Data
@Accessors(chain = true)
@TableName("sys_log")
public class SysLogDTO {

    private Integer id;

    private String ipAddress;

    private String uri;

    private Integer uId;

    private Integer tId;

    private String method;

    private String logTitle;

    private String logContent;

    private Date createTime;

    private String status;

    private SysUserDTO sysUserDTO;
}
