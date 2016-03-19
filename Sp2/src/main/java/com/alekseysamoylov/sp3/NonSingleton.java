package com.alekseysamoylov.sp3;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public class NonSingleton {

    public static void main(String [] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/app-context-xml.xml");
        context.refresh();
        System.out.println(context.getBean("nonSingleton")==context.getBean("nonSingleton"));
    }
}
