package cn.bcf.mybatis.annotation;

import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.*;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/8 6:53 下午
 */
@IndexAnnotated
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnumHandler {

    String value() default "key";

}
