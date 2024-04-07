package com.example.procssmart.View;

import com.example.procssmart.Controller.AddMoney;
import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControlPaymentView implements Initializable {

    @FXML
    private Button VisibleAdd;

    @FXML
    private Button addNewMoneyButton;

    @FXML
    private Button buttonSubmit;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonIncome;

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonReport;

    @FXML
    private Button buttonXAdd;

    @FXML
    private Button buttonXFix;

    @FXML
    private TableColumn<Money, String> content;

    @FXML
    private TableColumn<Money, String> date;

    @FXML
    private TextField fixContent;

    @FXML
    private DatePicker fixDate;

    @FXML
    private TextField fixValue;

    @FXML
    private Label labelSuccessful;

    @FXML
    private GridPane layoutAddMoney;

    @FXML
    private GridPane layoutFixMoney;

    @FXML
    private DatePicker pickDate;

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
    private RadioButton type11;

    @FXML
    private RadioButton type2;

    @FXML
    private RadioButton type21;

    @FXML
    private RadioButton type3;

    @FXML
    private RadioButton type31;

    @FXML
    private RadioButton type4;

    @FXML
    private RadioButton type41;

    @FXML
    private TableColumn<Money, String> value;
    @FXML
    private Button buttonDelete;
    String getType;
    ReadData read = new ReadData();
    List<Money> moneyList = read.readToListOut();
    ObservableList<Money> moneyObservableList = FXCollections.observableArrayList(moneyList);

    @FXML
    void DisableAdd(ActionEvent event) {
        layoutAddMoney.setVisible(false);
    }

    @FXML
    void DisableFix(ActionEvent event) {
        layoutFixMoney.setVisible(false);
    }
    String contentFix;
    ToggleGroup groupChooseType = new ToggleGroup();
    FXMLLoader fxmlLoader;
    AddMoney addNew = new AddMoney();

    @FXML
    void DeleteMoney(ActionEvent event) {
        contentFix = fixContent.getText();

        for(Money money: moneyObservableList){
            if(Objects.equals(money.getContent(), contentFix)){
                moneyObservableList.remove(money);

                tableData.setItems(moneyObservableList);
                tableData.refresh();
                layoutFixMoney.setVisible(false);

                break;
            }
        }
        addNew.clearOut();
        for(Money money: moneyObservableList){
            addNew.addPayment(money);
        }
    }

    @FXML
    void VisibleAdd(ActionEvent event) {
        layoutAddMoney.setVisible(true);

        type1.setToggleGroup(groupChooseType);
        type2.setToggleGroup(groupChooseType);
        type3.setToggleGroup(groupChooseType);
        type4.setToggleGroup(groupChooseType);
        groupChooseType.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton radio = (RadioButton) t1;
            getType = radio.getText();
        });
    }
    @FXML
    void addMoney(ActionEvent event) {

        String content = textContent.getText();
        String date = pickDate.getValue().toString();
        String value = textValue.getText();

        Money money = new Money(content, getType, date, value);

        addNew.addPayment(money);
        moneyObservableList.add(money);

        labelSuccessful.setText("Thêm khoản chi thành công!");
    }

    @FXML
    void rowClicked(MouseEvent event) {
        layoutFixMoney.setVisible(true);

        Money moneyClicked = (Money) tableData.getSelectionModel().getSelectedItem();
        contentFix = moneyClicked.getContent();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(moneyClicked.getDate(), formatter);

        fixContent.setText(String.valueOf(moneyClicked.getContent()));
        fixDate.setValue(date);
        fixValue.setText(String.valueOf(moneyClicked.getValue()));

        type11.setToggleGroup(groupChooseType);
        type21.setToggleGroup(groupChooseType);
        type31.setToggleGroup(groupChooseType);
        type41.setToggleGroup(groupChooseType);
        groupChooseType.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton radio = (RadioButton) t1;
            getType = radio.getText();
        });
    }
    @FXML
    void fixMoney(ActionEvent event) {
        ObservableList<Money> currentTableDate = tableData.getItems();
        for(Money money: currentTableDate){
            if(Objects.equals(money.getContent(), contentFix)){

                money.setContent(fixContent.getText());
                money.setValue(fixValue.getText());
                money.setDate(String.valueOf(fixDate.getValue()));
                money.setType(getType);

                tableData.setItems(currentTableDate);
                tableData.refresh();
                break;
            }
        }

        layoutFixMoney.setVisible(false);
    }
    @FXML
    void sceneHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sceneIncome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader(getClass().getResource("income-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void scenePayment(ActionEvent event) {

    }

    @FXML
    void sceneReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader(getClass().getResource("report-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
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
