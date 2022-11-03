package com.example.killteammanager.utils;

import com.example.killteammanager.data.KT_EResourceFileType;
import com.example.killteammanager.data.KT_ResourceFile;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class KTM_ResourceIndexer
{
    private static HashMap<UUID, KT_ResourceFile> m_ResourceIndex = new HashMap<>();
    private static JSONObject m_ResourceIndexJSON = new JSONObject();

    public static void loadIndexer(){
        m_ResourceIndexJSON = KTM_FileHelper.readJSONFile(KTM_Constants.getResourceIndexerFilePath());
        if (m_ResourceIndexJSON != null)
        {
            for (Iterator<String> it = m_ResourceIndexJSON.keys(); it.hasNext(); ) {
                String key = it.next();
                try {
                    UUID id = UUID.fromString(key);
                    JSONObject serializedResource = m_ResourceIndexJSON.getJSONObject(key);
                    String resourcePath = serializedResource.getString(KTM_Constants.getJSONIndexerFiledPathFieldID());
                    KT_EResourceFileType fileType = KT_EResourceFileType.valueOf(serializedResource.getString(KTM_Constants.getJSONIndexerResourceTypeFieldID()));
                    KT_ResourceFile resourceFile = new KT_ResourceFile(id, resourcePath, fileType);
                    m_ResourceIndex.put(id, resourceFile);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            KTM_DebugHelper.writeWarning("KTM_ResourceIndexer: Couldn't load resource index.");
        }
    }

    public static void registerResource(KT_ResourceFile resource){
        UUID id = resource.getM_ResourceID();
        m_ResourceIndex.put(id, resource);
        try {
            JSONObject jsonResource = new JSONObject();
            jsonResource.put(KTM_Constants.getJSONIndexerResourceTypeFieldID(), resource.getM_ResourceType());
            jsonResource.put(KTM_Constants.getJSONIndexerFiledPathFieldID(), resource.getM_ResourcePath());
            m_ResourceIndexJSON.put(id.toString(), jsonResource);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void deleteResource(KT_ResourceFile resource){
        m_ResourceIndex.remove(resource.getM_ResourceID());
        m_ResourceIndexJSON.remove(resource.getM_ResourceID().toString());
    }

    public static void writeIndexToDisk()
    {
        KTM_FileHelper.tryWriteJSONFile(KTM_Constants.getResourceIndexerFilePath(), m_ResourceIndexJSON);
    }
}
