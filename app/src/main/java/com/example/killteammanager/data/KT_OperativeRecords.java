package com.example.killteammanager.data;

public class KT_OperativeRecords extends KT_Records
{
    private int m_NeutralizedCount;
    private int m_WoundsReceived;

    public int getM_NeutralizedCount() {
        return m_NeutralizedCount;
    }

    public void setM_NeutralizedCount(int m_NeutralizedCount) {
        this.m_NeutralizedCount = m_NeutralizedCount;
    }

    public int getM_WoundsReceived() {
        return m_WoundsReceived;
    }

    public void setM_WoundsReceived(int m_WoundsReceived) {
        this.m_WoundsReceived = m_WoundsReceived;
    }
}
