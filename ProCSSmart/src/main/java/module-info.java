module com.example.procssmart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.procssmart to javafx.fxml;
    exports com.example.procssmart;
}