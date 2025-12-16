package dev.swell.viacep.viewmodel;

import dev.swell.viacep.model.AddressModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddressDetailViewModel {

    private final StringProperty cep = new SimpleStringProperty();
    private final StringProperty logradouro = new SimpleStringProperty();
    private final StringProperty complemento = new SimpleStringProperty();
    private final StringProperty unidade = new SimpleStringProperty();
    private final StringProperty bairro = new SimpleStringProperty();
    private final StringProperty localidade = new SimpleStringProperty();
    private final StringProperty uf = new SimpleStringProperty();
    private final StringProperty estado = new SimpleStringProperty();
    private final StringProperty regiao = new SimpleStringProperty();
    private final StringProperty ibge = new SimpleStringProperty();
    private final StringProperty gia = new SimpleStringProperty();
    private final StringProperty ddd = new SimpleStringProperty();
    private final StringProperty siafi = new SimpleStringProperty();


    public StringProperty getCepProperty() {
        return cep;
    }

    public StringProperty getLogradouroProperty() {
        return logradouro;
    }

    public StringProperty getComplementoProperty() {
        return complemento;
    }

    public StringProperty getUnidadeProperty() {
        return unidade;
    }

    public StringProperty getBairroProperty() {
        return bairro;
    }

    public StringProperty getLocalidadeProperty() {
        return localidade;
    }

    public StringProperty getUfProperty() {
        return uf;
    }

    public StringProperty getEstadoProperty() {
        return estado;
    }

    public StringProperty getRegiaoProperty() {
        return regiao;
    }

    public StringProperty getIbgeProperty() {
        return ibge;
    }

    public StringProperty getGiaProperty() {
        return gia;
    }

    public StringProperty getDddProperty() {
        return ddd;
    }

    public StringProperty getSiafiProperty() {
        return siafi;
    }

    public void update(AddressModel addressModel) {
        this.cep.set(addressModel.getCep());
        this.logradouro.set(addressModel.getLogradouro());
        this.complemento.set(addressModel.getComplemento());
        this.unidade.set(addressModel.getUnidade());
        this.bairro.set(addressModel.getBairro());
        this.localidade.set(addressModel.getLocalidade());
        this.uf.set(addressModel.getUf());
        this.estado.set(addressModel.getEstado());
        this.regiao.set(addressModel.getRegiao());
        this.ibge.set(addressModel.getIbge());
        this.gia.set(addressModel.getGia());
        this.ddd.set(addressModel.getDdd());
        this.siafi.set(addressModel.getSiafi());
    }
}
