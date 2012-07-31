package org.blockface.virtualshop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

public class VaultListener implements Listener {

    VirtualShop plugin;
    VaultListener(VirtualShop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void pluginEnable(PluginEnableEvent event) {
        Plugin p = event.getPlugin();
        if (p.getName().equals("Vault")) {
            plugin.setupEconomy();
        }
    }

    @EventHandler
    public void pluginDisable(PluginDisableEvent event) {
        Plugin p = event.getPlugin();
        if (p.getName().equals("Vault")) {
            plugin.economy = null;
        }
    }
}
