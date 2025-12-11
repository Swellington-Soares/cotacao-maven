package dev.swell.cotacao.api;

import com.google.gson.reflect.TypeToken;
import dev.swell.cotacao.AppGson;
import dev.swell.cotacao.model.AddressData;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {

    private static final Map<String, AddressData> _cache = new HashMap<>();

    public static void Load(){
        try (FileReader reader = new FileReader("cache.json")) {
            Type typeToken = new TypeToken<Map<String, AddressData>>(){}.getType();
            Map<String, AddressData> body = AppGson.getInstance().fromJson(reader, typeToken);
            _cache.putAll(body);
        } catch (Exception ignored){}
    }

    public static void Save(){
        try (FileOutputStream stream = new FileOutputStream("cache.json")){
            var body = AppGson.getInstance().toJson(_cache);
            stream.write(body.getBytes());
        } catch (Exception ignored) {}
    }

    public static void Clear(){
        _cache.clear();
    }

    public static AddressData Get(String id){
        return _cache.get(id);
    }

    public static void Remove(String id){
        _cache.remove(id);
    }

    public static List<AddressData> GelAll(){
        return _cache.values().stream().toList();
    }

    public static void Add(String cep, AddressData data) {
        _cache.put(cep, data);
    }
}
