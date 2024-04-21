package com.mall.apiserver.service;


import com.mall.apiserver.domain.Todo;
import com.mall.apiserver.dto.TodoDTO;
import com.mall.apiserver.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();
        return entityToDto(todo);
    }

    @Override
    public Long register(TodoDTO todoDTO) {
        Todo todo = dtoToEntity(todoDTO);

        Todo result = todoRepository.save(todo);

        return result.getTno();

    }

    @Override
    public void modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
        Todo todo = result.orElseThrow();

        todo.setTitle(todoDTO.getTitle());
        todo.setContents(todoDTO.getContents());
        todo.setDueDate(todoDTO.getDueDate());

        todoRepository.save(todo);

    }

    @Override
    public void remove(TodoDTO todoDTO) {
        todoRepository.deleteById(todoDTO.getTno());
    }
}
