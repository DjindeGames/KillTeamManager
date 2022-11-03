package com.example.killteammanager.utils;

import com.example.killteammanager.data.KT_SerializableResource;

import org.json.JSONObject;

public class KTM_SerializableHelper {
    public static JSONObject serialize(KT_SerializableResource serializable) {
        JSONObject serializedData = serializable.serialize();
        return serializedData;
    }

    public static<T extends KT_SerializableResource> T deserialize(Class<T> tClass, JSONObject serializedData) {
        T serializable = null;
        try {
            serializable = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (serializable.deserialize(serializedData))
        {
            return serializable;
        }
        return null;
    }
}
