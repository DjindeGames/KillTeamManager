package com.example.killteammanager.data;

import com.example.killteammanager.utils.KTM_Constants;
import com.example.killteammanager.utils.KTM_FileHelper;
import com.example.killteammanager.utils.KTM_IDsHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;
import java.util.jar.JarOutputStream;

public abstract class KT_Serializable
{
    private UUID m_UniqueID;

    public UUID getM_UniqueID() {
        return m_UniqueID;
    }

    public void setM_UniqueID(UUID m_UniqueID) {
        this.m_UniqueID = m_UniqueID;
    }

    public KT_Serializable(){
        m_UniqueID = KTM_IDsHelper.generateUniqueID();
    }

    public abstract String getFilePath();

    public String getFileName() { return getM_UniqueID().toString() + KTM_Constants.getKTMFilesExtension(); }

    public JSONObject serialize()
    {
        JSONObject serialized = new JSONObject();
        try {
            serialized.put(KTM_Constants.getJSONSerializableUIDFiledID(), getM_UniqueID().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return serialized;
    }

    public abstract boolean deserialize(JSONObject serializedData);

    public void deleteSavedData()
    {
        KTM_FileHelper.tryDeleteFile(getFilePath() + getFileName());
    }
}
