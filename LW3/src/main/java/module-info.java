module com.example.lw3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lw3 to javafx.fxml;
    exports com.example.lw3;
}