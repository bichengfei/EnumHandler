package cn.bcf.mybatis.process;

import cn.bcf.mybatis.typeHandler.ConfigurationHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/11 5:13 下午
 */
@Configuration
@Component("enumHandlerProcess")
@DependsOn({"sqlSessionFactory"})
public class EnumHandlerProcess {

    @Autowired
    private ApplicationContext appContext;

    @PostConstruct
    public void init() throws ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        if (sqlSessionFactory == null) {
            throw new RuntimeException("未获取到 sqlSessionFactory 对象，插件未成功初始化");
        }
        ConfigurationHelper.loadEnumHandler(sqlSessionFactory);
    }

}
