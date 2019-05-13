package com.dbexp.sample.controller;

import com.dbexp.sample.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    private Main application;

    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    public void toLoginPage(ActionEvent event) {
        application.gotoLogin();
    }

    @FXML
    public void toQueryPage(ActionEvent event) {
        application.gotoManage();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
