package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy.proxy;

import java.lang.reflect.Method;

/**
 * Created by Tom.
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
