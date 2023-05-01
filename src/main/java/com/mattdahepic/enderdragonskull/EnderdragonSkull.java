package com.mattdahepic.enderdragonskull;

import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("enderdragonskull")
public class EnderdragonSkull {
    public EnderdragonSkull() {
        MinecraftForge.EVENT_BUS.addListener(this::entityDeath);
    }

    public void entityDeath(LivingDeathEvent e) {
        if (e.getEntity() instanceof EnderDragon) {
            EnderDragon d = (EnderDragon) e.getEntity();
            d.level.addFreshEntity(new ItemEntity(d.level,d.getX(),d.getY(),d.getZ(),new ItemStack(Items.DRAGON_HEAD)));
        }
    }
}
