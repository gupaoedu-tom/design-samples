package com.gupaoedu.vip.pattern.observer.mouseevent;

import com.gupaoedu.vip.pattern.observer.mouseevent.core.EventListener;
import com.gupaoedu.vip.pattern.observer.mouseevent.handler.Mouse;
import com.gupaoedu.vip.pattern.observer.mouseevent.handler.MouseEventListener;
import com.gupaoedu.vip.pattern.observer.mouseevent.handler.MouseEventType;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        EventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK,listener);
        mouse.addListener(MouseEventType.ON_MOVE,listener);

        mouse.click();
        mouse.move();
    }
}
