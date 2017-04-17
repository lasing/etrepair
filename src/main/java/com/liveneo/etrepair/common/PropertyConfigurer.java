package com.liveneo.etrepair.common;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import com.liveneo.etrepair.service.support.PropertySupport;

/**
 * property加载器,通过Spring容器扩展点实现
 * 
 * @author wangchaochao
 *
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
    private static Map<String, String> ctxPropertiesMap;
    private static final Logger        logger = LoggerFactory.getLogger(PropertyConfigurer.class);

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        setContexProperty(props);
    }

    public static void setContexProperty(Properties props) {
        if (ctxPropertiesMap == null) {
            ctxPropertiesMap = new HashMap<String, String>();
        }
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            if (ctxPropertiesMap.containsKey(keyStr)) {
                String oldValue = ctxPropertiesMap.get(keyStr);
                logger.warn("property [key:" + keyStr + ",value:" + oldValue + "] override by [key:" + keyStr + ",value:" + value + "]");
            }
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    public static String getSimpleErrorMessage(String code) {
        String message = ctxPropertiesMap.get(code);
        if (message == null) {
            logger.warn("property [key:" + code + "] not exist,there may be throw exception");
            return null;
        }
        return message;
    }

    public static String getErrorMessage(String code) {
        String message = ctxPropertiesMap.get(code);
        if (message == null) {
            logger.warn("property [key:" + code + "] not exist,there may be throw exception");
            return null;
        }
        return code + ":" + message;
    }

    public static String getErrorMessage(String code, Object... args) {
        String message = ctxPropertiesMap.get(code);
        if (message == null) {
            logger.warn("property [key:" + code + "] not exist,there may be throw exception");
            return null;
        }
        return code + ":" + MessageFormat.format(message, args);
    }

    public static String getValue(String code) {
        String value = ctxPropertiesMap.get(code);
        if (value == null) {
            logger.warn("property [key:" + code + "] not exist,there may be throw exception");
            return null;
        }
        return value;
    }

    public static void resetProperty(String code, String value) {
        if (StringUtil.isEmptyOrNull(code) || StringUtil.isEmptyOrNull(value)) {
            logger.error("property [key:" + code + ",value:" + value + "] reset error");
        }
        if (!ctxPropertiesMap.containsKey(code)) {
            logger.error("property [key:" + code + "] not exist");
        }
        ctxPropertiesMap.put(code, value);
        logger.info("property [key:" + code + ",value:" + value + "] reset success");
    }

    public static List<PropertySupport> queryAllSystemProperty() {
        List<PropertySupport> propertySupports = new ArrayList<PropertySupport>();
        for (Entry<String, String> entry : ctxPropertiesMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && !key.startsWith("E")) {
                PropertySupport propertySupport = new PropertySupport();
                propertySupport.setCode(key);
                propertySupport.setValue(value);
                propertySupports.add(propertySupport);
            }
        }
        return propertySupports;
    }
}