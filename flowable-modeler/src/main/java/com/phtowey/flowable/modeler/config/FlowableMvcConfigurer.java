package com.phtowey.flowable.modeler.config;

import com.phtowey.flowable.modeler.id.Snowflake;
import org.flowable.common.engine.impl.cfg.IdGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * FlowableMvcConfigurer
 *
 * @author photowey
 * @date 2020/12/11
 * @since 1.0.0
 */
@Configuration
public class FlowableMvcConfigurer implements WebMvcConfigurer, EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");*/
    }

    @Override
    public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        springProcessEngineConfiguration.setIdGenerator(this.flowableIdGenerator());
    }

    @Bean
    public IdGenerator flowableIdGenerator() {
        return new IdGeneratorImpl(1L, 1L);
    }

    public static class IdGeneratorImpl implements IdGenerator {

        private Snowflake snowflake;

        public IdGeneratorImpl(Long workerId, Long dataCenterId) {
            this.snowflake = new Snowflake(workerId, dataCenterId);
        }

        @Override
        public String getNextId() {
            return String.valueOf(this.snowflake.nextId());
        }
    }


}
