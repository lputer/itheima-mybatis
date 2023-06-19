package com.itheima;

import com.example.EnableHeaderConfig;

import com.itheima.service.impl.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


// @Import(TokenParser.class)
// @Import(HeaderConfig.class)
// @Import(MyImportSelector.class) //导入ImportSelector接口实现类
@EnableHeaderConfig
@SpringBootApplication
public class SpringbootWebConfig2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfig2Application.class, args);
    }

    // 不建议在启动类加入beam
    /*@Bean // 将当前方法的返回值对象交给IOC容器管理, 成为IOC容器bean
    public SAXReader saxReader() {
        return new SAXReader();
    }*/
}
