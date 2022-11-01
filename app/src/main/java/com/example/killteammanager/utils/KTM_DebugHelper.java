package com.example.killteammanager.utils;

import android.util.Log;

public class KTM_DebugHelper {
    public static void writeLog(String log) {
        Log.d(KTM_Constants.getKTMDebugTag(), log);
    }

    public static void writeWarning(String warning) {
        Log.w("[KTM_LOG]", warning);
    }

    public static void writeError(String error) {
        Log.e("[KTM_LOG]", error);
    }
}
