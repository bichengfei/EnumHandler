package cn.bcf.mybatis.enumType.mapper;

import cn.bcf.mybatis.enumType.entity.UserEntity;
import cn.bcf.mybatis.enumType.entity.UserEntitySimple;
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
