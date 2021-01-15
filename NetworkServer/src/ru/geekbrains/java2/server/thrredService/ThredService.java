package ru.geekbrains.java2.server.thrredService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredService {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private ThredService() {}

    public static ExecutorService getExecutorService() {
        return executorService;
    }

}
