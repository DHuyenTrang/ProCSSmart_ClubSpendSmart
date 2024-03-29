package com.example.procssmart.View;

import com.example.procssmart.Controller.AddMoney;
import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControlMainView implements Initializable {

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
    String getType;
    ReadData read = new ReadData();
    List<Money> moneyList = read.readToList();
    ObservableList<Money> moneyObservableList = FXCollections.observableArrayList(moneyList);

    @FXML
    void addMoney(ActionEvent event) {
        String content = textContent.getText();
        String date = pickDate.getValue().toString();
        String value = textValue.getText();

        Money money = new Money(content, getType, date, value);
        AddMoney addNew = new AddMoney();
        addNew.add(money);
        moneyObservableList.add(money);

        labelSuccessful.setText("Thêm khoản chi thành công!");
    }

    @FXML
    void showAddLayout(ActionEvent event) {
        layoutAddMoney.setVisible(true);

        ToggleGroup groupChooseType = new ToggleGroup();
        type1.setToggleGroup(groupChooseType);
        type2.setToggleGroup(groupChooseType);
        type3.setToggleGroup(groupChooseType);
        type4.setToggleGroup(groupChooseType);

        groupChooseType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radio = (RadioButton) t1;
                getType = radio.getText();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        content.setCellValueFactory(new PropertyValueFactory<Money, String>("content"));
        date.setCellValueFactory(new PropertyValueFactory<Money, String>("date"));
        value.setCellValueFactory(new PropertyValueFactory<Money, String>("value"));
        type.setCellValueFactory(new PropertyValueFactory<Money, String>("type"));

        tableData.setItems(moneyObservableList);
    }
}
