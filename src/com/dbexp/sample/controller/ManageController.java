package com.dbexp.sample.controller;

import com.dbexp.sample.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: Steph
 * @Date: 2019/5/12
 */
public class ManageController implements Initializable {
    private Main application;

    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    private void OUT_M(ActionEvent event) {
        application.gotoHome();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
