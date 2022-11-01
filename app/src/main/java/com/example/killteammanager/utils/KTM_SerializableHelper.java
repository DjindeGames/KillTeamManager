package com.example.killteammanager.utils;

import com.example.killteammanager.data.KT_Serializable;

import org.json.JSONObject;

public class KTM_SerializableHelper {
    public static JSONObject serialize(KT_Serializable serializable) {
        JSONObject serializedData = serializable.serialize();
        return serializedData;
    }

    public static<T extends KT_Serializable> T deserialize(Class<T> tClass, JSONObject serializedData) {
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
