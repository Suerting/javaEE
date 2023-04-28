package cn.edu.cqwu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
@Configuration
//配置web.xml里加载配置文件
public class ServletContextConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//    返回跟容器，类型数组
//    <context-param>
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringContextConfig.class};
    }

//     <servlet>
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

//    <servlet-mapping>
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    编码

    @Override
    protected Filter[] getServletFilters() {
//        写过滤器
        CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        return new Filter[]{characterEncodingFilter};
    }
}
