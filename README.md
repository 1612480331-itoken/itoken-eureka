
spring cloud Eureka服务注册与发现
> **yls**   
> *2020/5/5*
# 创建注册管理中心
## 1.添加依赖
```xml
<!--服务注册中心 start-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <!--服务注册中心 end-->
```
## 2.在启动程序添加注解`@EnableEurekaServer`
```java
@EnableEurekaServer
@SpringBootApplication
public class ItokenEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItokenEurekaApplication.class, args);
    }
}
```
## 3.创建配置文件`application.yml`
```yaml
spring:
  application:
    name: itoken-eureka
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    #表示是否将自己注册到eureka,因为要构建集群，需要将自己注册到集群，所以需要开启
    registerWithEureka: true
    #表示是否从eureka获取到注册信息，这里为集群，所以应该开启
    fetchRegistry: true
    serviceUrl:
      #表示从默认分区中访问eureka server，多个eureka用过逗号隔开
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/,http://${eureka.instance.hostname}:8861/eureka/
```
## 4.运行项目后，打开网址`http://localhost:8761`成功即可

# 微服务注册到服务注册中心
## 1.添加依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    <version>2.2.2.RELEASE</version>
</dependency>
```
## 2.在启动类上添加注解`@EnableEurekaClient`
## 3.添加配置文件application.yml
```yaml
spring:
  application:
    name: itoken-config
server:
  port: 8888
eureka:
    client:
      serviceUrl:
        defaultZone: http://localhost:8761/eureka/
```
## 4.在注册中心启动的情况下，启动该服务，然后在注册中心可以看到该实例

