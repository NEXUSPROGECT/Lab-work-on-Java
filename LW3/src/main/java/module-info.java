module com.example.lw3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires java.prefs;

    opens com.example.lw3 to jakarta.xml.bind, javafx.fxml;
    exports com.example.lw3;
}