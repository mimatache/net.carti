package net.carti.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardLogger {

    private CardLogger() {}

    public static Logger getInstance(Class<?> clazz){
        return LoggerFactory.getLogger(clazz);
    }
}
