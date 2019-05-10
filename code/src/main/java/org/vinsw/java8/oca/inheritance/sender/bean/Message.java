package org.vinsw.java8.oca.inheritance.sender.bean;

public class Message<T> {

    T content;

    int size;

    String encoding;

    String type;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static MessageBuilder build() {
        return new MessageBuilder();
    }

    protected static final class MessageBuilder<T> {
        T content;
        int size;
        String encoding;
        String type;

        MessageBuilder setContent(T content) {
            this.content = content;
            return this;
        }

        MessageBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        MessageBuilder setEncoding(String encoding) {
            this.encoding = encoding;
            return this;
        }

        MessageBuilder setType(String type) {
            this.type = type;
            return this;
        }

        Message<T> build() {
            final Message msg = new Message();
            msg.setContent(content);
            msg.setEncoding(encoding);
            msg.setSize(size);
            msg.setType(type);
            return msg;
        }

    }
}
