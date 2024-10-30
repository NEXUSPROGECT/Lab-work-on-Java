package com.example.lw3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class PersonOverviewController {
    @FXML
    private TableView<Person> prodTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> sizeColumn;
    @FXML
    private TableColumn<Person, String> weightColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label sizeLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label nameCompanyLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label contactPersonLabel;
    @FXML
    private Label phoneLabel;

    // Ссылка на главное приложение.
    private LW3labWork mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public PersonOverviewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        showPersonDetails(null);
        // Инициализация таблицы адресатов с двумя столбцами.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        sizeColumn.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());
        weightColumn.setCellValueFactory(cellData -> cellData.getValue().weightProperty());

        prodTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }



    // Слушаем изменения выбора, и при изменении отображаем
    // дополнительную информацию об адресате.

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(LW3labWork mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        prodTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.
            nameLabel.setText(person.getName());
            sizeLabel.setText(person.getSize());
            weightLabel.setText(person.getWeight());
            nameCompanyLabel.setText(person.getCompany());
            countryLabel.setText(person.getCountry());
            contactPersonLabel.setText(person.getContactPerson());
            phoneLabel.setText(person.getPhone());

            // TODO: Нам нужен способ для перевода дня рождения в тип String!
            // birthdayLabel.setText(...);
        } else {
            // Если Person = null, то убираем весь текст.
            nameLabel.setText("");
            sizeLabel.setText("");
            weightLabel.setText("");
            nameCompanyLabel.setText("");
            countryLabel.setText("");
            contactPersonLabel.setText("");
            phoneLabel.setText("");
        }
    }


    @FXML
    private void handleDeletePerson() {
        int selectedIndex = prodTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            prodTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопка Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = prodTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}
