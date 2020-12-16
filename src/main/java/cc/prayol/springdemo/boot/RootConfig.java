package cc.prayol.springdemo.boot;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;

/**
 * @author hjx
 * @date 2020/12/16
 */
@Configuration
@ComponentScan(
        basePackages = "cc.prayol.springdemo",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
        }
)
@MapperScan("cc.prayol.springdemo.generate.mapper")
public class RootConfig {
    /**
     * 设置数据源
     * @return
     */
    public HikariDataSource hikariDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariDataSource.setJdbcUrl("jdbc:mysql://140.143.19.224:3306/diamond?characterEncoding=utf8&connectTimeout=1000&autoReconnect=true");
        hikariDataSource.setUsername("sql_admin");
        hikariDataSource.setPassword("Njiuyag7!");
        return hikariDataSource;
    }
    @Bean
    public SqlSessionFactory SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(hikariDataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        HashMap<String, String> propertyMap=new HashMap<>();
        propertyMap.put(HibernateValidatorConfiguration.FAIL_FAST, "true");
        localValidatorFactoryBean.setValidationPropertyMap(propertyMap);
        return localValidatorFactoryBean;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidator(this.localValidatorFactoryBean());
        return processor;
    }
}
