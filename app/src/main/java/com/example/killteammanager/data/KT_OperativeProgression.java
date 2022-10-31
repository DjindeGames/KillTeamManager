package com.example.killteammanager.data;

import java.util.List;

enum KT_EOperativeRank
{
    Adept,
    Veteran,
    Ace,
    Grizzled,
    Revered;
}

enum KT_EOperativeSpecialization
{
    Combat,
    Staunch,
    Marksman,
    Scout;
}

enum KT_EOperativeBattleScar
{
    Slain,
    CriticalImpairment,
    SevereConcussion,
    SappedStrength,
    LingeringAilment,
    CerebralAffliction;
}

public class KT_OperativeProgression extends KTM_Serializable
{
    private int m_ExperiencePoints;
    private KT_EOperativeSpecialization m_Specialization;
    private KT_EOperativeRank m_Rank;
    private List<KT_EOperativeBattleScar> m_BattleScars;
    private List<String> m_BattleHonours;
    private int m_RestedTally;
    private boolean m_IsDead;

    public int getM_ExperiencePoints() {
        return m_ExperiencePoints;
    }

    public void setM_ExperiencePoints(int m_ExperiencePoints) {
        this.m_ExperiencePoints = m_ExperiencePoints;
    }

    public KT_EOperativeSpecialization getM_Specialization() {
        return m_Specialization;
    }

    public void setM_Specialization(KT_EOperativeSpecialization m_Specialization) {
        this.m_Specialization = m_Specialization;
    }

    public KT_EOperativeRank getM_Rank() {
        return m_Rank;
    }

    public void setM_Rank(KT_EOperativeRank m_Rank) {
        this.m_Rank = m_Rank;
    }

    public List<KT_EOperativeBattleScar> getM_BattleScars() {
        return m_BattleScars;
    }

    public void setM_BattleScars(List<KT_EOperativeBattleScar> m_BattleScars) {
        this.m_BattleScars = m_BattleScars;
    }

    public List<String> getM_BattleHonours() {
        return m_BattleHonours;
    }

    public void setM_BattleHonours(List<String> m_BattleHonours) {
        this.m_BattleHonours = m_BattleHonours;
    }

    public int getM_RestedTally() {
        return m_RestedTally;
    }

    public void setM_RestedTally(int m_RestedTally) {
        this.m_RestedTally = m_RestedTally;
    }

    public boolean getM_IsDead() {
        return m_IsDead;
    }

    public void setM_IsDead(boolean m_IsDead) {
        this.m_IsDead = m_IsDead;
    }
}
