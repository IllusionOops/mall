package com.wyj.auth.exception;

import com.wyj.auth.entity.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author wuyijie
 * @project mall
 * @className GloableException
 * @description TODO
 * @date 2020/11/8 00:00
 */
@RestControllerAdvice
@Slf4j
public class GloableExceptionHandler {

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBean handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResultBean(401, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(),null);
    }
}
