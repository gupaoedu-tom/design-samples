package com.gupaoedu.vip.pattern.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tom.
 */
public class TicketFacotry {

    private static Map<String,ITicket> pool = new ConcurrentHashMap<String, ITicket>();

    public static ITicket queryTicket(String from,String to){
        String key = from + "->" + to;
        if(pool.containsKey(key)){
            System.out.println("使用缓存" + key);
            return pool.get(key);
        }
        System.out.println("首次查询，创建对象:" + key);
        ITicket ticket = new TrainTicket(from,to);
        pool.put(key,ticket);
        return ticket;

    }

}
