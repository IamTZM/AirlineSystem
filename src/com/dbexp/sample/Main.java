package com.dbexp.sample;

import com.dbexp.check.Check;
import com.dbexp.sample.controller.HomeController;
import com.dbexp.sample.controller.LoginController;
import com.dbexp.sample.controller.ManageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        HomeController home = (HomeController) replaceSceneContent("fxml/HomePage.fxml");
        home.setApp(this);
        stage.show();
    }

    public void gotoLogin(){
        try {
            LoginController login = (LoginController) replaceSceneContent("fxml/LoginPage.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoManage(){
        try {
            ManageController main = (ManageController) replaceSceneContent("fxml/ManagePage.fxml");
            main.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userlogin(String account,String password){
        if(Check.checkreturn(account,password)) {
            gotoManage();
        }
    }

    public void useroutmain(){
        gotoLogin();
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
