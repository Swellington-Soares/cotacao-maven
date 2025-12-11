package dev.swell.cotacao.controller;

import dev.swell.cotacao.MainApp;
import dev.swell.cotacao.model.AddressData;
import dev.swell.cotacao.model.AddressModel;
import dev.swell.cotacao.viewmodel.AddressDetailViewModel;
import dev.swell.cotacao.viewmodel.AddressViewModel;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage primaryStage;

    @FXML
    private TableColumn<AddressModel, String> cidadeColumn;

    @FXML
    private TableColumn<AddressModel, String> estadoColumn;

    @FXML
    private TableColumn<AddressModel, String> logradouroColumn;

    @FXML
    private TableView<AddressModel> tableView;

    @FXML
    private TextField textFieldPesquisar;

    @FXML
    private Button btnPesquisar;


    private final AddressViewModel addressViewModel = new AddressViewModel();

    private String lastText = "";

    @FXML
    void btnPesquisarAction(ActionEvent event) {
        String cep = textFieldPesquisar.getText().trim();
        lastText = cep;
        addressViewModel.findAddressInfo(cep);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        textFieldPesquisar.disableProperty().bindBidirectional(addressViewModel.isLoadingProperty());
        btnPesquisar.disableProperty().bind(addressViewModel.isLoadingProperty());
        tableView.setItems(addressViewModel.getAddresses());

        cidadeColumn.setCellValueFactory(new PropertyValueFactory<>("localidade"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("uf"));
        logradouroColumn.setCellValueFactory(new PropertyValueFactory<>("logradouro"));


        addressViewModel.isLoadingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                textFieldPesquisar.setText("PESQUISANDO....");
            } else {
                textFieldPesquisar.setText(lastText);
            }
        });

        tableView.setRowFactory(rv -> {
            TableRow<AddressModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    AddressModel selected = row.getItem();
                    try {
                        showDetail(selected);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            return row;
        });

        Platform.runLater(() -> primaryStage = (Stage) textFieldPesquisar.getScene().getWindow());
    }

    private void showDetail(AddressModel item) throws IOException {
        System.out.println(primaryStage);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.setResizable(false);
        FXMLLoader loader = MainApp.loaderView("address-detail-view");
        loader.setController(new AddressDetailController( item ));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Detalhe do endereço: " + item.getCep());
        stage.setScene(scene);
        stage.showAndWait();
    }
}
