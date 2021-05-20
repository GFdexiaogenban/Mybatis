## 1-前提知识

`Lombok`是一个java库，插件，构建工具，只需要在类上方加入一个注解就可以运行

## 2-使用步骤

1. 在`IDEA`中安装`Lombok`插件

2. 导入`jar`包

   ```xml
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.20</version>
       <scope>provided</scope>
   </dependency>
   ```

3. 加入注解

   ```java
   @Getter and @Setter
   @FieldNameConstants
   @ToString
   @EqualsAndHashCode
   @AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
   @Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
   @Data
   @Builder
   @SuperBuilder
   @Singular
   @Delegate
   @Value
   @Accessors
   @Wither
   @With
   @SneakyThrows
   @val
   @var
   ```

   其中`@Data`是最常用的

   `@Data`实现所有字段的`Setter`+`Getter`+无参构造

   | 注解名-代码         | 解释                                               |
   | ------------------- | -------------------------------------------------- |
   | @Data               | `Get`+`Set`+无参构造`+toString`+`hashcode`+`equal` |
   | @NoArgsConstructor  | 无参构造                                           |
   | @AllArgsConstructor | 有参构造                                           |
   | ……                  | ……                                                 |

   

   

