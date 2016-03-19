package com.alekseysamoylov.sp2;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public class HelloWorldDecoupledWithFactory {
    public static void main(String [] args){
        MessageProvider provider = MessageSupportFactory.getInstance().getMessageProvider();
        MessageRenderer renderer = MessageSupportFactory.getInstance().getMessageRenderer();
        renderer.setMessageProvider(provider);
        renderer.render();
    }
}
