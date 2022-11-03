package com.example.killteammanager.data;

import com.example.killteammanager.utils.KTM_Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

public class KT_Operative extends KT_SerializableResource
{
    class KT_OperativeStats
    {
        private short m_Movement;
        private short m_ActionPointsLimit;
        private short m_GroupActivation;
        private short m_Defence;
        private short m_Save;
        private short m_Wounds;

        public short getM_Movement() {
            return m_Movement;
        }

        public void setM_Movement(short m_Movement) {
            this.m_Movement = m_Movement;
        }

        public short getM_ActionPointsLimit() {
            return m_ActionPointsLimit;
        }

        public void setM_ActionPointsLimit(short m_ActionPointsLimit) {
            this.m_ActionPointsLimit = m_ActionPointsLimit;
        }

        public short getM_GroupActivation() {
            return m_GroupActivation;
        }

        public void setM_GroupActivation(short m_GroupActivation) {
            this.m_GroupActivation = m_GroupActivation;
        }

        public short getM_Defence() {
            return m_Defence;
        }

        public void setM_Defence(short m_Defence) {
            this.m_Defence = m_Defence;
        }

        public short getM_Save() {
            return m_Save;
        }

        public void setM_Save(short m_Save) {
            this.m_Save = m_Save;
        }

        public short getM_Wounds() {
            return m_Wounds;
        }

        public void setM_Wounds(short m_Wounds) {
            this.m_Wounds = m_Wounds;
        }
    }

    private String m_Name;
    private String m_Profile;
    private KT_OperativeStats m_Stats;
    private List<KT_Weapon> m_Weapons;
    private KT_OperativeProgression m_Progression;
    private KT_OperativeRecords m_Records;

    @Override
    public JSONObject serialize() {
        JSONObject serialized = new JSONObject();
        try {
            serialized.put(KTM_Constants.getJSONOperativeNameFieldID(), getM_Name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return serialized;
    }

    @Override
    public boolean deserialize(JSONObject serializedData){
        try {
            setM_Name(serializedData.getString(KTM_Constants.getJSONOperativeNameFieldID()));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getM_Profile() {
        return m_Profile;
    }

    public void setM_Profile(String m_Profile) {
        this.m_Profile = m_Profile;
    }

    public KT_OperativeStats getM_Stats() {
        return m_Stats;
    }

    public void setM_Stats(KT_OperativeStats m_Stats) {
        this.m_Stats = m_Stats;
    }

    public List<KT_Weapon> getM_Weapons() {
        return m_Weapons;
    }

    public void setM_Weapons(List<KT_Weapon> m_Weapons) {
        this.m_Weapons = m_Weapons;
    }

    public KT_OperativeProgression getM_Progression() {
        return m_Progression;
    }

    public void setM_Progression(KT_OperativeProgression m_Progression) {
        this.m_Progression = m_Progression;
    }

    public KT_OperativeRecords getM_Records() {
        return m_Records;
    }

    public void setM_Records(KT_OperativeRecords m_Records) {
        this.m_Records = m_Records;
    }
}
