package cn.edu.cqwu.config;

import cn.edu.cqwu.controller.SetController;
import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
//配置扫描的包
@ComponentScan(basePackages = "cn.edu.cqwu",excludeFilters = @Filter(Controller.class))
//注解事务管理驱动，tx是事务
@EnableTransactionManagement
public class SpringContextConfig {
//    连接数据的注解
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db1?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //    分页第二种方法
    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor=new PageInterceptor();
        Properties properties=new Properties();
//        设置两个属性，不设置不知道数据库方言
        properties.setProperty("helperDialect","mysql");
        properties.setProperty("reasonable","true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
//    集成mybatis,可以直接写在括号，接收需写注解@Autowired自动绑定
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource,@Autowired PageInterceptor pageInterceptor){
//        得到对象
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

////        分页第一种方法(（不需要在方法括号里写入）
//        PageInterceptor pageInterceptor=new PageInterceptor();
//        Properties properties=new Properties();
////        设置两个属性，不设置不知道数据库方言
//        properties.setProperty("helperDialect","mysql");
//        properties.setProperty("reasonable","true");
//        pageInterceptor.setProperties(properties);

        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.edu.cqwu.mapper");
        return mapperScannerConfigurer;
    }

//    事务
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
