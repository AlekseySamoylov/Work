package com.alekseysamoylov.sp2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        props = new Properties();
        try {
            props.load(new FileInputStream(getClass().getClassLoader().getResource("msf.properties").getFile()));
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        }catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException ex){
            ex.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
