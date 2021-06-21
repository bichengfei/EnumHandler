package org.bcf.enumHandler.enumType.enums;

import org.bcf.enumHandler.annotation.EnumHandler;

public enum SexEnum {

    MAN(1, "男"),
    WOMAN(2, "女")
    ;

    public Integer key;
    public String value;

    SexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

}
