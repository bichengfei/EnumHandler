package org.bcf.enumHandler.process;

import org.bcf.enumHandler.typeHandler.ConfigurationHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

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
