package com.alekseysamoylov.sp3;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/8/16.
 */
public class HierarcgicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:META-INF/spring/parent.xml");
        parent.refresh();
        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:META-INF/spring/app-context-xml.xml");
        child.setParent(parent);
        child.refresh();

        SimpleTarget target1 = (SimpleTarget) child.getBean("hierarchic");
        System.out.println(target1.getVal());


        SimpleTarget target3 = (SimpleTarget) child.getBean("hierarchic3");
        System.out.println(target3.getVal());

        SimpleTarget target2 = (SimpleTarget) child.getBean("hierarchic2");
        System.out.println(target2.getVal());

    }
}
