package com.gupaoedu.vip.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class CService implements IService {
    Registy registy;
    CService(){
        registy.regist("cService",this);
    }


}
