package com.geek.conding.utils.bean;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author 孤
 * @version v1.0
 * @Developers 张耀烽
 * @serviceProvider 四叶草安全(SeClover)
 * @description Application配置
 * @date 2020/4/8
 */

public class ApplicationHolder {

    /**
     * 获取app项目配置
     *
     * @param application
     * @return
     */
    public static Properties getApplication(String application) {
        Resource resource = new ClassPathResource(application);
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props;
        } catch (IOException e) {
            return null;
        }
    }

}
