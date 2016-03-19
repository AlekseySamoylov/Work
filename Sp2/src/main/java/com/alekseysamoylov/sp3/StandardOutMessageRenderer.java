package com.alekseysamoylov.sp3;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider2;

    @Override
    public void render() {
        if (messageProvider2 == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                    + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider2.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider2 = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider2;
    }
}
