依据 ：http://blog.720ui.com/columns/springboot_all/

5.15. 使用 JDBC，配置数据源可通过application.xml与Configuration文件两种方式 通过 JdbcTemplate 编写数据访问。
相关文件 mysql-datasource.properties  MysqlDatasource类 Author系列文件
MysqlDatasource：  Druid用于数据源管理 JdbcTemplate用作dao

5.20 多数据源配置，通过注册多个bean来实现 相关文件 类MultiMysqlDatasource
mybatis整合：配置application  创建mapper 即可 相关文件 MB*
redis 整合： 配置application  手动或自动配置  Redis


5.21
mongodb整合： 配置application  手动或自动配置  MG*
使用redis开启缓存 Cache*
使用undertow服务器 改pom 修改配置文件
异步任务 添加@EnableAsync 在异步方法上添加@Async即可

5.23 http应用监控
    actuator 引入
    关闭安全校验
    management:
            security:
              enabled: false
    通过各地址获取json数据
    健康检查：http://localhost:9090/manage/health
