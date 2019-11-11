# spring-boot-swagger

参考http://blog.didispace.com/springbootswagger2/的 SpringBoot 整合Swagger2 demo

注意：`springfox-swagger2` 2.9.2版本依赖使用的是 `swagger-annotations`
、`swagger-models` 两个依赖是1.5.20版本的，存在bug，需要排除掉这两个依赖并重新导入1.5.21版本的依赖
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
    <exclusions>
        <exclusion>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-annotations</artifactId>
        </exclusion>
        <exclusion>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
        </exclusion>
    </exclusions>
    
    <dependency>
        <groupId>io.swagger</groupId>
        <artifactId>swagger-annotations</artifactId>
        <version>1.5.21</version>
    </dependency>
    <dependency>
        <groupId>io.swagger</groupId>
        <artifactId>swagger-models</artifactId>
        <version>1.5.21</version>
    </dependency>
</dependency>
```
