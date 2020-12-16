package cc.prayol.springdemo.boot;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author hjx
 * @date 2020/12/16
 */
@Configuration
@EnableWebMvc
@ComponentScan("cc.prayol.springdemo.controller")
public class WebConfig implements WebMvcConfigurer {




    /**
     * 添加json转换
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        converters.add(fastJsonHttpMessageConverter);
    }

//    @Override
//    public Validator getValidator() {
//        return this.validatorAdapter;
//    }


}
