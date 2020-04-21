# easy_boot

[![GitHub release](https://img.shields.io/github/release/xuxueli/xxl-job.svg)](https://github.com/Mydreamandreality/easy_boot)

## 一、简介

### 1.1 概述
easy-boot是SpringBoot快速开发的通用框架，其核心设计目标是减少项目开发中基础模块的设计和开发，
该框架本身不做业务层的代码开发，只提供核心的解决方案提供给开发人员使用，让开发人员能够快速的、简单的、可扩展的进行业务开发，达到开箱即用的效果

### 1.2 框架
- 1、语言：基于JDK13进行开发，基于JDK13对于使用该项目进行学习的同学是很友好的，可以学习到很多的新特性
不过考虑到大部分伙伴的生产环境都是1.8的版本，所以如果需要替换的话可以直接修改pom文件中的JDK版本即可
- 2、Web框架：采用SpringBoot-2.2.5.RELEASE版本进行开发
- 3、ORM框架：ORM使用Mybatis-plus框架进行集成开发，(Mybatis-Plus是基于Mybatis的增强版，功能强悍
- 4、中间件：Redis、Elasticsearch、MySQL、Zookeeper、XXL-JOB，Swagger等
- 5、安全框架：Shiro或者SpringSecurity(这个还没想好，到时候再看吧
- 6、工具库：提供高频工具、GoogleGuava等

### 1.3 能力
- 1、基于SpringBoot，简化大量的XML文件配置和项目依赖
- 2、使用Mybatis-plus，使用JPA快速开发简单业务，使用传统XML开发核心业务，简单易扩展，包括多数据源方案等
- 3、提供Redis核心功能：数据缓存、消息队列、消息广播- 全部使用Redis搞定
- 4、提供全文检索、数据统计功能：基于Elasticsearch7.x(最新版本)，并且兼容5.x-7.x之间所有的ES版本
- 5、分布式锁的实现：分布式锁(Redis、Zookeeper、MySQL)提供三种解决方案，自由选择，快速插拔解决业务痛点
- 6、分布式限流的实现：单机提供令牌桶限流方案，分布式提供Redis分布式限流解决方案，根据自身业务自由选择
- 7、分布式任务调度：使用主流开源方案实现 XXL-JOB
- 8、全局异常处理：全局异常被拦截后，发送到Redis消息队列，由Server运维模块处理异常请求日志
- 9、全局告警：在产生异常请求日志或者触发其它策略时，提供告警接口：邮件告警、短信告警、钉钉告警数据推送等
- 10、提供后端常用工具：定时任务、异步任务管理，自定义注解等
- 11、提供统一鉴权模块：基于Shiro的用户权限模块
- 12、提供Server运维模块：运维模块的核心功能为【分布式任务调度管理、限流阀值更新、异常日志处理等】

### 1.4 安全
小弟本身是搞信息安全开发的，所以对于安全比较敏感，在easy-boot中我会提供目前主流的安全解决方案，尽可能的保证项目本身的稳固性
- 1、公私钥验签
- 2、常见Hash算法
- 3、数据库Hash(加盐+pwd)存储
- 4、基于JWT的身份验证
- 5、统一的鉴权模块

## 二、更新记录
- 1、目前项目还在开发中、如果感兴趣想要一起开发或者学习可以加WX:17610096728讨论

## 三、文档
- 1、项目开发中我会把一些比较核心的功能整理成文档形式提供给大家
- 2、不熟悉Elasticsearch和SpringBoot的同学可以先去看我的博客提前学习
- 3、对Spark和Hadoop感兴趣的也可以去我的博客学习

## 博客地址
https://blog.csdn.net/youbitch1

## V1.0开发记录
- 1、集成Elasticsearch、Redis、Swagger等
- 2、增加系统日志切面注解
- 3、增加异步队列推送系统日志
- 4、新增logback配置
- 5、修改项目目录结构
- 6、新增Redis订阅/发布案例