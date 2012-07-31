package org.blockface.virtualshop.managers;

import org.blockface.virtualshop.VirtualShop;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private VirtualShop plugin;

    public ConfigManager(VirtualShop plugin) {
        this.plugin = plugin;
        BroadcastOffers();
        UsingMySQL();
        MySQLUserName();
        MySQLHost();
        MySQLdatabase();
        MySQLport();
        MySQLPassword();
        getPort();
        plugin.saveConfig();
    }

    private FileConfiguration getConfig() {
        return plugin.getConfig();
    }

    public Boolean BroadcastOffers() {
        if (!getConfig().contains("broadcast-offers")) {
            getConfig().set("broadcast-offers", true);
        }
        return getConfig().getBoolean("broadcast-offers", true);
    }

    public Integer getPort() {
        if (!getConfig().contains("MySQL.port")) {
            getConfig().set("MySQL.port", 3306);
        }
        return getConfig().getInt("MySQL.port", 3306);
    }

    public Boolean UsingMySQL() {
        if (!getConfig().contains("using-MySQL")) {
            getConfig().set("using-MySQL", false);
        }
        return getConfig().getBoolean("using-MySQL", false);
    }

    public String MySQLUserName() {
        if (!getConfig().contains("MySQL.username")) {
            getConfig().set("MySQL.username", "root");
        }
        return getConfig().getString("MySQL.username", "root");
    }

    public String MySQLPassword() {
        if (!getConfig().contains("MySQL.password")) {
            getConfig().set("MySQL.password", "password");
        }
        return getConfig().getString("MySQL.password", "password");
    }

    public String MySQLHost() {
        if (!getConfig().contains("MySQL.host")) {
            getConfig().set("MySQL.host", "localhost");
        }
        return getConfig().getString("MySQL.host", "localhost");
    }

    public String MySQLdatabase() {
        if (!getConfig().contains("MySQL.database")) {
            getConfig().set("MySQL.database", "minecraft");
        }
        return getConfig().getString("MySQL.database", "minecraft");
    }

    public Integer MySQLport() {
        if (!getConfig().contains("MySQL.port")) {
            getConfig().set("MySQL.port", 3306);
        }
        return getConfig().getInt("MySQL.port", 3306);
    }

}
