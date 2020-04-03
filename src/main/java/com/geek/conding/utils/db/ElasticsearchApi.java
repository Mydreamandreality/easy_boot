package com.geek.conding.utils.db;

import io.searchbox.client.JestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description ES检索操作封装
 */
@Component
public class ElasticsearchApi {

    @Autowired
    private JestClient jestClient;


}
