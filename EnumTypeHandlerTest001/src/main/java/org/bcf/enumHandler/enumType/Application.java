package org.bcf.enumHandler.enumType;

import org.bcf.enumHandler.enumType.entity.UserEntity;
import org.bcf.enumHandler.enumType.enums.NationEnum;
import org.bcf.enumHandler.enumType.enums.SexEnum;
import org.bcf.enumHandler.enumType.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        UserService userService = (UserService) context.getBean("userService");
        UserEntity user = new UserEntity();
        user.setUsername("hahahah");
        user.setNation(NationEnum.HAN);
        user.setSex(null);
        boolean bool = userService.insert(user);
    }

}
