package org.vinsw.java8.oca.inheritance.sender;

import org.vinsw.java8.oca.inheritance.sender.bean.TextMessage;

public class TextMessageSenderImpl implements MessageSender, Caller {

    @Override
    public void send(String from, String to, Object body) {

    }

    @Override
    public TextMessage createMsg() {
        return new TextMessage();
    }





}
