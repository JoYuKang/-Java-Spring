package org.example.sevice;

import org.example.model.TodoModel;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    //mock을 사용하는 이유
    // 1. 외부시스템에 의존 x
    // 2. 실제 데이터를 사용하게 되면 DB와 연동되어 위험
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoModel.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("test title");
        expected.setOrder(0L);
        TodoModel actual = this.todoService.add(expected);

        assertEquals(expected.getTitle(), actual.getTitle());
    }


    @Test
    void searchByID() {

        TodoModel entity = new TodoModel();
        entity.setId(123L);
        entity.setTitle("TITLE");
        entity.setOrder(0L);
        entity.setCompleted(false);

        Optional<TodoModel> optional = Optional.of(entity);

        given(this.todoRepository.findById(anyLong())).willReturn(optional);

        TodoModel actual = this.todoService.searchByID(123L);
        TodoModel expected = optional.get();

        assertEquals(expected.getId(), actual.getId());

        assertEquals(expected.getTitle(), actual.getTitle());

        assertEquals(expected.getOrder(), actual.getOrder());

        assertEquals(expected.getCompleted(), actual.getCompleted());


    }

    @Test
    public void searchByIdFailed() {
        given(this.todoRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            this.todoService.searchByID(123L);
        });

    }

}