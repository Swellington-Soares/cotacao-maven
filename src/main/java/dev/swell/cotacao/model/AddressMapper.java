package dev.swell.cotacao.model;

public class AddressMapper {

    public static AddressModel toModel(AddressData data) {
        if (data == null) return null;

        return new AddressModel(
                data.cep(),
                data.logradouro(),
                data.complemento(),
                data.unidade(),
                data.bairro(),
                data.localidade(),
                data.uf(),
                data.estado(),
                data.regiao(),
                data.ibge(),
                data.gia(),
                data.ddd(),
                data.siafi()
        );
    }

    public static AddressData toData(AddressModel model) {
        if (model == null) return null;

        return new AddressData(
                model.getCep(),
                model.getLogradouro(),
                model.getComplemento(),
                model.getUnidade(),
                model.getBairro(),
                model.getLocalidade(),
                model.getUf(),
                model.getEstado(),
                model.getRegiao(),
                model.getIbge(),
                model.getGia(),
                model.getDdd(),
                model.getSiafi()
        );
    }
}

