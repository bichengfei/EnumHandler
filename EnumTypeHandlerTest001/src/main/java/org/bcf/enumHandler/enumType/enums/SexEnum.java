package org.bcf.enumHandler.enumType.enums;

import org.bcf.enumHandler.annotation.EnumHandler;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/26 7:50 下午
 */
@EnumHandler
public enum SexEnum {

    MAN(1, "男"),
    WOMAN(2, "女");

    public Integer key;
    public String value;

    SexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

}
