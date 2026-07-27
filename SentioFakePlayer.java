package com.sentio.fakeplayer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class SentioFakePlayer extends JavaPlugin {


    private static SentioFakePlayer instance;



    @Override
    public void onEnable() {


        instance = this;


        getLogger().info(
                "SentioFakePlayer da bat!"
        );



        // Đăng ký command

        getCommand("fakeplayer")
                .setExecutor(
                        new FakePlayerCommand()
                );



        // Đăng ký Chat AI

        Bukkit.getPluginManager()
                .registerEvents(
                        new FakePlayerReplyAI(),
                        this
                );



        // Bật AI di chuyển

        FakePlayerAI.start();



        // Bật Chat tự động

        FakePlayerChatAI.start();



    }





    @Override
    public void onDisable() {


        getLogger().info(
                "SentioFakePlayer da tat!"
        );


        // Xóa dữ liệu khi tắt

        FakePlayerEntity.clear();


        FakePlayerAI.stop();


        FakePlayerChatAI.stop();

    }





    public static SentioFakePlayer getInstance() {

        return instance;

    }

}
