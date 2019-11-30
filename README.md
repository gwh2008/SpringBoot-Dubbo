# SpringBoot-Dubbo
基于：https://github.com/battcn/swagger-spring-boot

      https://gitee.com/reger/spring-boot-starter-dubbo
      分布式事务：
      https://github.com/Dromara/Raincat
      
      https://dromara.org/website/zh-cn/docs/hmily/user-dubbo.html
      
#### 项目介绍
这是一个面向学习型的SpringBoot Dubbo基础项目!
#### 软件架构
软件架构说明
* SpringBoot
* Thymeleaf
* Dubbo
* Zookeeper
* MyBatis
* MySql
* Druid
* Lombok
* Swagger
#### 安装教程
1. xxxx
#### 使用说明
1. 通过: 协议://地址:端口/druid/index.html 访问Druid监控中心
2. Dubbo 监控中心 dubbo-admin-2.6.0.war 
3. Zookeeper 注册中心zookeeper-3.4.12.tar 
4.
 构建
 mvn clean package -Dmaven.test.skip=true
 
 java -jar provider-0.0.1-SNAPSHOT.jar --spring.dubbo.registry.address=127.0.0.1  --spring.dubbo.registry.port=2181 --server.port=8090

 java -jar consumer-0.0.1-SNAPSHOT.jar --spring.dubbo.registry.address=127.0.0.1  --spring.dubbo.registry.port=2181 --server.port=8070

  http://127.0.0.1:8070/user/getUser/1
  
  http://127.0.0.1:8070/swagger-ui.html
  
  http://127.0.0.1:8080/dubbo-admin-2.6.0   

全局异常测试：
http://127.0.0.1:8070/user/exce

附截图：

![Image text](https://github.com/gaowenhui/SpringDataJPA/blob/master/src/screenshots/20180313153024.png)
