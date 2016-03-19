package com.alekseysamoylov.sp3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public class LookupDemo {

    public static void main(String[] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/app-context-xml.xml");
        context.refresh();

        DemoBean abstractBean = (DemoBean)context.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean)context.getBean("standardLookupBean");

        displayInfo(abstractBean);
        displayInfo(standardBean);

    }

    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("helper Instances the Same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for(int x = 0; x < 100000; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");


    }
}
