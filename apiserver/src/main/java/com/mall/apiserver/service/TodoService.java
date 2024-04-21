package com.mall.apiserver.service;

import com.mall.apiserver.domain.Todo;
import com.mall.apiserver.dto.TodoDTO;
import jakarta.transaction.Transactional;


@Transactional
public interface TodoService {
    TodoDTO get(Long tno);

    Long register(TodoDTO todoDTO);

    void modify(TodoDTO todoDTO);

    void remove(TodoDTO todoDTO);

    default TodoDTO entityToDto(Todo todo){
        return TodoDTO.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .contents(todo.getContents())
                .complate(todo.isComplate())
                .dueDate(todo.getDueDate())
                .build();
    }

    default Todo dtoToEntity(TodoDTO todoDTO){
        return Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .contents(todoDTO.getContents())
                .complate(todoDTO.isComplate())
                .dueDate(todoDTO.getDueDate())
                .build();
    }
}
