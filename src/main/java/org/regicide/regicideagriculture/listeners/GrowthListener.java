package org.regicide.regicideagriculture.listeners;

import org.bukkit.block.Biome;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.jetbrains.annotations.NotNull;


/**
 * Listen cultures when they grow.
 */
public final class GrowthListener implements Listener {
    public void onPlantGrow(@NotNull final BlockGrowEvent e) {
        // TODO добавить разное поведеление для разных типов растений для типов бимоов
        //e.getNewState().getType();

        Biome plantBiome = e.getNewState().getBlock().getBiome();
        //GrowthManager.getBiomesByType()
    }
}
