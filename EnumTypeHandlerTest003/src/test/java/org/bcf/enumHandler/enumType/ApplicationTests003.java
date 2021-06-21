package org.bcf.enumHandler.enumType;

import org.bcf.enumHandler.enumType.entity.UserEntity;
import org.bcf.enumHandler.enumType.entity.UserEntitySimple;
import org.bcf.enumHandler.enumType.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
public class ApplicationTests003 {

    @Autowired(required = false)
    UserService userService;

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void test001() {
        List<UserEntity> list = userService.selectAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test002() {
        List<UserEntitySimple> list = userService.selectAllSimple();
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test003() {
        long startTime = System.nanoTime();
        List<UserEntity> list = userService.selectAll();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    @Test
    public void test004() {
        long startTime = System.nanoTime();
        List<UserEntitySimple> list = userService.selectAllSimple();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    @Test
    public void test005(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        int a = 1;
    }

}
