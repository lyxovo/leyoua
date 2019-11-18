package com.leyou.common.advice;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(LyException.class)//拦截指定异常
    public ResponseEntity<ExceptionResult> handleException(LyException e){
        ExceptionEnum em=e.getExceptionEnum();
       // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        return ResponseEntity.status(em.getCode()).body(em.getMsg());
        return ResponseEntity.status(em.getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}
