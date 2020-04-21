package com.geek.conding.business.model.es;

import io.searchbox.annotations.JestId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/2 21:42
 * @Version v1.0
 * @Description 流量数据
 */
@Data
@Accessors(chain = true)
public class FlowDTO implements Serializable {

    private static final long serialVersionUID = -1907889817845385625L;

    @JestId
    private String id;

    private String ip;

    private String hostname;

    private String system;
}
