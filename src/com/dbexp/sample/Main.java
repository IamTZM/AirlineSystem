package com.dbexp.sample;

import com.dbexp.check.Check;
import com.dbexp.sample.controller.HomeController;
import com.dbexp.sample.controller.LoginController;
import com.dbexp.sample.controller.ManageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        gotoHome();
        stage.show();
    }

    public void gotoHome() {
        try {
            HomeController home = (HomeController) replaceSceneContent("fxml/HomePage.fxml");
            home.setApp(this);
            stage.setTitle("票务系统");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("fxml/LoginPage.fxml");
            login.setApp(this);
            stage.setTitle("登录页");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoManage() {
        try {
            ManageController manage = (ManageController) getBorderPane("fxml/ManagePage.fxml");
            manage.setApp(this);
            stage.setTitle("查询页");
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
            page = loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        // 居中
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - 800) / 2);
        stage.setY((screenBounds.getHeight() - 600) / 2);
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    private Initializable getBorderPane(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        BorderPane page;
        try {
            page = loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 1080, 720);
        stage.setScene(scene);
        stage.sizeToScene();
        // 居中
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - 1080) / 2);
        stage.setY((screenBounds.getHeight() - 720) / 2);
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
