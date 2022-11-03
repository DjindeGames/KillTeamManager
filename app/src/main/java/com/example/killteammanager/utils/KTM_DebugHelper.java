package com.example.killteammanager.utils;

import android.util.Log;

public class KTM_DebugHelper {
    private static String m_Log;

    public static void writeLog(String log)
    {
        Log.d(KTM_Constants.getKTMDebugTag(), log);
        m_Log += log + "\n";
    }

    public static void writeWarning(String warning)
    {
        Log.w("[KTM_LOG]", warning);
        m_Log += "[Warning] " + warning + "\n";
    }

    public static void writeError(String error)
    {
        Log.e("[KTM_LOG]", error);
        m_Log += "[ERROR] " + error + "\n";
    }

    public static void writeLogToDisk()
    {
        KTM_FileHelper.tryWriteFile(KTM_Constants.getDebugLogFilePath(), m_Log);
    }
}
