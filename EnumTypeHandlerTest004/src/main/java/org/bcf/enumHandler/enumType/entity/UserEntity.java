package org.bcf.enumHandler.enumType.entity;

import org.bcf.enumHandler.annotation.EnumHandler;
import org.bcf.enumHandler.enumType.enums.NationEnum;
import org.bcf.enumHandler.enumType.enums.SexEnum;
import lombok.Data;

@Data
@EnumHandler
public class UserEntity {

    private Integer id;
    private String username;
    private SexEnum sex;
    private NationEnum nation;

}
