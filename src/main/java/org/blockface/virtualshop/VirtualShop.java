package org.blockface.virtualshop;

import net.milkbowl.vault.economy.Economy;
import org.blockface.virtualshop.commands.*;
import org.blockface.virtualshop.managers.ConfigManager;
import org.blockface.virtualshop.managers.DatabaseManager;
import org.blockface.virtualshop.util.ItemDb;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class VirtualShop extends JavaPlugin {

    Economy economy = null;
    ConfigManager configManager;

    public void onDisable() {
        DatabaseManager.Close();
    }

    public void onEnable() {
        Chatty.Initialize(this);
        configManager = new ConfigManager(this);
        DatabaseManager.Initialize(this);
        try {
            ItemDb.load(this.getDataFolder(),"items.csv");
        } catch (IOException e) {
            this.getPluginLoader().disablePlugin(this);
            return;
        }
        setupEconomy();
        //getServer().getPluginManager().registerEvents(new VaultListener(this), this);
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(label.equalsIgnoreCase("sell")) Sell.Execute(this, sender,args);
        if(label.equalsIgnoreCase("buy")) Buy.Execute(this, sender, args);
        if(label.equalsIgnoreCase("cancel")) Cancel.Execute(sender, args);
        if(label.equalsIgnoreCase("stock")) Stock.Execute(sender, args);
        if(label.equalsIgnoreCase("sales")) Sales.Execute(sender, args);
        if(label.equalsIgnoreCase("find")) Find.Execute(sender, args);
        if(label.equalsIgnoreCase("vs")) Help.Execute(sender);
        return true;
    }

    void setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
    }

    public Economy getEconomy() {
        return economy;
    }
}
