package com.alekseysamoylov.sp3.annotation.two;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by alekseysamoylov on 3/8/16.
 */

@Service("injectCollection")
public class CollectionInjection {

    @Resource(name="map")
    private Map<String, Object> map;
    @Resource(name="props")
    private Properties props;
    @Resource(name="set")
    private Set set;
    @Resource(name="list")
    private List list;


public static void main(String[] args){
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
    context.load("classpath:META-INF/spring/app-context-annotation.xml");
    context.refresh();
    CollectionInjection collectionInjection = (CollectionInjection) context.getBean("injectCollection");
    collectionInjection.displayInfo();
}


    public void displayInfo() {
        System.out.println("Map contents: \n");

        for (Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value " + entry.getValue());
        }

        System.out.println("Property content \n");

        for( Map.Entry<Object, Object> entry : props.entrySet()){
            System.out.println("key: " + entry.getKey() + " value " + entry.getValue());
        }

        System.out.println("Set contents \n");
        for (Object object : set){
            System.out.println("Entry set " + object);
        }

        System.out.println("List content");
        for (Object object : list){
            System.out.println("list entry: " + object);
        }
    }
}
