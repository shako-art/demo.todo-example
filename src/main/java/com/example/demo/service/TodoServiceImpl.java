package com.example.demo.service;

import com.example.demo.exception.TodoException;
import com.example.demo.model.TodoModel;
import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public  class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    @Override
    public   List<TodoModel> getAll(){
        return todoRepository.findAll();
    }

    @Override
    public TodoModel get(long id) {
        String msg = String.format("TodoItem with id: %d Not Found", id);
        return todoRepository.findById(id).orElseThrow(() -> new TodoException(msg));
    }

    @Override
     public TodoModel add(TodoModel todoModel){
      return todoRepository.save(todoModel);
    }

    @Override
    public TodoModel update(TodoModel todoModel){
        return todoRepository.save(todoModel);
    }

    @Override
    public void delete(long id){
        get(id);
        todoRepository.deleteById(id);
    }

}
