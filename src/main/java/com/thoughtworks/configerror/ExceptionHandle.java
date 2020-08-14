package com.thoughtworks.configerror;


import com.thoughtworks.exception.Error;
import com.thoughtworks.exception.ErrorEmptyObjectException;
import com.thoughtworks.exception.ErrorIndexException;
import com.thoughtworks.exception.ErrorInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@ControllerAdvice
public class ExceptionHandle{
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler({ErrorIndexException.class, ErrorInputException.class
            , MethodArgumentNotValidException.class, ErrorEmptyObjectException.class})
    public ResponseEntity handlerInputException(Exception e) {
        Error er = new Error();
        if(e instanceof MethodArgumentNotValidException){
            er.setError(selectSource());
        }
        else{
            er.setError(e.getMessage());
        }
        LOGGER.error(e.getMessage());
        return ResponseEntity.badRequest().body(er);
    }

    private String selectSource() {
       String path = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getPathInfo();
        switch (path){
            case "/user":
                return "invalid user";
            case "/rs":
                return "invalid param";
        }
        return path;
    }

}
