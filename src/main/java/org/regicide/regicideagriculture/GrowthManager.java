package org.regicide.regicideagriculture;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrowthManager
{
    static private HashMap<String, List<String>> BIOMES_MAP = new HashMap<>();

    static void readBiomes()
    {
        ConfigurationSection biomeSection = RegicideAgriculture.instance().getConfig().getConfigurationSection("Biomes");
        Set<String> biomeTypes = biomeSection.getKeys(false);
        for (String biomeType : biomeTypes)
        {
            BIOMES_MAP.put(biomeType, biomeSection.getStringList(".biomes"));
        }
        for(Map.Entry<String, List<String>> item : BIOMES_MAP.entrySet())
        {
            RegicideAgriculture.instance().getLogger().info(item.getValue().toString());
        }
        RegicideAgriculture.instance().getLogger().info(BIOMES_MAP.values().toString());

    }

    public HashMap<String, List<String>> getBiomesMap() {return BIOMES_MAP; }

}
