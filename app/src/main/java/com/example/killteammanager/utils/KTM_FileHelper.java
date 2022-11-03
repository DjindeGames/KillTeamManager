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
    public static boolean tryWriteFile(String path, String content){
        boolean success = false;

        File file = new File(path);
        String directoryPath = file.getParent();

        File directory = new File(directoryPath);
        if (! directory.exists()) {
            directory.mkdirs();
            KTM_DebugHelper.writeLog(String.format("KTM_FileHelper: Successfully created folder \"%s\"", directoryPath));
        }

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
            KTM_DebugHelper.writeLog(String.format("KTM_FileHelper: Successfully created file \"%s\".", path));
            success = true;
        } catch (Exception e) {
            KTM_DebugHelper.writeError(String.format("KTM_FileHelper: Couldn't create file \"%s\"!", path));
            e.printStackTrace();
        }

        return success;
    }

    public static boolean tryWriteJSONFile(String path, JSONObject content)
    {
        try {
            return tryWriteFile(path, content.toString(4));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String readFile(String path){
        boolean success = false;
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
                success = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!success)
        {
            KTM_DebugHelper.writeError(String.format("KTM_FileHelper: Couldn't read file from path \"%s\"!", path));
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
        boolean success = false;
        File toDelete = new File(filePath);
        success = toDelete.delete();
        if (!success)
        {
            KTM_DebugHelper.writeWarning(String.format("KTM_FileHelper: Couldn't delete file \"%s\".", filePath));
        }
        return success;
    }
}
