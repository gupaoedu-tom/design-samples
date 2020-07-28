package com.gupaoedu.vip.pattern.mediator.chatroom;

/**
 * Created by Tom.
 */
public class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg){
        this.chatRoom.showMsg(this,msg);
    }
}
