package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;

public interface TodoItemsService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem (int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();

}
