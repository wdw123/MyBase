package com.cqupt.web.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * 分为需要请求转发和需要返回数值的两类异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {


    private static final String attName = "exceptionMessage";

    @Autowired
    private ModelAndView modelAndView;

    @ExceptionHandler(SQLException.class)
    public ModelAndView doSQLException(SQLException sqlEx) {
        modelAndView.addObject(attName,sqlEx.getMessage());
        return modelAndView;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String IllegalArgumentException(IllegalArgumentException iAEx) {
        return iAEx.getMessage();
    }

}
