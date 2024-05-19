package org.regicide.regicideagriculture.listeners;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideagriculture.GrowthManager;
import java.util.Random;

import static java.lang.Integer.parseInt;


/**
 * Listen cultures when they grow.
 */
public final class GrowthListener implements Listener {
    Random random = new Random();

    public void onPlantGrow(@NotNull final BlockGrowEvent event) {
        //e.getNewState().getType();

        Biome plantBiome = event.getNewState().getBlock().getBiome();
        String biomeType = GrowthManager.getType(plantBiome);
        Block block = event.getBlock();
        Ageable ageable = (Ageable) block.getBlockData();

        Material plant = event.getBlock().getType();
        if (GrowthManager.isPlant(plant)){
            Double growthDurationMultiplier = 2 - GrowthManager.getBiomeSpeed(plantBiome);
            //int currentGrowthStage = ageable.getAge();
            int newGrowthDuration = parseInt(String.valueOf(Math.round(ageable.getMaximumAge() * growthDurationMultiplier)));
            ageable.setAge(newGrowthDuration);
            block.setBlockData(ageable);

            int randomNumber = random.nextInt(100);
            //int growthTime = GrowthManager.getTimeGrowth(plant);
            int deathChance = GrowthManager.getDeathChance(plant);

            if (deathChance <= randomNumber)
                block.setType(Material.AIR);
        }

    }
}
