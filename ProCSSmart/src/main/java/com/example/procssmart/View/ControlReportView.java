package com.example.procssmart.View;

import com.example.procssmart.Controller.MonthlyManage;
import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControlReportView implements Initializable {

    @FXML
    private Button buttonApply;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonIncome;

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonReport;

    @FXML
    private ChoiceBox<String> chooseMonth;

    @FXML
    private ChoiceBox<String> chooseYear;
    @FXML
    private TextArea textIncome;
    @FXML
    private TextArea textPayment;
    FXMLLoader fxmlLoader;
    @FXML
    void VisibleReport(ActionEvent event) {
        String time = chooseYear.getValue() + "-" + chooseMonth.getValue();

        MonthlyManage manage = new MonthlyManage();
        textPayment.clear();
        textIncome.clear();

        textIncome.appendText("Dư không nợ tháng trước: " + manage.getMoneyCurrent(time) + "\n");
        ReadData read = new ReadData();
        List<Money> moneyList = read.readToList();
        for(Money money: moneyList){
            if(Objects.equals(money.getMonthYear(), time)){
                if(Objects.equals(money.getType(), "Tiền quỹ vào")) textIncome.appendText(money.toString());
                else textPayment.appendText(money.toString());
            }

        }

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
    void scenePayment(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader(getClass().getResource("payment-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sceneReport(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] month = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        chooseMonth.getItems().addAll(month);

        String[] year = {"2023", "2024"};
        chooseYear.getItems().addAll(year);

    }
}
