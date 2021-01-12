package com.phtowey.flowable.modeler.config;

import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.flowable.ui.idm.servlet.ApiDispatcherServletConfiguration;
import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * FlowableActionConfiguration
 *
 * @author photowey
 * @date 2020/12/11
 * @since 1.0.0
 */
@Configuration
@ComponentScans({
        @ComponentScan(basePackages = {
                "org.flowable.ui.modeler.repository",
                "org.flowable.ui.modeler.service",
                "org.flowable.ui.common.service",
                "org.flowable.ui.common.repository",
                "org.flowable.ui.common.tenant"
        }),
        @ComponentScan(excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RemoteIdmService.class)
        })
})
@EnableConfigurationProperties(FlowableModelerAppProperties.class)
public class ApplicationConfiguration {

    @Bean
    public ServletRegistrationBean apiServlet(ApplicationContext applicationContext) {
        AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
        dispatcherServletConfiguration.setParent(applicationContext);
        dispatcherServletConfiguration.register(ApiDispatcherServletConfiguration.class);
        DispatcherServlet servlet = new DispatcherServlet(dispatcherServletConfiguration);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet, "/api/*");
        registrationBean.setName("Flowable IDM App API Servlet");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }
}
