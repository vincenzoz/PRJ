package org.vinsw.java8.oca.inheritance;

import org.vinsw.java8.oca.inheritance.sender.MessageSender;
import org.vinsw.java8.oca.inheritance.sender.Sender;
import org.vinsw.java8.oca.inheritance.sender.TextMessageSenderImpl;

public class Main {

    public static void main(String[] args) {

        SecondSubclass obj = new SecondSubclass();
        obj.send();
        SecondSubclass.getSecondSubclassStaticMehod();


        Sender sender = new TextMessageSenderImpl();
        sender.send(null, null, null);

        System.out.println("->" + sender.getClient());

        System.out.println("getNumber: " + sender.getNumber());

        System.out.println("call interface static methos: " + MessageSender.getConnectionInfo());

    }
}
