package spring.review.demo.sys.inteceptor;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.Data;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.review.demo.sys.utils.RedisUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行登录检查
     *
     * @param request  HttpServletRequest对象
     * @param response HttpServletResponse对象
     * @param handler  处理器对象
     * @return 如果登录检查通过，返回true；否则，返回false。
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        log.info("请求的url: {}", url);
        response.setContentType("text/html;charset=UTF-8");
        // 登录接口放行
        if (url.contains("login")) {
            log.info("登录操作，放行");
            return true;
        }

        // 获取请求头中的token
        String jwt = request.getHeader("Token");

        // 如果token为空，返回未登录信息
        if (!StringUtils.hasLength(jwt)) {
            Result error = Result.error("未登录");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }




        // 解析令牌，检查是否合法
        try {
           Claims claims = JwtUtils.parseJWT(jwt);
           if(claims == null){
               Result error = Result.login();
               String notLogin = JSONObject.toJSONString(error);
               response.getWriter().write(notLogin);
               return false;
           }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败");
            return false;
        }

        log.info("令牌合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        // 在请求处理之后但视图渲染之前调用
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求完成之后，即视图渲染结束之后调用
        log.info("afterCompletion");
    }
}
