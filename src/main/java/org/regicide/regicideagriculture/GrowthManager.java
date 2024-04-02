package org.regicide.regicideagriculture;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public final class GrowthManager {
    static private final HashMap<String, List<Biome>> TYPES_OF_BIOME_MAP = new HashMap<>();
    static private final HashMap<Biome, String> BIOME_BY_TYPE_MAP = new HashMap<>();
    static private final HashSet<Material> PLANTS = new HashSet<>();
    static private final HashMap<Material, Integer> TIME_GROWTH = new HashMap<>();

    static void readBiomeTypes() {
        ConfigurationSection biomeSection = RegicideAgriculture.instance().getConfig().getConfigurationSection("biome-types");
        Set<String> biomeTypes = biomeSection.getKeys(false);
        for (String biomeType : biomeTypes)
        {
            List<String> bList = biomeSection.getStringList(biomeType + ".biomes");

            List<Biome> biomes = new ArrayList<>();

            for (String b : bList) {
                biomes.add(Biome.valueOf(b));
                BIOME_BY_TYPE_MAP.put(Biome.valueOf(b), biomeType);
            }
            TYPES_OF_BIOME_MAP.put(biomeType, biomes);
        }


    }

    static void readMaterialTypes(){
        ConfigurationSection plantsSection = RegicideAgriculture.instance().getConfig().getConfigurationSection("plant-types");
        Set<String> plantTypes = plantsSection.getKeys(false);
        for (String plantType : plantTypes){
            List<String> pList = plantsSection.getStringList(plantType + ".plants");
            List<String> gList = plantsSection.getStringList(plantType + ".growth");
            Integer ind = 0;
            for (String p : pList) {
                PLANTS.add(Material.valueOf(plantType));
                TIME_GROWTH.put(Material.valueOf(plantType), Integer.parseInt(gList.get(ind)));
            }
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
    public static String getType(@NotNull final Biome biome) {
        return BIOME_BY_TYPE_MAP.get(biome);
    }

    /**
     * @param plant The Material.
     * @return this material is plant
     */
    public static boolean isPlant(@NotNull final Material plant) {
        return PLANTS.contains(plant);
    }

    /**
     * @param plant The biome.
     * @return Time growth of the plant
     */
    public static Integer getTimeGrowth(@NotNull final Material plant){
        return TIME_GROWTH.get(plant);
    }
}