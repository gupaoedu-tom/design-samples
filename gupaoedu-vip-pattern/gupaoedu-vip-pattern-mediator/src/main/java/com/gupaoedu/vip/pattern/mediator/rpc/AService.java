package com.gupaoedu.vip.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class AService implements IService {
    Registy registy;
    AService(){
        registy.regist("aService",this);
    }

    public void a(){
        //registy.get("bService").xxx();
    }
}
