package com.phtowey.flowable.modeler.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ApiResult
 *
 * @author photowey
 * @date 2020/12/11
 * @since 1.0.0
 */
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1236925031782203634L;
    private Integer status;
    private T data;
}
