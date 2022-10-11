package com.kingpiggy.digimon.pg.web;

import com.kingpiggy.digimon.pg.enumclass.ErrorCode;
import lombok.NoArgsConstructor;

/**
 * BusinessException class
 * Exception class for Business Exception
 * Example
 *  throw new BusinessException(ErrorCode.getMessage()
 *
 * @author SEUNGHOON
 * @version 0.1.0, 2022-06-05
 *
 */
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
