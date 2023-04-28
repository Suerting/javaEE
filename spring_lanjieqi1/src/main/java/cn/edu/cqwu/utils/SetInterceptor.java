package cn.edu.cqwu.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetInterceptor implements HandlerInterceptor {

//    如果prehandle返回false，执行完prehandle后就没了，因为false会认为条件不满足，不会去执行访问的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("preHandle拦截之前执行....");
//        判断
        if (request.getSession().getAttribute("username")!=null) {
            return true;
        }else{
//            转发
//            request.getRequestDispatcher("login").forward(request,response);
//            重定向
            response.sendRedirect("login");
            return false;
        }
    }
//    Posthandle实在return后执行，return前有异常，posthandle不执行
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


