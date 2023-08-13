package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.view.*;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class IndexStageController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    //新装备
    @FXML
    public void onHelloButtonClick1(ActionEvent actionEvent) {
        DemoApplication.showView(ZhuangBeiStageView.class);
    }
//说明书
    public void onHelloButtonClick2(ActionEvent actionEvent) {
        DemoApplication.showView(BookStageView.class);
    }
//维修步骤
    public void onHelloButtonClick3(ActionEvent actionEvent) {
        DemoApplication.showView(PrimaryStageView1.class);
    }
}

