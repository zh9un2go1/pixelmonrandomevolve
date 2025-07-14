package com.example.randomevo;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingUpdateEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod("randomevo")
public class RandomEvolutionMod {
    public RandomEvolutionMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}