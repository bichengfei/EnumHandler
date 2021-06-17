package cn.bcf.mybatis.enumType.entity;

import cn.bcf.mybatis.enumType.enums.NationEnum;
import cn.bcf.mybatis.enumType.enums.SexEnum;
import lombok.Data;

@Data
public class UserEntitySimple {

    private Integer id;
    private String username;
    private Integer sex;
    private Integer nation;

}
