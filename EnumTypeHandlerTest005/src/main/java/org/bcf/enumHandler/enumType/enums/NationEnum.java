package org.bcf.enumHandler.enumType.enums;

import org.bcf.enumHandler.annotation.EnumHandler;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/9 4:34 下午
 */
@EnumHandler
public enum NationEnum {

    HAN(1, "汉族"),
    HUI(2, "回族");

    private Integer key;
    private String value;

    NationEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

}
