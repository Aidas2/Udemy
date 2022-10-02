module academy.learnprogramming.ui {
//    requires javafx.base;                     //redundant due same exports inside
//    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires academy.learnprogramming.db;
//    requires academy.learnprogramming.common; //redundant due transitive dependency

    exports academy.learnprogramming.ui to javafx.graphics;
    opens academy.learnprogramming.ui to javafx.fxml;
}