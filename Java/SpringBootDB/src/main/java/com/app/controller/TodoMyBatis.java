package com.app.controller;

import com.app.mapper.TodoListMapper;
import com.app.pojo.TodoPojo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todo/mybatis")
public class TodoMyBatis {

    @Autowired
    private TodoListMapper todoListMapper;
    // private SqlSession sqlSession;

    @PostMapping("/add")
    public int todoAdd(@RequestBody Map<String, String> todo){
        System.out.println(todo.get("description"));
        todoListMapper.todoAdd(todo.get("description"));
        return 200;
    }

    @PostMapping("/delete")
    public int todoDelete(@RequestBody Map<String, Integer> todo){
        todoListMapper.todoDelete(todo.get("id"));
        return 200;
    }

    @PostMapping("/edit")
    public int todoEdit(@RequestBody Map<String, String> todo){
        try{
            todoListMapper.todoEdit(todo.get("id"), todo.get("description"));
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }
        return 200;
    }

    @PostMapping("/toggle")
    public int todoToggle(@RequestBody Map<String, String> todo){
        todoListMapper.todoToggle(todo.get("id"), todo.get("completed"));
        return 200;
    }


    @GetMapping("/query")
    public List<TodoPojo> todoQuery(){
        // sqlSession.selectOne("todoQuery"); 空指针错误 好像不行
        return todoListMapper.todoQuery();
    }

}
