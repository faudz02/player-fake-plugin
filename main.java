package com.sentio.fakeplayer;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {


    private static Main instance;



    @Override
    public void onEnable() {


        instance = this;


        saveDefaultConfig();



        // Tạo thư mục + load dữ liệu
        Storage.setup();
        Storage.load();



        // Đăng ký command
        if (getCommand("fakeplayer") != null) {

            getCommand("fakeplayer")
                    .setExecutor(
                            new FakePlayerCommand()
                    );

        }



        // Bật AI nếu có
        FakePlayerAI.start();



        getLogger().info(
                "=============================="
        );

        getLogger().info(
                " SentioFakePlayer Enabled!"
        );

        getLogger().info(
                " Version: 1.0"
        );

        getLogger().info(
                "=============================="
        );

    }





    @Override
    public void onDisable() {


        // Lưu dữ liệu
        Storage.save();



        // Dừng AI
        FakePlayerAI.stop();



        // Xóa Fake Player
        FakePlayerEntity.clear();

        FakePlayerPacket.clear();



        getLogger().info(
                "SentioFakePlayer Disabled!"
        );

    }





    public static Main getInstance() {


        return instance;

    }

}
