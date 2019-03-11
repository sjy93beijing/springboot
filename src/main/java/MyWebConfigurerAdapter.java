import com.sjy.springboot.interceptors.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author sjy on 2019/3/11
 * @version 1.0
 */
@Configuration
public class MyWebConfigurerAdapter extends WebMvcConfigurationSupport {
    private final static Logger logger = LoggerFactory.getLogger(MyWebConfigurerAdapter.class);

    //配置拦截器实体
    @Bean
    MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    //配置拦截器url
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }
    //配置静态资源


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
       logger.info("配置不拦截的静态资源");
//       registry.addResourceHandler("");
        super.addResourceHandlers(registry);
    }
}