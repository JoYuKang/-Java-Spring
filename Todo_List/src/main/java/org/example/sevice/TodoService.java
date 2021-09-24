package org.example.sevice;

import lombok.AllArgsConstructor;
import org.example.model.TodoModel;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //리스트 목록 추가
    public TodoModel add(TodoRequest request) {
        TodoModel todoModel = new TodoModel();
        todoModel.setTitle(request.getTitle());
        todoModel.setOrder(request.getOrder());
        todoModel.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoModel);
    }

    //리스트 목록 조회(ID)
    public TodoModel searchByID(Long id) {

        return this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    //리스트 목록 조회(전체)
    public List<TodoModel> searchAll() {
        return this.todoRepository.findAll();
    }

    //리스트 업데이트
    public TodoModel updateById(Long id, TodoRequest todoRequest) {
        TodoModel todoModel = this.searchByID(id);
        if (todoRequest.getTitle() != null) {
            todoModel.setTitle(todoRequest.getTitle());
        }
        if (todoRequest.getOrder() != null) {
            todoModel.setOrder(todoRequest.getOrder());
        }
        if (todoRequest.getCompleted() != null) {
            todoModel.setCompleted(todoRequest.getCompleted());
        }
        // 처음 생성할 떄와 같음
        return this.todoRepository.save(todoModel);
    }

    //리스트 삭제(ID)
    public void deleteById(Long id) {
        //delete에 반환값은 필요 없다.
        this.todoRepository.deleteById(id);
    }

    //리스트 삭제(전체)
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }

}
