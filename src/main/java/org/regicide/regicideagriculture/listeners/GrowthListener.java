package org.regicide.regicideagriculture.listeners;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideagriculture.GrowthManager;
import org.regicide.regicideagriculture.RegicideAgriculture;
import java.util.Random;

import static org.bukkit.Bukkit.getServer;


/**
 * Listen cultures when they grow.
 */
public final class GrowthListener implements Listener {
    Random random = new Random();

    public void onPlantGrow(@NotNull final BlockGrowEvent e) {
        // TODO добавить разное поведеление для разных типов растений для типов бимоов
        //e.getNewState().getType();

        Biome plantBiome = e.getNewState().getBlock().getBiome();
        String biomeType = GrowthManager.getType(plantBiome);
        Block block = e.getBlock();

        Material plant = e.getBlock().getType();
        if (GrowthManager.isPlant(plant)){
            int randomNumber = random.nextInt(100);
            int growthTime = GrowthManager.getTimeGrowth(plant);
            int deathChance = GrowthManager.getDeathChance(plant);

            getServer().getScheduler().runTaskLater(RegicideAgriculture.instance(), () -> {}, growthTime);
            if (deathChance <= randomNumber)
                block.setType(Material.AIR);
        }

    }
}
