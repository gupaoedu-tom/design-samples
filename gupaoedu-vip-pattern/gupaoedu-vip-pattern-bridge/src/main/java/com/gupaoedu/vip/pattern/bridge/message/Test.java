package com.gupaoedu.vip.pattern.bridge.message;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbastractMessage abastractMessage = new NomalMessage(message);
        abastractMessage.sendMessage("加班申请","王总");

        message = new EmailMessage();
        abastractMessage = new UrgencyMessage(message);
        abastractMessage.sendMessage("加班申请","王总");
    }

}
