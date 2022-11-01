package com.example.killteammanager.data;

public class KT_Records //extends KTM_Serializable
{
    private int m_AttacksMade;
    private int m_Hits;
    private int m_CriticalHits;
    private int m_WoundsInflicted;
    private float m_Precision;
    private float m_CriticalRatio;
    private int m_Kills;

    public int getM_AttacksMade() {
        return m_AttacksMade;
    }

    public void setM_AttacksMade(int m_AttacksMade) {
        this.m_AttacksMade = m_AttacksMade;
    }

    public int getM_Hits() {
        return m_Hits;
    }

    public void setM_Hits(int m_Hits) {
        this.m_Hits = m_Hits;
    }

    public int getM_CriticalHits() {
        return m_CriticalHits;
    }

    public void setM_CriticalHits(int m_CriticalHits) {
        this.m_CriticalHits = m_CriticalHits;
    }

    public int getM_WoundsInflicted() {
        return m_WoundsInflicted;
    }

    public void setM_WoundsInflicted(int m_WoundsInflicted) {
        this.m_WoundsInflicted = m_WoundsInflicted;
    }

    public float getM_Precision() {
        return m_Precision;
    }

    public void setM_Precision(float m_Precision) {
        this.m_Precision = m_Precision;
    }

    public float getM_CriticalRatio() {
        return m_CriticalRatio;
    }

    public void setM_CriticalRatio(float m_CriticalRatio) {
        this.m_CriticalRatio = m_CriticalRatio;
    }

    public int getM_Kills() {
        return m_Kills;
    }

    public void setM_Kills(int m_Kills) {
        this.m_Kills = m_Kills;
    }
}
