package com.example.procssmart.View;

import com.example.procssmart.Controller.AddMoney;
import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class ControlIncomeView implements Initializable {

    @FXML
    private Button addNewMoneyButton;

    @FXML
    private Button addNewMoneyButton1;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonIncome;

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonReport;

    @FXML
    private Button buttonCloseAdd;

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
    private TableColumn<Money, String> value;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonAdd;


    @FXML
    void DisableFix(ActionEvent event) {
        layoutFixMoney.setVisible(false);
    }
    ReadData read = new ReadData();
    List<Money> moneyList = read.readToListIn();
    ObservableList<Money> moneyObservableList = FXCollections.observableArrayList(moneyList);
    FXMLLoader fxmlLoader;
    String contentFix;
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
        addNew.clearIn();
        for(Money money: moneyObservableList){
            System.out.println(moneyObservableList.size());
            //money.setType("Tiền quỹ vào");
            addNew.addIncome(money);
        }
    }
    @FXML
    void AddMoney(ActionEvent event) throws IOException {
        layoutAddMoney.setVisible(true);
    }

    @FXML
    void DisableAdd(ActionEvent event) {
        layoutAddMoney.setVisible(false);
    }

    @FXML
    void addMoney(ActionEvent event) {
        String content = textContent.getText();
        String date = pickDate.getValue().toString();
        String value = textValue.getText();

        Money money = new Money(content, "Tiền quỹ vào", date, value);

        addNew.addIncome(money);
        moneyObservableList.add(money);

        layoutAddMoney.setVisible(false);
    }

    @FXML
    void buttonSubmit(ActionEvent event) {
        ObservableList<Money> currentTableDate = tableData.getItems();
        for(Money money: currentTableDate){
            if(Objects.equals(money.getContent(), contentFix)){
                money.setContent(fixContent.getText());
                money.setValue(fixValue.getText());
                money.setDate(String.valueOf(fixDate.getValue()));

                tableData.setItems(currentTableDate);
                tableData.refresh();
                break;
            }
        }
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
    void sceneIncome(ActionEvent event){}
    @FXML
    void scenePayment(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader(getClass().getResource("payment-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
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
