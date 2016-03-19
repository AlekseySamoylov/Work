package com.alekseysamoylov.sp3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public class SimpleBean {
    private String name;
    private int age;

    public static void main(String[] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/context2.xml");
        context.refresh();

        SimpleBean simpleBean = null;
        simpleBean = (SimpleBean) context.getBean("parentInherit");
        System.out.println(simpleBean);
        System.out.println((SimpleBean) context.getBean("childInherit"));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return name + " " + age;
    }
}
