package com.alekseysamoylov.sp3.xml;

import com.alekseysamoylov.sp3.Oracle;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:app-context-xml.xml");
        context.refresh();
        InjectRef injectRef = context.getBean("injectRef", InjectRef.class);
        System.out.println(injectRef.oracle.defineMeaningOfLife());
    }
}
