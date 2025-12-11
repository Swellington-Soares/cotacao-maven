package dev.swell.cotacao.api.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ApiViaCepGsonEmptyStringAdapter implements JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        if (jsonElement.isJsonNull() || jsonElement.getAsString().isBlank())
            return "Desconhecido";
        return jsonElement.getAsString();
    }
}
