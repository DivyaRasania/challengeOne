package com.divya.challengeOne;

public class Message {
    private String text;
    private String recipient;
    private int id;

    public Message(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails() {
        System.out.println("Contact Name: " + this.recipient + "\n" +
                           "Message: " + this.text + "\n" +
                           "Id: " + this.id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
