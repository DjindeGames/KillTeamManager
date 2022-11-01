package com.example.killteammanager.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KTM_FileHelper {
    public static boolean tryWriteFile(String path, String name, String content){
        String filePath = path + name + KTM_Constants.getKTMFilesExtension();

        File directory = new File(path);
        if (! directory.exists()) {
            directory.mkdirs();
            KTM_DebugHelper.writeLog(String.format("Successfully created folder \"%s\"", path));
        }

        File file = new File(filePath);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
            KTM_DebugHelper.writeLog(String.format("Successfully created file \"%s\" with following content: \n\"%s\"", filePath, content));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean tryWriteJSONFile(String path, String name, JSONObject content){
        boolean success = false;
        try {
            success = tryWriteFile(path, name, content.toString(4));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static String readFile(String path){
        String content = new String();
        File file = new File(path);
        if (file.exists())
        {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                byte[] fileContent = new byte[(int) file.length()];
                inputStream.read(fileContent);
                content = new String(fileContent);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return content;
    }

    public static List<String> readAllFilesFromFolder(String path){
        List<String> fileContents = new ArrayList<>();
        File folder = new File(path);
        if (folder != null)
        {
            List<File> files = new ArrayList<>();
            files = Arrays.asList(folder.listFiles());
            for (File file : files)
            {
                if (file.isFile())
                {
                    fileContents.add(readFile(file.getPath()));
                }
            }
        }
        return fileContents;
    }

    public static JSONObject readJSONFile(String path){
        JSONObject content = new JSONObject();
        try {
            content = new JSONObject(readFile(path));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static List<JSONObject> readJSONFilesFromFolder(String path){
        List<JSONObject> fileContents = new ArrayList<>();
        File folder = new File(path);
        if (folder.isDirectory())
        {
            List<File> files = new ArrayList<>();
            files = Arrays.asList(folder.listFiles());
            for (File file : files)
            {
                if (file.isFile())
                {
                    fileContents.add(readJSONFile(file.getPath()));
                }
            }
        }
        return fileContents;
    }

    public static boolean tryDeleteFile(String filePath) {
        File toDelete = new File(filePath);
        return toDelete.delete();
    }
}
