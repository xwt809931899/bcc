package cn.gebixiaoba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2020/3/23.
 */
@SpringBootApplication
@MapperScan("cn.gebixiaoba.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
