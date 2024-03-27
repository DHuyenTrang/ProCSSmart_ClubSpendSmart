module com.example.procssmart.View{
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.procssmart to javafx.fxml;
    exports com.example.procssmart.View;
    exports com.example.procssmart.Model;
    opens com.example.procssmart.View to javafx.fxml;
}