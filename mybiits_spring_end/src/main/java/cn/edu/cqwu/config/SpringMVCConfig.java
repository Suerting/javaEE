package cn.edu.cqwu.config;

import cn.edu.cqwu.intercepter.SetIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("cn.edu.cqwu.controller")

//<mvc:default-servlet-handler />
//需要实现方法
@EnableWebMvc

public class SpringMVCConfig implements WebMvcConfigurer {
//    上方mvcdefault的配置
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//该方法使得它起作用
    }

//     <mvc:annotation-driven></mvc:annotation-driven>
//    注解式处理器映射
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }
//    注解式处理器适配
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        return new RequestMappingHandlerMapping();
    }

//    内部资源视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
//    文件上传
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        return new CommonsMultipartResolver();
    }

//    注册拦截器
//将自定义拦截器放入到spring容器中
//    @Bean
//    public SetIntercepter setIntercepter(){
//        return new SetIntercepter();
//    }
    @Autowired
    SetIntercepter setIntercepter;
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration interceptorRegistration= registry.addInterceptor(setIntercepter);
        // 拦截所有请求
        interceptorRegistration.addPathPatterns("/**");
        //  指定不拦截的
        interceptorRegistration.excludePathPatterns("/userlogin");
        interceptorRegistration.excludePathPatterns("/userregister");

    }
}

