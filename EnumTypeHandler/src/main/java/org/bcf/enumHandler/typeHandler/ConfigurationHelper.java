package org.bcf.enumHandler.typeHandler;

import org.bcf.enumHandler.annotation.EnumHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.atteo.classindex.ClassIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationHelper {

    private static Logger logger = LoggerFactory.getLogger(ConfigurationHelper.class);

    private static final Class HANDLER_ENUM_CLAZZ = EnumHandler.class;

    private static final Class HANDLER_CLAZZ = EnumKeyTypeHandler.class;

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
