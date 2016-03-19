package com.alekseysamoylov.sp2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public class HelloWorldSpringDI {

    public static void main(String [] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
