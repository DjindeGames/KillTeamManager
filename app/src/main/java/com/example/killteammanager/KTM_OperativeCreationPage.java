package com.example.killteammanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.killteammanager.data.KT_EResourceFileType;
import com.example.killteammanager.data.KT_Operative;
import com.example.killteammanager.data.KT_ResourceFile;
import com.example.killteammanager.utils.KTM_Constants;
import com.example.killteammanager.utils.KTM_FileHelper;
import com.example.killteammanager.utils.KTM_IDsHelper;
import com.example.killteammanager.utils.KTM_SerializableHelper;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.util.UUID;

public class KTM_OperativeCreationPage extends AppCompatActivity
{
    private TextInputLayout m_OperativeNameField;
    private EditText m_Path;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktm_operative_creation_page);
        m_OperativeNameField = (TextInputLayout)findViewById(R.id.operativeNameInputField);
        m_Path = (EditText)findViewById(R.id.filePath);
    }

    public void onValidateOperativeCreation(View view)
    {
        UUID id = KTM_IDsHelper.generateUniqueID();
        String filePath = KTM_Constants.getOperativesFolderPath() + id.toString() + KTM_Constants.getKTMFilesExtension();
        KT_ResourceFile operativeResource = new KT_ResourceFile(id, filePath, KT_EResourceFileType.Operative);

        KT_Operative operative = operativeResource.getResourceAs();
        operative.setM_Name(m_OperativeNameField.getEditText().getText().toString());

        operativeResource.saveResource();
        finish();
    }
}