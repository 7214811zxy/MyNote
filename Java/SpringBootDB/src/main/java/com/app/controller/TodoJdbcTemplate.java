package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todo")
public class TodoJdbcTemplate {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 增加一个todo
    @PostMapping("/add")
    public String todoAdd(@RequestBody Map<String, String> todo) {
        String sql = "INSERT INTO todo_list VALUES (null, ?, 0)";
        jdbcTemplate.update(sql, todo.get("description"));
        return "add 200";
    }

    // 删除一个todo
    @PostMapping("/delete")
    public String todoDelete(@RequestBody Map<String, Integer> todo) {
        // System.out.println("Delete ID: " + todo.get("id"));
        String sql = "DELETE FROM todo_list WHERE id=?";
        jdbcTemplate.update(sql, todo.get("id"));
        return "delete 200";
    }

    // 更新一个todo的description
    @PostMapping("/edit")
    public String todoEdit(@RequestBody Map<String, Integer> todo) {
        // System.out.println("Update ID: " + todo.get("id") + "description: " + todo.get("description"));
        String sql = "UPDATE todo_list SET description = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.get("description"), todo.get("id"));
        return "edit description 200";
    }

    // 更新一个todo的completed
    @PostMapping("/toggle")
    public String todoToggle(@RequestBody Map<String, String> todo) {
        String sql = "UPDATE todo_list SET completed = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.get("completed"), todo.get("id"));
        return "toggle 200";
    }

    // 返回所有的todos
    @GetMapping("/query")
    public List<Map<String, Object>> todoQuery() {
        String sql = "SELECT * FROM todo_list";
        List<Map<String, Object>> todoList = jdbcTemplate.queryForList(sql);
        return todoList;
    }

}
