module bd.edu.seu.hms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens bd.edu.seu.hms to javafx.fxml;
    exports bd.edu.seu.hms;
    exports bd.edu.seu.hms.Controller;
    opens bd.edu.seu.hms.Controller to javafx.fxml;
    exports bd.edu.seu.hms.Controller.Receptionist;
    opens bd.edu.seu.hms.Controller.Receptionist to javafx.fxml;
    exports bd.edu.seu.hms.Controller.Doctor;
    opens bd.edu.seu.hms.Controller.Doctor to javafx.fxml;
    exports bd.edu.seu.hms.Controller.Pharmacist;
    opens bd.edu.seu.hms.Controller.Pharmacist to javafx.fxml;
}