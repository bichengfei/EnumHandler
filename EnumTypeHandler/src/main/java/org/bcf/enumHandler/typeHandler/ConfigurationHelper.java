package org.bcf.enumHandler.typeHandler;

import org.bcf.enumHandler.annotation.EnumHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.log4j.Logger;
import org.atteo.classindex.ClassIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/9 4:44 下午
 */
public class ConfigurationHelper {

    private static Logger logger = Logger.getLogger(ConfigurationHelper.class);

    private static final Class HANDLER_ENUM_CLAZZ = EnumHandler.class;

    private static final Class HANDLER_CLAZZ = EnumKeyTypeHandler.class;

    /**
     * 向 sqlSessionFactory 的类型处理器中，注入 EnumKeyTypeHandler
     * @param factory
     * @throws ClassNotFoundException
     */
    public static void loadEnumHandler(SqlSessionFactory factory) throws ClassNotFoundException {
        logger.info("EnumTypeHandler - start......");
        List<String> list = getJavaType();
        TypeHandlerRegistry typeHandlerRegistry = factory.getConfiguration().getTypeHandlerRegistry();
        for (String javaTypeClass : list) {
            typeHandlerRegistry.register(javaTypeClass, HANDLER_CLAZZ.getName());
            logger.info("EnumTypeHandler - javaTypeClass:" + javaTypeClass + ", TypeHandler:" + HANDLER_CLAZZ.getName());
        }
        logger.info("EnumTypeHandler - end......");
    }

    /**
     * 找出 @EnumHandler 标注的类
     * @return
     */
    private static List<String> getJavaType() {
        List<String> list = new ArrayList<>();
        final Iterable<Class<?>> klasses = ClassIndex.getAnnotated(HANDLER_ENUM_CLAZZ);
        for (Class<?> clazz : klasses) {
            if (clazz.isEnum()) {
                list.add(clazz.getName());
            } else {
                logger.warn("EnumTypeHandler - Not Enum:" + clazz.getName());
            }
        }
        return list;
    }

}
