package com.phtowey.flowable.modeler.controller;

import com.phtowey.flowable.modeler.domain.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author photowey
 * @date 2020/12/11
 * @since 1.0.0
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/health")
public class HelloController {

    @GetMapping("/sayHello")
    public ApiResult<String> sayHello() {
        return new ApiResult<>(200, "say hello~");
    }
}
