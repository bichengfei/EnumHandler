# EnumTypeHandler
### 介绍

本项目是对 Mybatis 中 enum-type-handler 的增强。

### 这个项目有什么用

Mybatis 本质上是对 JDBC 的增强，那么 Mybatis 也将围绕着入参、出参、管理 SQL、执行 SQL这四个部分进行扩展，其中入参、出参都将对 Java 类型和 JDBC 类型进行映射转换，我们称之为类型处理器。Mybatis 定义了接口 TypeHandler，所有的类型处理器都继承自这个接口，通过重写这个接口中的四个方法，完成 Java 类型和 JDBC 类型的转换。

Mybatis 已经提供了很丰富的类型处理器，对于枚举类型，也提供了两种处理器：

- EnumTypeHandler：枚举名/枚举 Name
- EnumOrdinalTypeHandler：枚举顺序编号，从 1 开始

但我们业务中大部分都是类似下面的枚举，这时候官方提供的处理器就不够用了，如果想使用 Mybatis 自动映射，我们就需要自定义枚举类型处理器。那么有没有一种方法，只通过添加一个注解，就能使用到 Mybatis 把数据库字段自动映射到我们的枚举类？

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

### 怎么用



### 怎么工作的



### License

EnumTypeHandler is available under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

