package org.vinsw.java8.oca.inheritance.sender;

public interface Sender {

    String HOST = "localhost";

    void send(String from, String to, Object body);

    default String getClient() {
        return HOST;
    }

    default int getNumberOfMessage() {
        return 5;
    }

    //Same dewfault method define in Caller (commented to avoid compile error)
    default int getNumber() {
        return 1;
    }

    // This static method is not referenceable using MessageSender unlike class static methods
    // that can be call from a subclass
    static String getSenderInfo() {
        return "Sender info...";
    }

}
