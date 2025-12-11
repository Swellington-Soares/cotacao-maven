package dev.swell.cotacao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.swell.cotacao.api.adapter.ApiViaCepGsonEmptyStringAdapter;

public class AppGson {

    private static final Gson _gson = new GsonBuilder()
            .registerTypeAdapter(String.class, new ApiViaCepGsonEmptyStringAdapter())
            .create();

    private AppGson() {}

    public static Gson getInstance() {
        return _gson;
    }
}
