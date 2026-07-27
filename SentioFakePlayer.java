package com.sentio.fakeplayer;

import org.bukkit.plugin.java.JavaPlugin;

public class SentioFakePlayer extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SentioFakePlayer đã bật!");

        getCommand("fakeplayer")
                .setExecutor(new FakePlayerCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("SentioFakePlayer đã tắt!");
    }
}
