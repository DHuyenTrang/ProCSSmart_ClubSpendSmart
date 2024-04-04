package com.example.procssmart.View;

import com.example.procssmart.Controller.AddMoney;
import com.example.procssmart.Controller.SortByDate;
import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControlMainView implements Initializable {
    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonIncome;

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonReport;

    @FXML
    private Button addNewMoneyButton;

    @FXML
    private TableColumn<Money, String> content;

    @FXML
    private TableColumn<Money, String> date;

    @FXML
    private GridPane layoutAddMoney;

    @FXML
    private DatePicker pickDate;

    @FXML
    private Button showAddLayoutButton;

    @FXML
    private TableView<Money> tableData;

    @FXML
    private TextField textContent;

    @FXML
    private TextField textValue;

    @FXML
    private TableColumn<Money, String> type;

    @FXML
    private RadioButton type1;

    @FXML
    private RadioButton type2;

    @FXML
    private RadioButton type3;

    @FXML
    private RadioButton type4;
    @FXML
    private Label labelSuccessful;

    @FXML
    private TableColumn<Money, String> value;
    ReadData read = new ReadData();
    List<Money> moneyListIn = read.readToListIn();
    List<Money> moneyListOut = read.readToListOut();
    List<Money> moneyList = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        moneyList.addAll(moneyListOut);
        moneyList.addAll(moneyListIn);
        moneyList.sort(new SortByDate());

        ObservableList<Money> moneyObservableList = FXCollections.observableArrayList(moneyList);

        content.setCellValueFactory(new PropertyValueFactory<Money, String>("content"));
        date.setCellValueFactory(new PropertyValueFactory<Money, String>("date"));
        value.setCellValueFactory(new PropertyValueFactory<Money, String>("value"));
        type.setCellValueFactory(new PropertyValueFactory<Money, String>("type"));

        tableData.setItems(moneyObservableList);
    }
    @FXML
    void sceneHome(ActionEvent event){}

    @FXML
    void sceneIncome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("income-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void scenePayment(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payment-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sceneReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("report-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
