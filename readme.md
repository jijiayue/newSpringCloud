启动类  +  @EnableFeignClients   Feign

熔断器  application.properties添加这一条：   feign.hystrix.enabled=true
     在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容。
     @FeignClient(name= "spring-cloud-producer",fallback = HelloRemoteHystrix.class)


配置
  测试server端是否可以读取到github上面的配置信息，直接访问：http://localhost:8001/neo-config/dev
   {
       "name": "neo-config",
       "profiles": [
           "dev"
       ],
       "label": null,
       "version": null,
       "state": null,
       "propertySources": [
           {
               "name": "https://github.com/ityouknow/spring-cloud-starter/config-repo/neo-config-dev.properties",
               "source": {
                   "neo.hello": "hello im dev"
               }
           }
       ]
   }

   上述的返回的信息包含了配置文件的位置、版本、配置文件的名称以及配置文件中的具体内容，说明server端已经成功获取了git仓库的配置信息。

   如果直接查看配置文件中的配置信息可访问：http://localhost:8001/neo-config-dev.properties，
   返回：neo.hello: hello im dev

   修改配置文件neo-config-dev.properties中配置信息为：neo.hello=hello im dev update,再次在浏览器访问http://localhost:8001/neo-config-dev.properties，返回：neo.hello: hello im dev update。说明server端会自动读取最新提交的内容

   仓库中的配置文件会被转换成web接口，访问可以参照以下的规则：

   /{application}/{profile}[/{label}]
   /{application}-{profile}.yml
   /{label}/{application}-{profile}.yml
   /{application}-{profile}.properties
   /{label}/{application}-{profile}.properties
   以neo-config-dev.properties为例子，它的application是neo-config，profile是dev。client会根据填写的参数来选择读取对应的配置。


高可用
  启动类添加@EnableDiscoveryClient激活对配置中心的支持
  防止  配置中心 服务挂掉  client和server作修改  详见模块
  
  
Spring Cloud Bus----消息总线
   server端配置 RabbitMQ 并且引包
   client 也需要引用 来支持RabbitMQ












