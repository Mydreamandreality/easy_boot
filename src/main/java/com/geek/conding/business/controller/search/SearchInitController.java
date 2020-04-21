package com.geek.conding.business.controller.search;

import com.geek.conding.business.base.GeekException;
import com.geek.conding.business.constants.ElasticsearchConstants;
import com.geek.conding.business.constants.enums.GeekExceptionMsg;
import com.geek.conding.business.model.es.FlowDTO;
import com.geek.conding.business.constants.response.ServiceResult;
import com.geek.conding.utils.SnowFlake;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * @Author 张耀烽
 * @Date Created in 2020/4/2 21:47
 * @Version v1.0
 * @Description 初始化数据
 */
@RestController
@RequestMapping("/geek/api/v1/search")
public class SearchInitController {
    @Autowired
    private JestClient jestClient;

    @GetMapping("/init")
    public ServiceResult<String> init() {
        FlowDTO flowDTO = new FlowDTO()
                .setId(SnowFlake.nextId())
                .setIp("1.1.1.1")
                .setHostname("my_computer")
                .setSystem("windows");
        Index index = new Index.Builder(flowDTO).index(ElasticsearchConstants.elasticsearch_index).type("test").build();
        try {
            DocumentResult documentResult = jestClient.execute(index);
            return ServiceResult.success(documentResult.getJsonString());
        } catch (IOException e) {
            throw new GeekException(GeekExceptionMsg.ES_INIT_ERROR);
        }
    }
}
