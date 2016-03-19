package com.alekseysamoylov.sp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
public class Main {
    public static void main(String [] args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:app-context.xml");
        context.refresh();
        MessageProvider provider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(provider.getMessage());

        MessageProvider provider1 = context.getBean("messageProvider1", MessageProvider.class);
        System.out.println(provider1.getMessage());

        //xml
        MessageRenderer renderer = context.getBean("messageRenderer1", MessageRenderer.class);
        renderer.render();

        //annotation
        MessageRenderer renderer2 = context.getBean("messageRenderer", MessageRenderer.class);
        renderer2.render();

        //xml p:
        MessageRenderer renderer3 = context.getBean("messageRenderer2", MessageRenderer.class);
        renderer3.render();

        MessageRenderer rendererConf = context.getBean("messageRendererConfig", MessageRenderer.class);
        rendererConf.render();

        MessageProvider providerConfAnnot = context.getBean("confProvider", MessageProvider.class);
        System.out.println(providerConfAnnot.getMessage());
    }
}
