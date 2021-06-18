# EnumTypeHandler
## 介绍

本项目是对 Mybatis 中 enum-type-handler 的增强

## 有什么用

Mybatis 本质上是对 JDBC 的增强，那么 Mybatis 也将围绕着入参、出参、管理 SQL、执行 SQL这四个部分进行扩展，其中入参、出参都将对 Java 类型和 JDBC 类型进行映射转换，我们称之为类型处理器。Mybatis 定义了接口 TypeHandler，所有的类型处理器都继承自这个接口，通过重写这个接口中的四个方法，完成 Java 类型和 JDBC 类型的转换。

Mybatis 已经提供了很丰富的类型处理器，对于枚举类型，也提供了两种处理器：

- EnumTypeHandler：枚举名/枚举 Name
- EnumOrdinalTypeHandler：枚举顺序编号，从 1 开始

但我们业务中大部分都是类似下面的枚举，我们需要在数据库中存字段 key，这时候官方提供的处理器就不够用了。如果想使用 Mybatis 自动映射，我们就需要自定义枚举类型处理器，那么有没有一种方法，只通过添加一个注解，就能使用到 Mybatis 把数据库字段自动映射到我们的枚举类？

```java
public enum SexEnum {

    MAN(1, "男"),
    WOMAN(2, "女")
    ;

    public Integer key;
    public String value;

    SexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

}
```

本项目想要做的就是，在 ```pom.xml```中引入依赖，再在枚举类上引入注解，然后这个枚举类就可以使用到 Mybatis 的类型处理器的功能，方便开发。

## 怎么用

1. 引入依赖

   ```java
   <dependency>
       <groupId>cn.bcf.mybatis</groupId>
       <artifactId>enum-handler</artifactId>
       <version>1.0-SNAPSHOT</version>
   </dependency>
   ```

2. 枚举类上加上注解

   ```java
   @EnumHandler
   public enum SexEnum {
   
       MAN(1, "男"),
       WOMAN(2, "女")
       ;
   
       public Integer key;
       public String value;
   
       SexEnum(Integer key, String value) {
           this.key = key;
           this.value = value;
       }
   
   }
   ```

3. 验证插件是否成功加载

   ![image-20210618103004915](img/运行成功日志.png)

## 怎么工作的

借用```spring boot ```的```spring.factories```，在```EnumTypeHandler```中获取的 Mybatis 的 SqlSessionFactory 对象，然后获取到所有用到注解 EnumHandler 的 Class，手动把这些枚举类和指定的 TypeHandler 注入到 Mybatis 的类型处理器中。

## License

EnumTypeHandler is available under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## FAQ

1. 是否会存在执行效率上的影响？

   会存在一些。当把数据库字段转为枚举的时候，会对枚举类进行反射处理，从数据库查出的结果有多少枚举，就会有多少次反射。

2. 当项目中未引入 Mybatis 依赖时，引入 EnumTypeHandler 会出现问题吗？

   不会，日志会打印警告信息，但对项目运行不会产生影响

   ![未加入 Mybatis 依赖](img/未加入Mybatis依赖.png)

3. 为什么不打印日志？

   目前 EnumTypeHandler 只支持 log4j 

4. 对 Mybatis 版本有什么要求？

   TODO...

5. 对数据库有什么要求？

   理论支持任意数据库

6. 枚举类的变量名只能为 key 吗？可不可以是 code 或者其他任意字符串？任意类型可以吗？

   变量名可以不是 key，key 只是默认值，具体可以通过注解指定为任意字符串，例如：```@EnumHandler("code")```；任意类型不可以，当前版本只支持整形

   

   
