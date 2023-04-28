package cn.edu.cqwu.intercepter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class SetIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("prehandle.....");
        if ((request.getSession().getAttribute("username")!=null)&&(request.getSession().getAttribute("password")!=null)){
            return true;
        }else{
//            转发
//            request.getRequestDispatcher("userlogin").forward(request,response);
//            重定向
            response.sendRedirect("userlogin");
            return false;
        }

    }
    //    Posthandle是在return后执行，return前有异常，posthandle不执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle拦截之后执行,return后执行....");
    }

    //    Aftercompletion是在整个方法执行完后执行，不管有没有异常，都执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion拦截之后执行，方法执行完后执行....");
        System.out.println(ex);
    }
}
