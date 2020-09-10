package com.app.mapper;

import com.app.pojo.TodoPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 表示这是一个Mybatis的Mapper类
// 可以在ToDoApp.java中使用MapperScan来扫描某个文件夹下所有的类，将其注册为Mapper

/**
 *
 * 为什么需要一个Mapper class ?
 *
 * This name can be directly mapped to a Mapper class of the
 * same name as the namespace, with a method that matches the
 * name, parameter,and return type as the mapped select statement.
 *
 * 该命名就可以直接映射到在命名空间中同名的映射器类，
 * 并将已映射的 select 语句匹配到对应名称、参数和返回类型的方法
 *
 * 什么是Mapper接口类？Mapper的作用域应该在哪个范围
 * Mappers are interfaces that you create to bind to your mapped statements.
 * Instances of the mapper interfaces are acquired from the SqlSession.
 * As such, technically the broadest scope of any mapper instance is the
 * same as the SqlSession from which they were requested. However, the best
 * scope for mapper instances is method scope. That is, they should be
 * requested within the method that they are used, and then be discarded.
 * They do not need to be closed explicitly. While it's not a problem to keep
 * them around throughout a request, similar to the SqlSession, you might find
 * that managing too many resources at this level will quickly get out of hand.
 * Keep it simple, keep Mappers in the method scope. The following example
 * demonstrates this practice.
 *
 * */

@Mapper
@Repository
public interface TodoListMapper {

    List<TodoPojo> todoQuery();

    int todoDelete(int id);

    int todoEdit(String id, String description);

    int todoAdd(String description);

    int todoToggle(String id, String completed);

}
