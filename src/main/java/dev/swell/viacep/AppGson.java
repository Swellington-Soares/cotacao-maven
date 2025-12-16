package dev.swell.viacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.swell.viacep.api.adapter.ApiViaCepGsonEmptyStringAdapter;

public class AppGson {

    private static final Gson _gson = new GsonBuilder()
            .registerTypeAdapter(String.class, new ApiViaCepGsonEmptyStringAdapter())
            .create();

    private AppGson() {}

    public static Gson getInstance() {
        return _gson;
    }
}
