package com.alekseysamoylov.sp2;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
