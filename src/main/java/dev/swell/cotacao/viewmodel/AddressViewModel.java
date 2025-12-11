package dev.swell.cotacao.viewmodel;

import dev.swell.cotacao.api.Cache;
import dev.swell.cotacao.api.ViaCepAPI;
import dev.swell.cotacao.model.AddressData;
import dev.swell.cotacao.model.AddressMapper;
import dev.swell.cotacao.model.AddressModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AddressViewModel {

    private final ViaCepAPI api = new ViaCepAPI();
    private final ObservableList<AddressModel> _addresses = FXCollections.observableArrayList();
    private final SimpleBooleanProperty _isLoading =  new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty _isError =  new SimpleBooleanProperty(false);

    public SimpleBooleanProperty isLoadingProperty() {
        return _isLoading;
    }

    public ObservableList<AddressModel> getAddresses() {
        return _addresses;
    }

    public SimpleBooleanProperty isErrorProperty() {
        return _isError;
    }


    private void addAddress(AddressModel address) {
        if (_addresses.stream().noneMatch( a -> a.getCep().equalsIgnoreCase(address.getCep())))
        {
            _addresses.add(address);
        }
    }

    public void findAddressInfo(String cep) {
        if (cep == null || cep.isBlank()) return;
        _isLoading.setValue(true);
        _isError.setValue(false);
        new Thread(()->{
            try {
                AddressData data = api.getInfo(cep);
                AddressModel address = AddressMapper.toModel(data);
                addAddress(address);
                _isLoading.setValue(false);
            } catch (Exception e) {
                _isLoading.setValue(false);
                _isError.setValue(true);
            }
        }).start();
    }

    public AddressViewModel() {
        Cache.GelAll().forEach(address -> addAddress( AddressMapper.toModel(address) ));
    }
}
