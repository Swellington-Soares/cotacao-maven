package dev.swell.cotacao.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddressModel {
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

    // Construtor padrão
    public AddressModel() {}

    // Construtor com todos os campos
    public AddressModel(String cep, String logradouro, String complemento, String unidade,
                        String bairro, String localidade, String uf, String estado,
                        String regiao, String ibge, String gia, String ddd, String siafi) {
        this.cep.set(cep);
        this.logradouro.set(logradouro);
        this.complemento.set(complemento);
        this.unidade.set(unidade);
        this.bairro.set(bairro);
        this.localidade.set(localidade);
        this.uf.set(uf);
        this.estado.set(estado);
        this.regiao.set(regiao);
        this.ibge.set(ibge);
        this.gia.set(gia);
        this.ddd.set(ddd);
        this.siafi.set(siafi);
    }

    // Getters e setters + propriedades
    public String getCep() { return cep.get(); }
    public void setCep(String cep) { this.cep.set(cep); }
    public StringProperty cepProperty() { return cep; }

    public String getLogradouro() { return logradouro.get(); }
    public void setLogradouro(String logradouro) { this.logradouro.set(logradouro); }
    public StringProperty logradouroProperty() { return logradouro; }

    public String getComplemento() { return complemento.get(); }
    public void setComplemento(String complemento) { this.complemento.set(complemento); }
    public StringProperty complementoProperty() { return complemento; }

    public String getUnidade() { return unidade.get(); }
    public void setUnidade(String unidade) { this.unidade.set(unidade); }
    public StringProperty unidadeProperty() { return unidade; }

    public String getBairro() { return bairro.get(); }
    public void setBairro(String bairro) { this.bairro.set(bairro); }
    public StringProperty bairroProperty() { return bairro; }

    public String getLocalidade() { return localidade.get(); }
    public void setLocalidade(String localidade) { this.localidade.set(localidade); }
    public StringProperty localidadeProperty() { return localidade; }

    public String getUf() { return uf.get(); }
    public void setUf(String uf) { this.uf.set(uf); }
    public StringProperty ufProperty() { return uf; }

    public String getEstado() { return estado.get(); }
    public void setEstado(String estado) { this.estado.set(estado); }
    public StringProperty estadoProperty() { return estado; }

    public String getRegiao() { return regiao.get(); }
    public void setRegiao(String regiao) { this.regiao.set(regiao); }
    public StringProperty regiaoProperty() { return regiao; }

    public String getIbge() { return ibge.get(); }
    public void setIbge(String ibge) { this.ibge.set(ibge); }
    public StringProperty ibgeProperty() { return ibge; }

    public String getGia() { return gia.get(); }
    public void setGia(String gia) { this.gia.set(gia); }
    public StringProperty giaProperty() { return gia; }

    public String getDdd() { return ddd.get(); }
    public void setDdd(String ddd) { this.ddd.set(ddd); }
    public StringProperty dddProperty() { return ddd; }

    public String getSiafi() { return siafi.get(); }
    public void setSiafi(String siafi) { this.siafi.set(siafi); }
    public StringProperty siafiProperty() { return siafi; }
}
