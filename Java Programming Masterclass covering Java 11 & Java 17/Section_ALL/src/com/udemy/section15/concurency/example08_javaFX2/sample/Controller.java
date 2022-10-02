package com.udemy.section15.concurency.example08_javaFX2.sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

    //private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;

    public void initialize() {
        //all this commented code moved to EmployeeService:
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//                //Thread.sleep(1000);
//                String[] names = {"Tim Buchalka",
//                        "Bill Rogers",
//                        "Jack Jill",
//                        "Joan Andrews",
//                        "Mary Johnson",
//                        "Bob McDonald"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
//                for(int i = 0; i < 6; i++){
//                    employees.add(names[i]);
//                    updateMessage("Added " + names[i] + " to the list");
//                    updateProgress(i+1, 6);
//                    Thread.sleep(1000);
//                }
//
//                return employees;
//            }
//        };


//        progressBar.progressProperty().bind(task.progressProperty());
//        progressLabel.textProperty().bind(task.messageProperty());
//        listView.itemsProperty().bind(task.valueProperty());
        service = new EmployeeService();
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());

        //version_01:
//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                progressBar.setVisible(true);
//                progressLabel.setVisible(true);
//            }
//        });
//
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                progressBar.setVisible(false);
//                progressLabel.setVisible(false);
//            }
//        });
//
//        progressBar.setVisible(false);
//        progressLabel.setVisible(false);

        //version_02:
        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());


    }

    @FXML
    public void buttonPressed() {
        //new Thread(task).start();
        if(service.getState() == Service.State.SUCCEEDED) {
            service.reset();
            service.start();
        } else if(service.getState() == Service.State.READY) {
            service.start();
        }
    }
}



