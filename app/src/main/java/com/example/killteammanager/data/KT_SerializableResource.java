package com.example.killteammanager.data;

import com.example.killteammanager.utils.KTM_Constants;
import com.example.killteammanager.utils.KTM_FileHelper;
import com.example.killteammanager.utils.KTM_IDsHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public abstract class KT_SerializableResource
{
    public abstract JSONObject serialize();

    public abstract boolean deserialize(JSONObject serializedData);
}
