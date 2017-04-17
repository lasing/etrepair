package com.liveneo.etrepair.common;

public class UserReadableException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 6297415368769198648L;
    private String            userMessage;
    private String            errorCode;

    public UserReadableException(String userMessage) {
        super();
        this.userMessage = userMessage;
    }

    public UserReadableException(String userMessage, Exception e) {
        super(e.getMessage());
        this.userMessage = userMessage;
    }

    public UserReadableException(String userMessage, String errorCode) {
        super();
        this.userMessage = userMessage;
        this.errorCode = errorCode;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
