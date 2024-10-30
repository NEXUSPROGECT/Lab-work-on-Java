package com.example.lw3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.lw3.Person;

/**
 * Окно для изменения информации об адресате.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField nameCompanyField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField contactPersonField;
    @FXML
    private TextField phoneField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        nameField.setText(person.getName());
        sizeField.setText(person.getSize());
        weightField.setText(person.getWeight());
        nameCompanyField.setText(person.getCompany());
        countryField.setText(person.getCountry());
        contactPersonField.setText(person.getContactPerson());
        phoneField.setText(person.getPhone());
    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setName(nameField.getText());
            person.setSize(sizeField.getText());
            person.setWeight(weightField.getText());
            person.setCompany(nameCompanyField.getText());
            person.setCountry(countryField.getText());
            person.setContactPerson(contactPersonField.getText());
            person.setPhone(phoneField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (sizeField.getText() == null || sizeField.getText().length() == 0) {
            errorMessage += "No valid size!\n";
        }
        if (weightField.getText() == null || weightField.getText().length() == 0) {
            errorMessage += "No valid weight!\n";
        }

        if (nameCompanyField.getText() == null || nameCompanyField.getText().length() == 0) {
            errorMessage += "No valid nameCompany!\n";
        }


        if (countryField.getText() == null || countryField.getText().length() == 0) {
            errorMessage += "No valid country!\n";
        }

        if (contactPersonField.getText() == null || contactPersonField.getText().length() == 0) {
            errorMessage += "No valid contactPerson!\n";
        }

        if (phoneField.getText() == null || phoneField.getText().length() == 0) {
            errorMessage += "No valid phone!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
