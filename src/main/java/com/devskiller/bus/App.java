package com.devskiller.bus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );



//        EventBus eventBus = new EventBus("test");
        EventBus eventBus = new AsyncEventBus("test", Executors.newFixedThreadPool(3));
        EventListener listener = new EventListener();

        eventBus.register(listener);

        // when
        System.out.println( "Post 100" );
        eventBus.post(new OurTestEvent(100));
        System.out.println("Post 200");
        eventBus.post(new OurTestEvent(200));


    }
}
