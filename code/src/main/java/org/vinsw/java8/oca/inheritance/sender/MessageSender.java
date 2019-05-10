package org.vinsw.java8.oca.inheritance.sender;

import org.vinsw.java8.oca.inheritance.sender.bean.TextMessage;

public abstract interface MessageSender extends Sender {

    TextMessage createMsg();


    default String getClient() {
        return HOST + "MessageSender";
    }

    /*
    If uncomment this line the implementing class must implement
    the default getNumberOfMessage method defined in the extended
    interface Sender
    */
//    public int getNumberOfMessage();


    // al interface method are public also static methods
    static String getConnectionInfo() {
        return "some text";
    }
}
