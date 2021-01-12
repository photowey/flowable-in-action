package com.phtowey.flowable.modeler.util;

import org.apache.commons.lang3.Validate;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * TextFormatUtil
 *
 * @author photowey
 * @date 2020/12/17
 */
public final class TextFormatUtil {

    private TextFormatUtil() {
        // util class; can't create
        throw new AssertionError("No " + this.getClass().getName() + " instances for you!");
    }

    /**
     * 格式化字符串,此方法是抽取slf4j的核心方法.
     *
     * @param text 文本的格式,比如 log.error("send the mail exception,the mail is:{}", toMailAddress, e);
     * @param args 参数
     * @see FormattingTuple
     * @see MessageFormatter#arrayFormat(String, Object[])
     * @see FormattingTuple#getMessage()
     */
    public static String format(String text, Object... args) {
        Validate.notNull(text, "text can't be null!");
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(text, args);
        return formattingTuple.getMessage();
    }
}
