package dev.swell.viacep.api;

import dev.swell.viacep.AppGson;
import dev.swell.viacep.model.AddressData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ViaCepAPI {

    private final HttpClient _client = HttpClient.newHttpClient();

    private HttpRequest request(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET().build();
    }

    /**
     * Consulta informação via do endereço passando o CEP
     *
     * <pre>{@code
     *      AddressData data = new ViaCepApi.getInfo("1111111")
     * }</pre>
     *
     * @param cep Apenas os números do Cep
     * @return a {@code AddressData}
     */
    public AddressData getInfo(String cep) throws IOException, InterruptedException {

        if (Cache.Get(cep) != null) {
            return Cache.Get(cep);
        }

        HttpRequest viaCepRequest = request("https://viacep.com.br/ws/"+cep+"/json/");
        HttpResponse<String> response = _client.send(viaCepRequest, HttpResponse.BodyHandlers.ofString());

        AddressData data = AppGson.getInstance().fromJson(response.body(), AddressData.class);

        if (response.statusCode() == 200) {
            Cache.Add(cep, data);
        }

        return data;
    }

}
