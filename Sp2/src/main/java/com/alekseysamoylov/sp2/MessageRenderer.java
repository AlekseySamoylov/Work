package com.alekseysamoylov.sp2;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
