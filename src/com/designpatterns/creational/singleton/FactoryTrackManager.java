package com.designpatterns.creational.singleton;

/**
 * There are 3 ways to achieve thread safety for a singleton object
 * 1. Create the instance variable at the time of class loading.
 * Pros:
 *
 * Thread safety without synchronization
 * Easy to implement
 *
 * Cons:
 *
 * Early creation of resource that might not be used in the application.
 * The client application can’t pass any argument, so we can’t reuse it. For example, having a generic singleton class for database connection where client application supplies database server properties.
 *
 * 2. Synchronize the getInstance() method.
 * Pros:
 *
 * Thread safety is guaranteed.
 * Client application can pass parameters
 * Lazy initialization achieved
 *
 * Cons:
 *
 * Slow performance because of locking overhead.
 * Unnecessary synchronization that is not required once the instance variable is initialized.
 *
 * 3. Use synchronized block inside the if loop and volatile variable
 *
 * Pros:
 *
 * Thread safety is guaranteed
 * Client application can pass arguments
 * Lazy initialization achieved
 * Synchronization overhead is minimal and applicable only for first few threads when the variable is null.
 *
 * Cons:
 * Extra if condition
 */
public class FactoryTrackManager {

    private static volatile FactoryTrackManager instance;
    private static Object mutex = new Object();

    private FactoryTrackManager() {
    }

    public static FactoryTrackManager getInstance() {
        FactoryTrackManager result = instance;
        if (result == null) {
            synchronized (mutex) { // mutex ensures that only one thread can access this block at run-time
                result = instance;
                if (result == null)
                    System.out.println("Creating a new instance");
                    instance = result = new FactoryTrackManager();
            }
        }
        return result;
    }

}
