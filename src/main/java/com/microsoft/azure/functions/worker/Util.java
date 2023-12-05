package com.microsoft.azure.functions.worker;

import com.google.gson.Gson;
import com.microsoft.azure.functions.spi.inject.GsonInstanceInjector;
import java.util.function.Supplier;

public class Util {
    private static Supplier<Gson> gsonInstance;
    private static final Object utilLock = new Object();
    public static boolean isTrue(String value) {
        if(value != null && (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("1"))) {
            return true;
        }
        return false;
    }

    public static String getJavaVersion() {
        return String.join(" - ", System.getProperty("java.home"), System.getProperty("java.version"));
    }

    public static void setGsonInstance(Supplier<Gson> instance) {
        gsonInstance = instance;
    }

    public static Gson getGsonInstance() {
        return gsonInstance.get();
    }

}