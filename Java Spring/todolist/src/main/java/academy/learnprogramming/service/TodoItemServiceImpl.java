package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemsService {

    @Getter
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

//    @Override     // replaced with Lombok annotation @Getter
//    public TodoData getData() {
//        return data;
//    }
}
