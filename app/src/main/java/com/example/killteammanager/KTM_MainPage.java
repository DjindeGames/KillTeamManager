package com.example.killteammanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.killteammanager.data.KT_Operative;
import com.example.killteammanager.utils.KTM_Constants;
import com.example.killteammanager.utils.KTM_FileHelper;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KTM_MainPage extends AppCompatActivity {

    private List<KT_Operative> m_Operatives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KTM_Constants.setM_AppFilesPath(getFilesDir().getPath());
        m_Operatives = new ArrayList<KT_Operative>();
        setContentView(R.layout.ktm_main_page);
    }

    public void onCreateOperativeClicked(View view) {
        Intent newIntent = new Intent(this, KTM_OperativeCreationPage.class);
        startActivity(newIntent);
    }

    @Override
    public void onResume() {
        super.onResume();
        parseOperatives();
        refreshDisplay();
    }

    private void parseOperatives(){
        m_Operatives.clear();
        String folderPath = KTM_Constants.getOperativesFolderPath();
        List<JSONObject> parsedOperatives = KTM_FileHelper.readJSONFilesFromFolder(folderPath);
        for (JSONObject parsedOperative : parsedOperatives)
        {
            KT_Operative operative = new KT_Operative();
            operative.deserialize(parsedOperative);
            m_Operatives.add(operative);
        }
    }

    private void refreshDisplay(){
    }
}