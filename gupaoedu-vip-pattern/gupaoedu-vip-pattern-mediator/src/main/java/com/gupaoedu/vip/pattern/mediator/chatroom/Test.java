package com.gupaoedu.vip.pattern.mediator.chatroom;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User tom = new User("Tom",chatRoom);
        User jerry = new User("Jerry",chatRoom);

        tom.sendMessage("Hi! I am Tom.");
        jerry.sendMessage("Hello! My name is Jerry.");
    }
}
