package com.alekseysamoylov.sp3.xml;

import com.alekseysamoylov.sp3.MessageProvider;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
public class ConfigurableMessageProvider implements MessageProvider{

    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
