package com.mall.apiserver.service;

import com.mall.apiserver.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class TodoServiceImplTest {

    @Autowired
    TodoService todoService;

    @Test
    void todoGet(){
        Long tno = 1L;
        log.info(todoService.get(tno));
    }

    @Test
    void todoRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Title ....")
                .contents("Content....")
                .dueDate(LocalDate.of(2024,4,21))
                .build();

        log.info(todoService.register(todoDTO));
    }
}