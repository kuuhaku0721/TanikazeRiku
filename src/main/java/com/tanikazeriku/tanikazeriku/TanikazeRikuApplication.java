package com.tanikazeriku.tanikazeriku;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序入口
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class TanikazeRikuApplication {
    public static void main(String[] args) {
        SpringApplication.run(TanikazeRikuApplication.class, args);
        log.info("from kuuhaku: server start success...");
    }

}