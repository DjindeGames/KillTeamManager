package com.example.killteammanager.data;

import java.util.List;

enum KT_EWeaponType
{
    Ranged,
    Melee;
}

public class KT_Weapon extends KT_Gear
{
    class KT_WeaponStats
    {
        class KT_WeaponStatsDamages
        {
            private short m_NormalDamages;
            private short m_CriticalDamages;

            public short getM_NormalDamages() {
                return m_NormalDamages;
            }

            public void setM_NormalDamages(short m_NormalDamages) {
                this.m_NormalDamages = m_NormalDamages;
            }

            public short getM_CriticalDamages() {
                return m_CriticalDamages;
            }

            public void setM_CriticalDamages(short m_CriticalDamages) {
                this.m_CriticalDamages = m_CriticalDamages;
            }
        }

        class KT_WeaponsStatsEffect
        {
            String m_Name;
            String m_Description;

            public String getM_Name() {
                return m_Name;
            }

            public void setM_Name(String m_Name) {
                this.m_Name = m_Name;
            }

            public String getM_Description() {
                return m_Description;
            }

            public void setM_Description(String m_Description) {
                this.m_Description = m_Description;
            }
        }

        private String m_Name;
        private KT_EWeaponType m_Type;
        private short m_Attacks;
        private KT_WeaponStatsDamages m_Damages;
        private List<KT_WeaponsStatsEffect> m_Effects;
        private List<KT_WeaponsStatsEffect> m_CriticalEffects;
        private KT_Records m_Records;

        public String getM_Name() {
            return m_Name;
        }

        public void setM_Name(String m_Name) {
            this.m_Name = m_Name;
        }

        public KT_EWeaponType getM_Type() {
            return m_Type;
        }

        public void setM_Type(KT_EWeaponType m_Type) {
            this.m_Type = m_Type;
        }

        public short getM_Attacks() {
            return m_Attacks;
        }

        public void setM_Attacks(short m_Attacks) {
            this.m_Attacks = m_Attacks;
        }

        public KT_WeaponStatsDamages getM_Damages() {
            return m_Damages;
        }

        public void setM_Damages(KT_WeaponStatsDamages m_Damages) {
            this.m_Damages = m_Damages;
        }

        public List<KT_WeaponsStatsEffect> getM_Effects() {
            return m_Effects;
        }

        public void setM_Effects(List<KT_WeaponsStatsEffect> m_Effects) {
            this.m_Effects = m_Effects;
        }

        public List<KT_WeaponsStatsEffect> getM_CriticalEffects() {
            return m_CriticalEffects;
        }

        public void setM_CriticalEffects(List<KT_WeaponsStatsEffect> m_CriticalEffects) {
            this.m_CriticalEffects = m_CriticalEffects;
        }

        public KT_Records getM_Records() {
            return m_Records;
        }

        public void setM_Records(KT_Records m_Records) {
            this.m_Records = m_Records;
        }
    }
}
