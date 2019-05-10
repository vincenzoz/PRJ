package org.vinsw.java8.oca.inheritance.sender;

public interface Caller {


    //Same default method name defined in Sender
    // If uncommented compile error because the TextMessageSenderImpl implement both Sender and Caller
    // and will no determine wich default method to call (multiple inheritance)
    //    default int getNumber() {
    //        return 0;
    //    }

    // Same static method name in Sender interface
    // Thhi static method unlike default methods can't have the same name will not compile failed
    // Because if a class implements both Sender and this interface in order to call this method
    // must specify the Interface name ex: Caller.getSenderInfo
    static String getSenderInfo() {
        return "Caller - Sender info...";
    }
}
