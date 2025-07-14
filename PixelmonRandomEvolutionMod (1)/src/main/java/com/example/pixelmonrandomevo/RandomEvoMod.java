package com.example.pixelmonrandomevo;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.pixelmonmod.pixelmon.api.events.EvolveEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;

import java.util.List;
import java.util.Random;

@Mod("pixelmonrandomevo")
public class RandomEvoMod {

    public RandomEvoMod() {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEvolve(EvolveEvent.Pre event) {
        PixelmonEntity pixelmon = event.getPixelmon();
        if (pixelmon == null || pixelmon.getPokemon() == null) return;

        List<Species> allSpecies = Species.getAll();
        Species randomSpecies = allSpecies.get(new Random().nextInt(allSpecies.size()));
        Pokemon newPokemon = randomSpecies.create();
        newPokemon.setLevel(pixelmon.getPokemon().getLevel());
        pixelmon.setPokemon(newPokemon);
        event.setCanceled(true);
    }
}
