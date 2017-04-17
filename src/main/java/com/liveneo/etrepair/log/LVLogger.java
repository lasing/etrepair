package com.liveneo.etrepair.log;

import java.net.URL;
import java.text.MessageFormat;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.xml.DOMConfigurator;

public class LVLogger {
    private Logger              logger        = null;
    private static final String CONF_XML_FILE = "/log4j.xml";
    private static boolean      isInitialized = false;

    private static synchronized void init(Class clazz) {
        URL configURL;
        System.setProperty("log4j.defaultInitOverride", "true");
        configURL = clazz.getResource(CONF_XML_FILE);
        DOMConfigurator.configure(configURL);
        LogLog.setQuietMode(true);
        isInitialized = true;
        configURL = null;
    }

    private LVLogger(Logger logger) {
        this.logger = logger;
    }

    public static LVLogger getLogger(Class clazz) {
        try {
            if (!isInitialized) {
                init(clazz);
            }
            return new LVLogger(Logger.getLogger(clazz));
        } catch (Exception e) {
            return new LVLogger(null);
        }
    }

    public void debug(Object message) {
        log(Level.DEBUG, message);
    }

    public void debug(Object message, Throwable throwable) {
        log(Level.DEBUG, message, throwable);
    }

    public void debug(String message, String param) {
        log1(Level.DEBUG, message, param);
    }

    public void debug(String message, String param1, String param2) {
        log2(Level.DEBUG, message, param1, param2);
    }

    public void debug(String message, String param1, String param2, String param3) {
        log3(Level.DEBUG, message, param1, param2, param3);
    }

    public void debug(String message, String param1, String param2, String param3, String param4) {
        log4(Level.DEBUG, message, param1, param2, param3, param4);
    }

    public void info(Object message) {
        log(Level.INFO, message);
    }

    public void info(Object message, Throwable throwable) {
        log(Level.INFO, message, throwable);
    }

    public void info(String message, String param) {
        log1(Level.INFO, message, param);
    }

    public void info(String message, String param1, String param2) {
        log2(Level.INFO, message, param1, param2);
    }

    public void info(String message, String param1, String param2, String param3) {
        log3(Level.INFO, message, param1, param2, param3);
    }

    public void info(String message, String param1, String param2, String param3, String param4) {
        log4(Level.INFO, message, param1, param2, param3, param4);
    }

    public void warn(Object message, Throwable throwable) {
        log(Level.WARN, message, throwable);
    }

    public void warn(Object message) {
        log(Level.WARN, message);
    }

    public void warn(Throwable throwable) {
        log(Level.WARN, throwable.getMessage(), throwable);
    }

    public void error(Object message, Throwable throwable) {
        log(Level.ERROR, message, throwable);
    }

    public void error(Object message) {
        log(Level.ERROR, message);
    }

    public void error(Throwable throwable) {
        log(Level.ERROR, throwable.getMessage(), throwable);
    }

    public void fatal(Object message, Throwable throwable) {
        log(Level.FATAL, message, throwable);
    }

    public void fatal(Throwable throwable) {
        log(Level.FATAL, throwable.getMessage(), throwable);
    }

    public boolean isDebugOn() {
        return logger.isEnabledFor(Level.DEBUG);
    }

    public boolean isInfoOn() {
        return logger.isEnabledFor(Level.INFO);
    }

    public boolean isWarnOn() {
        return logger.isEnabledFor(Level.WARN);
    }

    private void log(Level level, Object message) {
        if (logger != null && logger.isEnabledFor(level)) {
            logger.log(level, message);
        }
    }

    private void log(Level level, Object message, Throwable throwable) {
        if (logger != null && logger.isEnabledFor(level)) {
            logger.log(level, message, throwable);
        }
    }

    private void log1(Level level, String theMessage, Object object1) {
        if (logger != null && logger.isEnabledFor(level)) {
            Object[] args = { object1 };
            logger.log(level, MessageFormat.format(theMessage, args));
        }
    }

    private void log2(Level level, String theMessage, Object object1, Object object2) {
        if (logger != null && logger.isEnabledFor(level)) {
            Object[] args = { object1, object2 };
            logger.log(level, MessageFormat.format(theMessage, args));
        }
    }

    private void log3(Level level, String theMessage, Object object1, Object object2, Object object3) {
        if (logger != null && logger.isEnabledFor(level)) {
            Object[] args = { object1, object2, object3 };
            logger.log(level, MessageFormat.format(theMessage, args));
        }
    }

    private void log4(Level level, String theMessage, Object object1, Object object2, Object object3, Object object4) {
        if (logger != null && logger.isEnabledFor(level)) {
            Object[] args = { object1, object2, object3, object4 };
            logger.log(level, MessageFormat.format(theMessage, args));
        }
    }
}
