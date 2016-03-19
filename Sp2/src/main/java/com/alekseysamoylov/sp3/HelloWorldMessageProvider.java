package com.alekseysamoylov.sp3;

/**
 * Created by alekseysamoylov on 3/1/16.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!!";
    }
}
