package com.alekseysamoylov.sp3.xml;

import com.alekseysamoylov.sp3.Bar;
import com.alekseysamoylov.sp3.Foo;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public class Target {

    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target(){
        System.out.println("empty constructor");
    }

    public Target(Foo foo) {
        System.out.println("foo construc");
        this.foo = foo;
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("foo bar constructor");
        this.foo = foo;
        this.bar = bar;
    }

    public void setFoo(Foo foo) {
        System.out.println("set foo");
        this.foo = foo;
    }

    public void setFoo2(Foo foo2) {
        System.out.println("set foo2");
        this.foo2 = foo2;
    }

    public void setBar(Bar bar) {
        System.out.println("set bar");
        this.bar = bar;
    }

    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/context2.xml");
        context.refresh();

        Target t = null;

        System.out.println("By name");
        t = (Target) context.getBean("targetByName");

        System.out.println("By type");
        t = (Target) context.getBean("targetByType");

        System.out.println("By constructor");
        t = (Target) context.getBean("targetConstructor");

    }
}
