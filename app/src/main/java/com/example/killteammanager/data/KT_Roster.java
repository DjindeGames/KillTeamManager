package com.example.killteammanager.data;

import java.util.List;

public class KT_Roster //extends KTM_Serializable
{
    private String m_Name;
    private String m_Faction;
    private List<KT_Equipment> m_Stash;
    List<KT_Operative> m_Operatives;

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getM_Faction() {
        return m_Faction;
    }

    public void setM_Faction(String m_Faction) {
        this.m_Faction = m_Faction;
    }

    public List<KT_Equipment> getM_Stash() {
        return m_Stash;
    }

    public void setM_Stash(List<KT_Equipment> m_Stash) {
        this.m_Stash = m_Stash;
    }

    public List<KT_Operative> getM_Operatives() {
        return m_Operatives;
    }

    public void setM_Operatives(List<KT_Operative> m_Operatives) {
        this.m_Operatives = m_Operatives;
    }
}
