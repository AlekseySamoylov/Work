package com.alekseysamoylov.sp3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by alekseysamoylov on 3/8/16.
 */
public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;


    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/xml-app-context.xml");
        context.refresh();
        CollectionInjection injection = (CollectionInjection) context.getBean("injectCollection");
        injection.displayInfo();
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
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
