package com.designpatterns.creational.singleton;

import org.junit.Test;

public class SingletonCreationTest {

    @Test
    public void singleThread() {
        FactoryTrackManager manager = FactoryTrackManager.getInstance();
        FactoryTrackManager manager2 = FactoryTrackManager.getInstance();
        assert(manager == manager2);
    }

    @Test
    public void multiThread() {
        FactoryTrackManager manager = FactoryTrackManager.getInstance();
        Thread one = new Thread(FactoryTrackManager::getInstance
        , "Thread One");
        Thread two = new Thread(FactoryTrackManager::getInstance, "Thread two");
        one.start();
        two.start();
        assert(manager == FactoryTrackManager.getInstance());
    }
}

