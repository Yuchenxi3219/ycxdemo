package com.example.demo.Constants;

/**
 * @author YuChenXi
 * @date 2022/3/9 9:28 下午
 */
public enum ErrorCode {
    SUCCESS("0","success"),
    INVALID_PARAM("103","Invalid parameter"),
    INTERNAL_ERROR("100","internal error"),
    CANNOT_FIND_PROCESSOR("104","cannot find processor"),
    EXISTING_DATA_ERROR("105","existing data error");

    private String errorCode;
    private String errorMessage;

    ErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getMessageFromCode(String errorCode){
        for (ErrorCode value : ErrorCode.values()) {
            if (value.getErrorCode().equals(errorCode)) {
                return value.getErrorMessage();
            }
        }
        return "";
    }
}
