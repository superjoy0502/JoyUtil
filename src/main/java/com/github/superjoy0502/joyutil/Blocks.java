package com.github.superjoy0502.joyutil;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Blocks {
    public static void generateBlockAtPlayerPosition(Player player){
        Location location = player.getLocation();
        location.setY(location.getY()-1);
        World world = location.getWorld();
        Block block = world.getBlockAt(location);
        if(!block.getType().equals(Material.AIR)){
            player.sendMessage("There is already a block at that position!");
        }
        else{
            block.setType(Material.GLASS);
        }
    }
}
