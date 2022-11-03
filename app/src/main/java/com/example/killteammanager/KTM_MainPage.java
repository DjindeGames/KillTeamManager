package com.example.killteammanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.killteammanager.data.KT_Operative;
import com.example.killteammanager.utils.KTM_Constants;
import com.example.killteammanager.utils.KTM_DebugHelper;
import com.example.killteammanager.utils.KTM_FileHelper;
import com.example.killteammanager.utils.KTM_ResourceIndexer;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KTM_MainPage extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        KTM_Constants.setM_AppFilesPath(getFilesDir().getPath());
        KTM_ResourceIndexer.loadIndexer();
        setContentView(R.layout.ktm_main_page);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        KTM_ResourceIndexer.writeIndexToDisk();
        KTM_DebugHelper.writeLogToDisk();
    }

    public void onCreateOperativeClicked(View view)
    {
        Intent newIntent = new Intent(this, KTM_OperativeCreationPage.class);
        startActivity(newIntent);
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }
}