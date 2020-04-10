package com.github.superjoy0502.joyutil;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.internal.annotation.Selection;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.World;
import com.github.superjoy0502.joyutil.WorldEditSupport;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    WorldEdit worldEdit;
    @Override
    public void onLoad() {
        super.onLoad();
        getLogger().info("JoyUtil: onLoad()");
        worldEdit = WorldEdit.getInstance();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("JoyUtil: onDisable()");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info("JoyUtil: onEnable()");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("set")){
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
            } else {
                Player player = (Player) sender;
                Blocks.generateBlockAtPlayerPosition(player);
            }
        }

        if (command.getName().equalsIgnoreCase("getArea")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                World world = player.getWorld();
                sender.sendMessage(String.valueOf(WorldEditSupport.getPlayerSelection(player).getArea()));
            }
            else{
                sender.sendMessage("This command can only be run by a player.");
            }
        }
        return super.onCommand(sender, command, label, args);
    }
}
