package com.deal.demo.base.exception;


import com.deal.demo.base.BaseController;
import com.deal.demo.base.ResponseHttpStatus;
import com.deal.demo.base.response.ResponseHead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version V1.0
 * @Title: ControllerException.java <br>
 * @Package com.hzbf.utils.base.exception <br>
 * @Description: (Controller异常捕捉,暂时未增加除Spring层与Interccpter的异常捕捉) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2018/5/22 12:37 <br>
 */
@RestControllerAdvice
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerException extends BaseController {

    private Logger logger = LoggerFactory.getLogger(ControllerException.class);
    private ResponseHead responseHead = createResponse();
    /**
     * @author: 路逸冰(Allen) <br>
     * @date: 2018/5/22 15:00<br>
     * @modify 修改人 <br>
     * @modifyDate: 修改时间 <br>
     * @Title: validationErrorallException <br>
     * @Description: (对所有异常进行验证，并返回正确的异常提示数据) <br>
     * @param: [e] <br>
     * @return: com.xzwl.hp.base.response.ResponseHead <br>
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseHead validationErrorAllException(Exception e){
        /**
         * 405(不支持的请求方法),
         * 406(无法接收的内容或类型)
         * 415(不支持的媒体类型)
         */
        if(e instanceof MissingServletRequestParameterException ||
                e instanceof HttpMessageNotReadableException ||
                e instanceof TypeMismatchException){//缺少参数
            logger.error("---------400--------->{}",e.getMessage());
            return ResponseHttpStatus.responseStatus(responseHead,400,e.getMessage(),"-1");
        } else if(e instanceof HttpRequestMethodNotSupportedException){
            logger.error("---------405--------->{}",e.getMessage());
            return ResponseHttpStatus.responseStatus(responseHead,405,e.getMessage(),"-1");
        } else if(e instanceof HttpMediaTypeNotAcceptableException){
            logger.error("---------406--------->{}",e.getMessage());
            return ResponseHttpStatus.responseStatus(responseHead,406,e.getMessage(),"-1");
        } else if(e instanceof HttpMediaTypeNotSupportedException){
            logger.error("---------415--------->{}",e.getMessage());
            return ResponseHttpStatus.responseStatus(responseHead,415,e.getMessage(),"-1");
        } else {//其他
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                logger.error("{}错误信息为：{}",stackTrace[i],e.getMessage());
            }
            return ResponseHttpStatus.responseStatus(responseHead,500,"Internal Server Error","");
        }
    }
}
