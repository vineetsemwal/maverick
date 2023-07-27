package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
info==2
 */
@SpringBootApplication
public class Main {
    private static final Logger Log= LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);

        Log.debug("i am debug");
        Log.info("i am info");
        Log.error("i am error");

    }
}