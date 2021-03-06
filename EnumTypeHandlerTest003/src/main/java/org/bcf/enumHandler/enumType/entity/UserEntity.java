package org.bcf.enumHandler.enumType.entity;

import lombok.Data;
import org.bcf.enumHandler.enumType.enums.SexEnum;
import org.bcf.enumHandler.enumType.enums.rely.NationEnum;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private SexEnum sex;
    private NationEnum nation;

}
