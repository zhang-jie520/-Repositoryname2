package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dao.WeiXiuBuZhouDao;
import com.example.demo.dao.ZbDao;
import com.example.demo.dao.ZbGzDao;
import com.example.demo.dao.ZhuangBeiXinxiDao;
import com.example.demo.entry.WeiXiuBuZhou;
import com.example.demo.entry.Zb;
import com.example.demo.entry.ZbGz;
import com.example.demo.entry.ZhuangBeiXinxi;
import com.example.demo.view.IndexStageView;
import com.example.demo.view.PrimaryStageView;
import com.example.demo.view.PrimaryStageView1;
import com.example.demo.view.lingjianStageView;
import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class PrimaryStageController1 implements Initializable {
    @FXML
    private ListView<String> userList;
    private String username;
    @FXML
    private ListView<String> gzList;
    private String gzname;
    @FXML
    private ListView<String> bzList;
    private String bzname;

    @FXML
    private TextField updatezbField;
    @FXML
    private TextField updategzField;
    @FXML
    private TextField updateczbzField;
    @FXML
    private TextField savezbField;
    @FXML
    private TextField savegzField;
    @FXML
    private TextField saveczbzField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userList.getItems().add("请选择装备名字");
        gzList.getItems().add("请选择故障类型");
        bzList.getItems().add("请选择操作步骤");
        listshow();
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
    public void removeGzlist(){
        gzList.getSelectionModel().selectedItemProperty().removeListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                gzList.getSelectionModel().clearSelection();
            }
        });
        for (int i = gzList.getItems().size()-1; i >0; i--) {
            gzList.getItems().remove(i);
        }
    }
    public void removeBzlist(){
        bzList.getSelectionModel().selectedItemProperty().removeListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                bzList.getSelectionModel().clearSelection();
            }
        });
        for (int i = bzList.getItems().size()-1; i >0; i--) {
            bzList.getItems().remove(i);
        }
    }

    public void listshow(){
        ZbDao zbDao = new ZbDao();
        List<Zb> zbxxList = zbDao.selectAll();
        for (int i = 0; i < zbxxList.size(); i++) {
            userList.getItems().add(zbxxList.get(i).getZbname());
        }

        userList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                username = newValue;
                if(newValue == "请选择装备名字") {
                    removeGzlist();
                    removeBzlist();
                    updatezbField.setText(null);
                }
                else {
                    updatezbField.setText(username);
                    ZbGzDao zbGzDao = new ZbGzDao();
                    List<ZbGz> wxgzList = zbGzDao.selectAllByname(newValue);
                    removeGzlist();
                    removeBzlist();
                    for (int i = 0; i < wxgzList.size(); i++) {
                        gzList.getItems().add(wxgzList.get(i).getZbgztype());
                    }
                }
            }
        });
        gzList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                gzname = newValue;
                if(newValue == "请选择故障类型") {
                    removeBzlist();
                    updategzField.setText(null);
                }
                else {
                    updategzField.setText(gzname);
                    WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
                    WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
                    weiXiuBuZhou.setZhuangbei(username);
                    weiXiuBuZhou.setGztype(gzname);
                    List<WeiXiuBuZhou> wxbzlist = weiXiuBuZhouDao.selectAllByObject(weiXiuBuZhou);
                    removeBzlist();
                    for (int i = 0; i < wxbzlist.size(); i++) {
                        bzList.getItems().add(wxbzlist.get(i).getBuzhou());
                    }
                }
            }
        });
        bzList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                bzname = newValue;
                if(newValue == "请选择操作步骤") {
                    updateczbzField.setText(null);
                }
                else {
                    updateczbzField.setText(bzname);
                }
            }
        });
    }

    public void removeAllAndList() {
        updatezbField.setText(null);
        updategzField.setText(null);
        updateczbzField.setText(null);
        savezbField.setText(null);
        savegzField.setText(null);
        saveczbzField.setText(null);
        removeBzlist();
        removeGzlist();
        removelist();
        listshow();
    }

    public void updatezbButtonClick(ActionEvent actionEvent) {
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }
        else {
            ZbGzDao zbGzDao = new ZbGzDao();
            ZbGz zbGz = new ZbGz();
            zbGz.setZbgzname(updatezbField.getText());
            zbGzDao.updateAllByObject(username,zbGz);

            WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
            WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
            weiXiuBuZhou.setZhuangbei(updatezbField.getText());
            weiXiuBuZhouDao.updateAllByZb(username,weiXiuBuZhou);

            ZbDao zbDao = new ZbDao();
            Zb zb = new Zb();
            zb.setZbname(updatezbField.getText());
            zbDao.update(username,zb);

            removeAllAndList();
        }
    }
    public void deletezbButtonClick(ActionEvent actionEvent) {
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }
        else {
            WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
            WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
            weiXiuBuZhou.setZhuangbei(updatezbField.getText());
            weiXiuBuZhouDao.deleteAllByZb(weiXiuBuZhou);

            ZbGzDao zbGzDao = new ZbGzDao();
            ZbGz zbGz = new ZbGz();
            zbGz.setZbgzname(updatezbField.getText());
            zbGzDao.deleteAllByZb(zbGz);

            ZbDao zbDao = new ZbDao();
            Zb zb = new Zb();
            zb.setZbname(updatezbField.getText());
            zbDao.delete(zb);

            removeAllAndList();
        }
    }
    public void savezbButtonClick(ActionEvent actionEvent) {
        if(savezbField.getText() == null || savezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未输入相关内容");
            alert.show();
        }
        else {
            ZbDao zbDao = new ZbDao();
            Zb zb = new Zb();
            zb.setZbname(savezbField.getText());
            zbDao.save(zb);
            removeAllAndList();
        }
    }

    public void updategzButtonClick(ActionEvent actionEvent) {
        //先有装备
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }//再有故障类型
        else {
            if(updategzField.getText() == null || updategzField.getText().trim().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("未选择故障类型");
                alert.show();
            }//最后有值
            else {
                ZbGzDao zbGzDao = new ZbGzDao();
                ZbGz zbGz = new ZbGz();
                zbGz.setZbgzname(updatezbField.getText());
                zbGz.setZbgztype(updategzField.getText());
                zbGzDao.update(gzname,zbGz);

                WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
                WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
                weiXiuBuZhou.setZhuangbei(updatezbField.getText());
                weiXiuBuZhou.setGztype(updategzField.getText());
                weiXiuBuZhouDao.updateAllByGz(gzname,weiXiuBuZhou);

                removeAllAndList();
            }
        }
    }

    public void deletegzButtonClick(ActionEvent actionEvent) {
        //先有装备
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }//再有待删除的故障
        else {
            if(updategzField.getText() == null || updategzField.getText().trim().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("未选择故障");
                alert.show();
            }
            else {
                WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
                WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
                weiXiuBuZhou.setZhuangbei(updatezbField.getText());
                weiXiuBuZhou.setGztype(updategzField.getText());
                weiXiuBuZhouDao.deleteAllByGz(weiXiuBuZhou);

                ZbGzDao zbGzDao = new ZbGzDao();
                ZbGz zbGz = new ZbGz();
                zbGz.setZbgzname(updatezbField.getText());
                zbGz.setZbgztype(updategzField.getText());
                zbGzDao.delete(zbGz);

                removeAllAndList();
            }
        }
    }

    public void savegzButtonClick(ActionEvent actionEvent) {
        //先有装备
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }//再有添加的值
        else {
            if(savegzField.getText() == null || savegzField.getText().trim().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("未输入相关内容");
                alert.show();
            }
            else {
                ZbGzDao zbGzDao = new ZbGzDao();
                ZbGz zbGz = new ZbGz();
                zbGz.setZbgzname(updatezbField.getText());
                zbGz.setZbgztype(savegzField.getText());
                zbGzDao.save(zbGz);
                removeAllAndList();
            }
        }
    }

    public void updateczbzButtonClick(ActionEvent actionEvent) {
        //先有装备
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }//再有故障类型
        else {
            if(updategzField.getText() == null || updategzField.getText().trim().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("未选择故障类型");
                alert.show();
            }//最后有值
            else {
                if(updateczbzField.getText() == null || updateczbzField.getText().trim().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择维修步骤");
                    alert.show();
                }
                else {

                    WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
                    WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
                    weiXiuBuZhou.setZhuangbei(updatezbField.getText());
                    weiXiuBuZhou.setGztype(updategzField.getText());
                    weiXiuBuZhou.setBuzhou(updateczbzField.getText());
                    weiXiuBuZhouDao.update(bzname,weiXiuBuZhou);
                    removeAllAndList();
                }
            }
        }
    }

    public void deleteczbzButtonClick(ActionEvent actionEvent) {
        //先有装备
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }//再有故障类型
        else {
            if(updategzField.getText() == null || updategzField.getText().trim().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("未选择故障类型");
                alert.show();
            }//最后有值
            else {
                if(updateczbzField.getText() == null || updateczbzField.getText().trim().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择维修步骤");
                    alert.show();
                }
                else {
                    WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
                    WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
                    weiXiuBuZhou.setZhuangbei(updatezbField.getText());
                    weiXiuBuZhou.setGztype(updategzField.getText());
                    weiXiuBuZhou.setBuzhou(updateczbzField.getText());
                    weiXiuBuZhouDao.delete(weiXiuBuZhou);
                    removeAllAndList();
                }
            }
        }
    }

    public void saveczbzButtonClick(ActionEvent actionEvent) {
        //先有装备
        if(updatezbField.getText() == null || updatezbField.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("未选择装备");
            alert.show();
        }//再有故障类型
        else {
            if(updategzField.getText() == null || updategzField.getText().trim().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("未选择故障类型");
                alert.show();
            }//最后有值
            else {
                if(saveczbzField.getText() == null || saveczbzField.getText().trim().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("错误");
                    alert.setHeaderText("未输入相关内容");
                    alert.show();
                }
                else {
                    WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
                    WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
                    weiXiuBuZhou.setZhuangbei(updatezbField.getText());
                    weiXiuBuZhou.setGztype(updategzField.getText());
                    weiXiuBuZhou.setBuzhou(saveczbzField.getText());
                    weiXiuBuZhouDao.save(weiXiuBuZhou);
                    removeAllAndList();
                }
            }
        }
    }

    public void backButtonClick(ActionEvent actionEvent) {
        removeAllAndList();
        DemoApplication.showView(IndexStageView.class);
    }
}

