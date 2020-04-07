package com.github.superjoy0502.joyutil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onLoad() {
        super.onLoad();
        getLogger().info("JoyUtil: onLoad()");
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
        return super.onCommand(sender, command, label, args);
    }
}
