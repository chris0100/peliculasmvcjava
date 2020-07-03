package com.gabi.pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");

        context.close();
    }
}
