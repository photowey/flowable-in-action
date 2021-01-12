package com.phtowey.flowable.modeler.annotation;

import com.phtowey.flowable.modeler.config.AppDispatcherServletConfiguration;
import com.phtowey.flowable.modeler.config.ApplicationConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableFlowableModeler
 *
 * @author photowey
 * @date 2021/01/13
 * @since 1.0.0
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
public @interface EnableFlowableModeler {
}
