package com.BismaAlifAlghifariJSleepMN;

import com.BismaAlifAlghifariJSleepMN.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Bisma Alif Alghifari
 * 2106731402
 * Modul 2
 */

/**
 * The main class of the JSleep application.
 *
 * <p>This class contains the `main()` method, which is the entry point of the application.
 * It also uses the `@SpringBootApplication` annotation to enable Spring Boot auto-configuration and component scanning.</p>
 *
 * @author Bisma Alif Alghifari
 * @since 27 September 2022
 * @version 1.0
 * @see JsonDBEngine
 * @see SpringBootApplication
 */
@SpringBootApplication
public class JSleep {

    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

    }



}
