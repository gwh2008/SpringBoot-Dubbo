# SpringBoot-Dubbo
基于：
      SpringBoot2集成Swagger：
      https://github.com/battcn/swagger-spring-boot

      SpringBoot2集成Dubbo：
      https://gitee.com/reger/spring-boot-starter-dubbo
      
      分布式事务（异步分布式事务TCC框架hmily）：
      https://github.com/Dromara/Raincat
      https://dromara.org/website/zh-cn/docs/hmily/user-dubbo.html
      
      redisson实现redis分布式锁:
      https://github.com/TaXueWWL/redis-distributed-lock
      
#### 项目介绍
这是一个脚手架SpringBoot Dubbo基础项目!

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
* Swagger2
* Redis分布式锁
* 异步分布式事务TCC框架hmily
* RabbitMQ

#### 安装教程
1. 见文档

#### 使用说明
1. 通过: 协议://地址:端口/druid/index.html 访问Druid监控中心
2. Dubbo 监控中心 dubbo-admin-2.6.0.war 
3. Zookeeper 注册中心zookeeper-3.4.12.tar 
4. 构建
 mvn clean package -Dmaven.test.skip=true
 
 java -jar provider-0.0.1-SNAPSHOT.jar --spring.dubbo.registry.address=127.0.0.1  --spring.dubbo.registry.port=2181 --server.port=8090

 java -jar consumer-0.0.1-SNAPSHOT.jar --spring.dubbo.registry.address=127.0.0.1  --spring.dubbo.registry.port=2181 --server.port=8070

  http://127.0.0.1:8070/user/getUser/1
  
  http://127.0.0.1:8070/swagger-ui.html
  
  http://127.0.0.1:8080/dubbo-admin-2.6.0   

全局异常测试：
http://127.0.0.1:8070/user/exce

附截图：

![Image text](https://github.com/gwh2008/SpringBoot-Dubbo/blob/master/SQL/20191130180355.png)

![Image text](https://github.com/gwh2008/SpringBoot-Dubbo/blob/master/SQL/20191130180501.png)

![Image text](https://github.com/gwh2008/SpringBoot-Dubbo/blob/master/SQL/20191130180548.png)




