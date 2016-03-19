package com.alekseysamoylov.sp3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
@Service("constructorConfusion2")
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue){
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    @Autowired
    public ConstructorConfusion(@Value("90") int someValue){
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:app-context-xml.xml");
        context.refresh();
        ConstructorConfusion constructorConfusion = context.getBean("constructorConfusion2", ConstructorConfusion.class);
        System.out.println(constructorConfusion.someValue);

    }
}
