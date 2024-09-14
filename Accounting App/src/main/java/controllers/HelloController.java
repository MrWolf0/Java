package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.AccountData;

import java.io.File;


public class HelloController {

    @FXML
    private TableView<AccountData> dataTableView = new TableView<>();
    @FXML
    private TableColumn<AccountData, String> column1 = new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column2= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column3= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column4= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column5= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column6= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column7= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column8= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column9= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column10= new TableColumn<>();
    @FXML
    private TableColumn<AccountData, String> column11= new TableColumn<>();

    public  void initialize()
    {
        //createContentTable();

    }
    @FXML
    public void handleOpenxlsx()
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("اختيار ملفات الاكسيل");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel Sheets", "*.xlsx"));
        File selectedFile = chooser.showOpenDialog(null);
    }
    @FXML
//    public void createContentTable()
//    {
//        ObservableList<AccountData> accountDataList = FXCollections.observableArrayList();
//        column1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAccountName()));
//        column2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDebit()));
//        column3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCredit()));
//        column4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAccountCode()));
//        column5.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));
//        column6.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCostCenterCode()));
//        column7.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFinancialEntity()));
//        column8.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSubsidiaryCode()));
//        column9.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSubsidiaryAccount()));
//        column10.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCaseID()));
//        column11.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCaseName()));
//        dataTableView.setItems(accountDataList);
//    }


    public void copyElqaad(MouseEvent event)
    {
       //نسخ القيد
        System.out.println ( "fdgdgdgdggdgg" );
    }
}