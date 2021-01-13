package com.phtowey.flowable.modeler.factory;

import java.util.Date;

/**
 * TimeFactory
 *
 * @author photowey
 * @date 2020/12/11
 * @since 1.0.0
 */
public final class TimeFactory {

    private TimeFactory() {
        // factory class; can't create
        throw new AssertionError("No " + this.getClass().getName() + " instances for you!");
    }

    public static Date now() {
        return new Date();
    }
}
