package com.example.killteammanager.data;

import com.example.killteammanager.utils.KTM_DebugHelper;
import com.example.killteammanager.utils.KTM_FileHelper;
import com.example.killteammanager.utils.KTM_ResourceIndexer;

import org.json.JSONObject;

import java.util.UUID;

public class KT_ResourceFile
{
    UUID m_ResourceID;
    KT_EResourceFileType m_ResourceType;
    String m_ResourcePath;
    KT_SerializableResource m_Resource = null;

    public KT_ResourceFile(UUID resourceID, String path, KT_EResourceFileType type)
    {
        this.m_ResourceID = resourceID;
        this.m_ResourcePath = path;
        this.m_ResourceType = type;
    }

    public void saveResource()
    {
        if (m_Resource != null)
        {
            JSONObject serializedResource = m_Resource.serialize();
            KTM_FileHelper.tryWriteJSONFile(m_ResourcePath, serializedResource);
            KTM_ResourceIndexer.registerResource(this);
        }
        else
        {
            KTM_DebugHelper.writeError(String.format("KT_ResourceFile: Trying to save unloaded resource (%s)", getM_ResourcePath()));
        }
    }

    public void deleteResource()
    {
        KTM_ResourceIndexer.deleteResource(this);
    }

    public KT_SerializableResource getResource()
    {
        if (m_Resource == null)
        {
            loadResource();
        }
        return m_Resource;
    }

    public <T extends KT_SerializableResource> T getResourceAs()
    {
        KT_SerializableResource resource = getResource();
        return (T) resource;
    }

    public void unloadResource()
    {
        m_Resource = null;
    }

    private void loadResource()
    {
        JSONObject jsonResource = KTM_FileHelper.readJSONFile(m_ResourcePath);
        if (jsonResource != null)
        {
            m_Resource = getResourceFromType();
            if (m_Resource != null)
            {
                m_Resource.deserialize(jsonResource);
            }
        }
    }

    private KT_SerializableResource getResourceFromType()
    {
        KT_SerializableResource resource;
        switch (m_ResourceType)
        {
            case Operative:
                resource = new KT_Operative();
                break;
            default:
                resource = null;
        }
        return resource;
    }

    public UUID getM_ResourceID() {
        return m_ResourceID;
    }

    public void setM_ResourceID(UUID m_ResourceID) {
        this.m_ResourceID = m_ResourceID;
    }

    public KT_EResourceFileType getM_ResourceType() {
        return m_ResourceType;
    }

    public void setM_ResourceType(KT_EResourceFileType m_ResourceType) {
        this.m_ResourceType = m_ResourceType;
    }

    public String getM_ResourcePath() {
        return m_ResourcePath;
    }

    public void setM_ResourcePath(String m_ResourcePath) {
        this.m_ResourcePath = m_ResourcePath;
    }
}
