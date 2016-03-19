package com.alekseysamoylov.sp3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue){
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusion(int someValue){
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:app-context-xml.xml");
        context.refresh();
        ConstructorConfusion constructorConfusion = context.getBean("constructorConfusion", ConstructorConfusion.class);
        System.out.println(constructorConfusion.someValue);

    }
}
