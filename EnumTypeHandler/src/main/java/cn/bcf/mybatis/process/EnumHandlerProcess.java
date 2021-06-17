package cn.bcf.mybatis.process;

import cn.bcf.mybatis.typeHandler.ConfigurationHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class EnumHandlerProcess {

    private static Logger logger = Logger.getLogger(EnumHandlerProcess.class);

    @Autowired(required = false)
    @Qualifier("sqlSessionFactory")
    private Object sqlSessionFactory;

    @PostConstruct
    public void init() throws ClassNotFoundException {
        if (sqlSessionFactory == null) {
            logger.warn("未获取到 sqlSessionFactory 对象，EnumTypeHandler 插件未成功加载.");
            return;
        }
        ConfigurationHelper.loadEnumHandler((SqlSessionFactory)sqlSessionFactory);
    }

}
