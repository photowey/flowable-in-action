package com.phtowey.flowable.modeler.domain;

import java.io.Serializable;

/**
 * ApiResult
 *
 * @author photowey
 * @date 2020/12/11
 * @since 1.0.0
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1236925031782203634L;
    private Integer status;
    private T data;

    public ApiResult() {
    }

    public ApiResult(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
