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
    public static String getOperativesFolderPath() { return GetAppFilesPath() + "/operatives/"; }

    //Generic Serialization Constants
    public static String getJSONSerializableUIDFiledID() { return "SerializableUID"; }

    //Operative Serialization Constants
    public static String getJSONOperativeNameFieldID() { return "OperativeName"; }
}
