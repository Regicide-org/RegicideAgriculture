package org.regicide.regicideagriculture;

import org.bukkit.block.Biome;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class GrowthManager {
    static private final HashMap<String, List<Biome>> TYPES_OF_BIOME_MAP = new HashMap<>();
    static private final HashMap<Biome, String> BIOME_BY_TYPE_MAP = new HashMap<>();

    static void readBiomeTypes() {
        ConfigurationSection biomeSection = RegicideAgriculture.instance().getConfig().getConfigurationSection("biome-types");
        Set<String> biomeTypes = biomeSection.getKeys(false);
        for (String biomeType : biomeTypes)
        {
            List<String> bList = biomeSection.getStringList(biomeType + ".biomes");

            List<Biome> biomes = new ArrayList<>();

            for (String b : bList) {
                biomes.add(Biome.valueOf(b));
            }

            TYPES_OF_BIOME_MAP.put(biomeType, biomes);
        }
    }

    /**
     * @param fertileType The name of biome fertility type.
     * @return List of the biomes by fertile type name.
     */
    public static List<Biome> getBiomes(@NotNull final String fertileType) {
        return TYPES_OF_BIOME_MAP.get(fertileType);
    }

    /**
     * @param biome The biome.
     * @return Fertility type of the biome
     */
    /*public static String getType(@NotNull final Biome biome) {

    }*/


}
