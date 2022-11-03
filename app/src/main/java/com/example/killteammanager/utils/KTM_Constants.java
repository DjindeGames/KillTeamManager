package com.example.killteammanager.utils;

public class KTM_Constants {
    private static String m_AppFilesPath;

    public static void setM_AppFilesPath(String m_AppFilesPath) {
        KTM_Constants.m_AppFilesPath = m_AppFilesPath;
    }

    //Debug Constants
    public static String getKTMDebugTag() {return "[KTM_LOG]"; }

    //Files Paths Constants
    public static String GetAppFilesPath() { return m_AppFilesPath; }
    public static String getKTMFilesExtension() { return ".json"; }
    public static String getDebugLogFileName() { return "ktm_debug_log.txt"; }
    public static String getDebugLogFilePath() { return GetAppFilesPath() + "/" + getDebugLogFileName(); }
    public static String getResourceIndexerFileName() { return "ktm_resource_indexer.json"; }
    public static String getResourceIndexerFilePath() { return GetAppFilesPath() + "/" + getResourceIndexerFileName(); }
    public static String getOperativesFolderPath() { return GetAppFilesPath() + "/operatives/"; }

    //Resource Indexer Serialization Constants
    public static String getJSONIndexerResourceTypeFieldID() { return "ResourceType"; }
    public static String getJSONIndexerFiledPathFieldID() { return "ResourcePath"; }

    //Generic Serialization Constants
    public static String getJSONSerializableUIDFiledID() { return "SerializableUID"; }

    //Operative Serialization Constants
    public static String getJSONOperativeNameFieldID() { return "OperativeName"; }
}
