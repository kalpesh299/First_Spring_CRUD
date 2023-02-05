package com.example.Todo.controller;

import com.example.Todo.model.Todo;
import com.example.Todo.services.Todoservices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController ///is uses response boday by default
//@Controller //it tells spring boot to whatever request coming from browser sent it to to controller class
@RequestMapping("api/v1/todo-app")
public class Todocontroller {
    //-----------------------------------
//    @GetMapping("/message")
//    @ResponseBody
//    public String msg(){
//          return "Nothing Is Impossible";
//    }
    //using query paramter
//    @RequestMapping("/api")
//    public String hellocontroller(@RequestParam String username ){
//        return "hello "+username;
//    }
//// using path variable
//    @RequestMapping("/api/username/{username}")
//    public String hellocontoller(@PathVariable String username){
//        return "hello "+username;
//    }
    //-------------------------------

    private final Todoservices todoservice;
    public Todocontroller (Todoservices todoservice) {//dependency Injection
        this.todoservice = todoservice;
    }
    //http://localhost:8083/api/v1/todo-app/add-todo
    @PostMapping("/add-todo")
    public void addtodo(@RequestBody Todo todo){
       todoservice.addtodo(todo);
    }

    //http://localhost:8083/api/v1/todo-app/findby-todo/id/5
    @GetMapping("findby-todo/id/{id}")
    public Todo mappedtodobody(@PathVariable int id){
     return todoservice.findby_id(id);
    }

    //http://localhost:8083/api/v1/todo-app/find-all
    @GetMapping("find-all")
    public List<Todo> Alltodos(){
        return todoservice.findAll();
    }
    //http://localhost:8083/api/v1/todo-app/update-todo/id/2
    @PutMapping("update-todo/id/{id}")
    public void updatetodo(@PathVariable int id,@RequestBody Todo todo){
           todoservice.update_todo(id,todo);
    }
    //http://localhost:8083/api/v1/todo-app/delete-todo/id/6
    @DeleteMapping("delete-todo/id/{id}")
    public void deletetodo(@PathVariable int id){

        todoservice.delete_todo(id);

    }

}
