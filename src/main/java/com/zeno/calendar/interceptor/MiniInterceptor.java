package com.zeno.calendar.interceptor;

import com.zeno.calendar.utils.IMoocJSONResult;
import com.zeno.calendar.utils.JsonUtils;
import com.zeno.calendar.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author rf
 */
public class MiniInterceptor implements HandlerInterceptor {
    /**
     * Intercept request, before controller
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @throws Exception
     */
    @Autowired
    public RedisOperator redis;

    public static final String USER_REDIS_SESSION = "user-redis-session";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");

        if (!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(userToken)) {
            String uniqueToken = redis.get(USER_REDIS_SESSION + ":" + userId);

            if (StringUtils.isEmpty(uniqueToken)) {
                // Token expires, relogin
                returnErrorResponse(response, new IMoocJSONResult().errorTokenMsg("Please login"));
                return false;
            } else {
                if (!uniqueToken.equals(userToken)) {
                    // Login in another phone
                    returnErrorResponse(response, new IMoocJSONResult().errorTokenMsg("Already logged in on another device"));
                    return false;
                }
            }
        } else {
            returnErrorResponse(response, new IMoocJSONResult().errorTokenMsg("Please login"));
            return false;
        }

        /**
         * Request intercepted, false
         * Continue proceeding, true
         */
        return true;
    }

    public void returnErrorResponse(HttpServletResponse response, IMoocJSONResult result)
            throws IOException, UnsupportedEncodingException {
        OutputStream out=null;
        try{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        } finally{
            if(out!=null){
                out.close();
            }
        }
    }

    /**
     * Before rendering
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * After rendering
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
