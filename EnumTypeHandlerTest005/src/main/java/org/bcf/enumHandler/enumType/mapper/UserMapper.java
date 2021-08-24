package org.bcf.enumHandler.enumType.mapper;

import org.bcf.enumHandler.enumType.entity.UserEntity;
import org.bcf.enumHandler.enumType.entity.UserEntitySimple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/7 7:55 下午
 */
@Mapper
public interface UserMapper {

    List<UserEntity> selectAll();

    List<UserEntitySimple> selectAllSimple();

}
