package com.alekseysamoylov.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/12/16.
 */
public class SimpleBeanWithInterface implements InitializingBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (name==null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age==Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + SimpleBean.class);
        }
    }

    @Override
    public String toString(){
        return name + " " + age;
    }

    private static SimpleBeanWithInterface getBean(String beanName, ApplicationContext context) {
        try {
            SimpleBeanWithInterface bean = (SimpleBeanWithInterface) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/app-context-ch4.xml");
        context.refresh();

        getBean("simpleBean4", context);
        getBean("simpleBean5", context);
        getBean("simpleBean6", context);
    }
}
