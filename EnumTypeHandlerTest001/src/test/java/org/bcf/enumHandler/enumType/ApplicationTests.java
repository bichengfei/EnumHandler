package org.bcf.enumHandler.enumType;

import org.bcf.enumHandler.enumType.entity.UserEntity;
import org.bcf.enumHandler.enumType.entity.UserEntitySimple;
import org.bcf.enumHandler.enumType.enums.NationEnum;
import org.bcf.enumHandler.enumType.enums.SexEnum;
import org.bcf.enumHandler.enumType.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.List;

@SpringBootTest
public class ApplicationTests {

    @Autowired(required = false)
    UserService userService;

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void test007() {
        int a = appContext.getBeanDefinitionCount();
        int c = ((GenericWebApplicationContext) appContext).getBeanFactory().getSingletonCount();
        int d = ((GenericWebApplicationContext) appContext).getBeanFactory().getBeanPostProcessorCount();
        int b = 1;
    }

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

    @Test
    public void test006() {
        UserEntity user = new UserEntity();
        user.setUsername("hahahah");
        user.setNation(NationEnum.HAN);
        user.setSex(SexEnum.MAN);
        boolean bool = userService.insert(user);
        System.out.println(bool);
        UserEntity temp = userService.selectByUsername("hahahah");
        System.out.println(temp);
    }

}
