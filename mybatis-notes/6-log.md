## 1-日志工厂

如果一个数据库操作，出现了异常，需要排错，日志是最好的助手

曾经：sout，debug

mybatis提供的日志工厂——>Log4J

在`setting`中，可以进行日志的设置——`logImpl`

| 设置名  | 描述                                                  | 有效值                                                       | 默认值 |
| :------ | :---------------------------------------------------- | :----------------------------------------------------------- | :----- |
| logImpl | 指定 MyBatis 所用日志的具体实现，未指定时将自动查找。 | ==`SLF4J` | `LOG4J` | `LOG4J2` | `JDK_LOGGING` | `COMMONS_LOGGING` | `STDOUT_LOGGING` | `NO_LOGGING` | 未设置 |

其中，最为重要的是`LOG4J`和`STDOUT_LOGGING`

标准的日志工厂实现：`STDOUT_LOGGING`

## 2-LOG4J

LOG4J可以控制日志信息输送的目的地是控制台、文件、GUI组件，甚至是调接口服务器、NT的时间记录器、UNIX Syslog守护进程

可以通过一个配置文件来灵活配置，而不需要修改应用的代码

### 实现步骤

1. 导入log4j包

   ```xml
   <!-- https://mvnrepository.com/artifact/log4j/log4j -->
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>1.2.17</version>
   </dependency>
   ```

2. 在`resource`文件夹下建立`log4j.properties`

   输入相应的配置，详细配置可搜索百度

   ```properties
   #将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
   log4j.rootLogger=DEBUG,console,file
   
   #控制台输出的相关设置
   log4j.appender.console = org.apache.log4j.ConsoleAppender
   log4j.appender.console.Target = System.out
   log4j.appender.console.Threshold=DEBUG
   log4j.appender.console.layout = org.apache.log4j.PatternLayout
   log4j.appender.console.layout.ConversionPattern=[%c]-%m%n
   
   #文件输出的相关设置
   log4j.appender.file = org.apache.log4j.RollingFileAppender
   log4j.appender.file.File=./log/kuang.log
   log4j.appender.file.MaxFileSize=10mb
   log4j.appender.file.Threshold=DEBUG
   log4j.appender.file.layout=org.apache.log4j.PatternLayout
   log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n
   
   #日志输出级别
   log4j.logger.org.mybatis=DEBUG
   log4j.logger.java.sql=DEBUG
   log4j.logger.java.sql.Statement=DEBUG
   log4j.logger.java.sql.ResultSet=DEBUG
   log4j.logger.java.sql.PreparedStatement=DEBUG
   ```

3. 配置`log4j`日志的实现

   `mybatis-config.cml`文件下

   ```xml
   <settings>
       <setting name="logImpl" value="LOG4J"/>
   </settings>
   ```

4. 简单使用

   - 在要使用`Log4j`时，导入`log4j`的包，不要导入成`util`的包了

   - 生成日志对象，参数为当前类的`class`

     ```java
     static Logger logger = Logger.getLogger(String.valueOf(UserMapper.class));
     ```

   - 在需要用日志的部分，使用`logger`下的各种方法

     常用方法：

     - logger.info()
     - logger.debug()
     - logger.error()

