package dev.swell.cotacao.controller;

import dev.swell.cotacao.model.AddressModel;
import dev.swell.cotacao.viewmodel.AddressDetailViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class AddressDetailController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldBairro;

    @FXML
    private TextField textFieldCep;

    @FXML
    private TextField textFieldComplemento;

    @FXML
    private TextField textFieldDDD;

    @FXML
    private TextField textFieldLocalidade;

    @FXML
    private TextField textFieldLogradouro;

    @FXML
    private TextField textFieldRegiao;

    @FXML
    private TextField textFieldUf;

    @FXML
    private TextField textFieldUnidade;

    private final AddressDetailViewModel  viewModel = new AddressDetailViewModel();

    @FXML
    void initialize() {
        textFieldBairro.textProperty().bind(viewModel.getBairroProperty());
        textFieldCep.textProperty().bind(viewModel.getCepProperty());
        textFieldComplemento.textProperty().bind(viewModel.getComplementoProperty());
        textFieldDDD.textProperty().bind(viewModel.getDddProperty());
        textFieldLocalidade.textProperty().bind(viewModel.getLocalidadeProperty());
        textFieldLogradouro.textProperty().bind(viewModel.getLogradouroProperty());
        textFieldRegiao.textProperty().bind(viewModel.getRegiaoProperty());
        textFieldUf.textProperty().bind(viewModel.getUfProperty());
        textFieldUnidade.textProperty().bind(viewModel.getUnidadeProperty());
    }

    public AddressDetailController(AddressModel address) {
        viewModel.update(address);
    }


}
