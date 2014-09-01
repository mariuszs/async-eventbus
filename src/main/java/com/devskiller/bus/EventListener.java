package com.devskiller.bus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

/**
 * @author Mariusz Smykuła
 */
public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    @AllowConcurrentEvents
    public void listen(OurTestEvent event) {
        lastMessage = event.getMessage();

        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received " + event.getMessage());
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
