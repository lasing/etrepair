package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.log.LVLogger;

public abstract class BaseController {
    static final LVLogger      logger                = LVLogger.getLogger(BaseController.class);
    public static final String RESULT_KEY_STATUS     = "status";
    public static final String RESULT_STATUS_OK      = "OK";
    public static final String RESULT_STATUS_WAIT    = "WAIT";
    public static final String RESULT_STATUS_FAIL    = "FAIL";
    public static final String RESULT_STATUS_ERROR   = "ERROR";
    public static final String RESULT_KEY_MESSAGE    = "message";
    public static final String RESULT_KEY_ERROR_CODE = "errorCode";
    public static final String RESULT_KEY_TIME       = "time";
    public static final String RESULT_KEY_RESULT     = "result";
    public static final String JSON_PARSE_ERROR      = "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";

    @ExceptionHandler(UserReadableException.class)
    @ResponseBody
    public String handleUserReadableException(HttpServletRequest request, UserReadableException e) {
        return "{\"status\":\"ERROR\",\"errorCode\":\"" + e.getErrorCode() + "\",\"message\":\"" + e.getUserMessage() + "\"}";
    }

    protected String resultOK() {
        HashMap<String, Object> messageOK;
        messageOK = new HashMap<String, Object>();
        messageOK.put(RESULT_KEY_STATUS, RESULT_STATUS_OK);
        messageOK.put(RESULT_KEY_TIME, System.currentTimeMillis());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(messageOK);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        }
    }

    protected String resultOK(Object obj) {
        HashMap<String, Object> messageOK;
        messageOK = new HashMap<String, Object>();
        messageOK.put(RESULT_KEY_STATUS, RESULT_STATUS_OK);
        messageOK.put(RESULT_KEY_RESULT, obj);
        // messageOK.put(RESULT_KEY_TIME, System.currentTimeMillis());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(messageOK);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        }
    }

    protected String resultOK(String key, Object value) {
        HashMap<String, Object> messageOK;
        messageOK = new HashMap<String, Object>();
        messageOK.put(RESULT_KEY_STATUS, RESULT_STATUS_OK);
        messageOK.put(key, value);
        // messageOK.put(RESULT_KEY_TIME, System.currentTimeMillis());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(messageOK);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        }
    }

    protected String resultWait(Object obj) {
        HashMap<String, Object> messageWait = new HashMap<String, Object>();
        messageWait.put(RESULT_KEY_STATUS, RESULT_STATUS_WAIT);
        messageWait.put(RESULT_KEY_RESULT, obj);
        // messageWait.put(RESULT_KEY_TIME, System.currentTimeMillis());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(messageWait);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        }
    }

    protected String resultError(String message) {
        HashMap<String, Object> ret;
        ret = new HashMap<String, Object>();
        ret.put(RESULT_KEY_STATUS, RESULT_STATUS_ERROR);
        ret.put(RESULT_KEY_MESSAGE, message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(ret);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        }
    }

    protected String resultFail(String message) {
        HashMap<String, Object> ret;
        ret = new HashMap<String, Object>();
        ret.put(RESULT_KEY_STATUS, RESULT_STATUS_FAIL);
        ret.put(RESULT_KEY_MESSAGE, message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(ret);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":\"ERROR\",\"message\":\"" + "json 转换失败" + "\"}";
        }
    }

    protected Map<String, Object> getResult() {
        return new HashMap<String, Object>();
    }

    public static void main(String[] args) throws IOException {
        JsonGenerator jsonGenerator = null;
        HashMap<String, Object> messageOK = new HashMap<String, Object>();
        messageOK.put(RESULT_KEY_STATUS, RESULT_STATUS_OK);
        // messageOK.put(RESULT_KEY_TIME, System.currentTimeMillis());
        ObjectMapper mapper = new ObjectMapper();
        jsonGenerator = mapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        System.out.println(mapper.writeValueAsString(messageOK));
    }
}
