package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dao.ChaiZhuangTimeDao;
import com.example.demo.dao.ZhuangBeiXinxiDao;
import com.example.demo.entry.ChaiZhuangTime;
import com.example.demo.entry.ZhuangBeiXinxi;
import com.example.demo.view.IndexStageView;
import com.example.demo.view.PrimaryStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class lingjianStageController implements Initializable {

    private static String zhuangbeiname;
    public void setzbname(String s){
        this.zhuangbeiname = s;
    }

    @FXML
    private ListView<String> userList;
//  修改
    @FXML
    private Label updatediynameField;
    @FXML
    private TextField updatesumlingjianField;
    @FXML
    private TextField updateshunxuhzField;
//  保存
    @FXML
    private TextField savediynameField;
    @FXML
    private TextField savesumlingjianField;
    @FXML
    private TextField saveshunxuhzField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userList.getItems().add("请点击下方零件名字");
    }



    public void removelist(){
        userList.getSelectionModel().selectedItemProperty().removeListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                userList.getSelectionModel().clearSelection();
            }
        });
        for (int i = userList.getItems().size()-1; i >0; i--) {
            userList.getItems().remove(i);
        }
    }

    public void listButtonClick(){
        ChaiZhuangTimeDao chaiZhuangTimeDao = new ChaiZhuangTimeDao();
        List<ChaiZhuangTime> zbxxList = chaiZhuangTimeDao.selectAll(zhuangbeiname);
        for (int i = 0; i < zbxxList.size(); i++) {
            userList.getItems().add(zbxxList.get(i).getLjname());
        }


        userList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue == "请点击下方零件名字") {
                    updatediynameField.setText(null);
                    updatesumlingjianField.setText(null);
                    updateshunxuhzField.setText(null);
                }
                else {
                    ChaiZhuangTime chaiZhuangTime = new ChaiZhuangTime();
                    chaiZhuangTime.setZbname(zhuangbeiname);
                    chaiZhuangTime.setLjname(newValue);
                    ChaiZhuangTime zbxx = chaiZhuangTimeDao.selectObjectByName(chaiZhuangTime);
                    updatediynameField.setText(zbxx.getLjname());
                    updatesumlingjianField.setText(zbxx.getChaitime());
                    updateshunxuhzField.setText(zbxx.getZhuangtime());
                }
            }
        });
    }

    public void saveButtonClick(ActionEvent actionEvent) {
        ChaiZhuangTimeDao chaiZhuangTimeDao = new ChaiZhuangTimeDao();
        ChaiZhuangTime chaiZhuangTime = new ChaiZhuangTime();
        chaiZhuangTime.setZbname(zhuangbeiname);
        chaiZhuangTime.setLjname(savediynameField.getText());
        chaiZhuangTime.setChaitime(savesumlingjianField.getText());
        chaiZhuangTime.setZhuangtime(saveshunxuhzField.getText());
        chaiZhuangTimeDao.save(chaiZhuangTime);
        removelist();
        listButtonClick();
        savediynameField.setText(null);
        savesumlingjianField.setText(null);
        saveshunxuhzField.setText(null);
    }

    public void updateButtonClick(ActionEvent actionEvent) {
        ChaiZhuangTimeDao chaiZhuangTimeDao = new ChaiZhuangTimeDao();
        ChaiZhuangTime chaiZhuangTime = new ChaiZhuangTime();
        chaiZhuangTime.setZbname(zhuangbeiname);
        chaiZhuangTime.setLjname(updatediynameField.getText());
        chaiZhuangTime.setChaitime(updatesumlingjianField.getText());
        chaiZhuangTime.setZhuangtime(updateshunxuhzField.getText());
        chaiZhuangTimeDao.update(chaiZhuangTime);
        removelist();
        listButtonClick();
        updatediynameField.setText(null);
        updatesumlingjianField.setText(null);
        updateshunxuhzField.setText(null);
    }

    public void backButtonClick(ActionEvent actionEvent) {
        updatediynameField.setText(null);
        updatesumlingjianField.setText(null);
        updateshunxuhzField.setText(null);
        savediynameField.setText(null);
        savesumlingjianField.setText(null);
        saveshunxuhzField.setText(null);
        removelist();
        DemoApplication.showView(IndexStageView.class);
    }

    public void deleteButtonClick(ActionEvent actionEvent) {
        ChaiZhuangTimeDao chaiZhuangTimeDao = new ChaiZhuangTimeDao();
        ChaiZhuangTime chaiZhuangTime = new ChaiZhuangTime();
        chaiZhuangTime.setZbname(zhuangbeiname);
        chaiZhuangTime.setLjname(updatediynameField.getText());
        chaiZhuangTimeDao.delete(chaiZhuangTime);
        removelist();
        listButtonClick();
        updatediynameField.setText(null);
        updatesumlingjianField.setText(null);
        updateshunxuhzField.setText(null);
    }
}

