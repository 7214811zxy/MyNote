# 环境搭建
1. 下载MySQL JDBC Connector
3. 创建一个libs文件夹，并将该文件夹定义为项目的library root
    一般有3种方式来引入jar包
    1. 手动引入
    2. 通过lib文件夹来设置
    3. 通过Maven
   `具体细节参考 => https://blog.csdn.net/u010228798/article/details/88740093`
2. 将mysql-connector-java-5.1.49-bin.jar包放到libs中

# java.sql中的主要对象
1. DriverManager: 驱动管理对象

2. Connection: 数据库连接对象
    2.1 用来获取数据库连接对象
    `Statement creatStatement()`
    `PreparedStatement prepareStatement(String sql)`
    2.2 管理事务
    开启事务：`setAutoCommit()`
    提交事务：`commit()`
    回滚事务：`rollback()`
    
3. Statement: 执行sql的对象
    执行静态的sql语句
    1. `boolean execute(String sql)` 可以执行任意的sql语句 _不常用_
    2. `int executeUpdate(String sql)` 执行DML(insert、update、delete)语 / 或DDL(create, alter, drop)语句
        注意，返回的int值表示，本次sql总共影响的行数，如0表示没有数据被修改，2表示有2行数据被修改
    3. `ResultSet executeQuery(String sql)` 执行DQL(select)语句
        查询用语句：返回一个Result对象
4. ResultSet: 结果集对象

5. PreparedStatement: 执行sql的对象

