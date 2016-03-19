package com.alekseysamoylov.sp3.annotation;

import com.alekseysamoylov.sp3.MessageProvider;
import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 3/1/16.
 */
@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!!";
    }
}
