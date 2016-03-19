package com.alekseysamoylov.sp3.annotation;

import com.alekseysamoylov.sp3.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
@Service("confProvider")
public class ConfigurableMessageProvider implements MessageProvider{

    private String message;

    @Autowired()
    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
