package com.lpw.springboot02.exception;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value={Exception.class})
    public Object exceptionHandler(HttpServletRequest request,Exception e){
        if(isAjax(request)){
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("exception",e.getMessage());
            map.put("url",request.getRequestURL());
            map.put("success",false);
            return JSONUtils.toJSONString(map);
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception",e.getMessage());
            modelAndView.addObject("url",request.getRequestURL());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    /**
     * 判断请求是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Request-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Request-With").toString()));
    }
}
