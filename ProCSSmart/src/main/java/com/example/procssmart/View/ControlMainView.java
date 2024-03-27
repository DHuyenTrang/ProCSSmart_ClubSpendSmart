package com.example.procssmart.View;

import com.example.procssmart.Controller.AddMoney;
import com.example.procssmart.Model.Money;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ControlMainView {

    @FXML
    private Button addNewMoneyButton;

    @FXML
    private TableColumn<?, ?> content;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private GridPane layoutAddMoney;

    @FXML
    private DatePicker pickDate;

    @FXML
    private Button showAddLayoutButton;

    @FXML
    private TableView<?> tableData;

    @FXML
    private TextField textContent;

    @FXML
    private TextField textValue;

    @FXML
    private TableColumn<?, ?> type;

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
    private TableColumn<?, ?> value;
    String getType;

    @FXML
    void addMoney(ActionEvent event) {
        String content = textContent.getText();
        String date = pickDate.getValue().toString();
        String value = textValue.getText();

        Money money = new Money(content, getType, date, value);
        AddMoney addNew = new AddMoney();
        addNew.add(money);

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

}
