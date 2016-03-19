package com.alekseysamoylov.sp3;


/**
 * Created by alekseysamoylov on 3/1/16.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
