package com.sentio.fakeplayer;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Storage {


    private static File file;

    private static YamlConfiguration config;



    /**
     * Khởi tạo file lưu
     */
    public static void setup() {


        File folder =
                SentioFakePlayer
                        .getInstance()
                        .getDataFolder();



        if (!folder.exists()) {

            folder.mkdirs();

        }



        file = new File(
                folder,
                "players.yml"
        );



        if (!file.exists()) {


            try {

                file.createNewFile();


            } catch (IOException e) {


                e.printStackTrace();

            }

        }



        config =
                YamlConfiguration
                        .loadConfiguration(file);

    }





    /**
     * Lưu Fake Player
     */
    public static void save() {


        if (config == null) {

            setup();

        }



        config.set(
                "fakeplayers",
                FakePlayerManager.getPlayers()
        );



        try {


            config.save(file);


        } catch (IOException e) {


            e.printStackTrace();

        }


    }





    /**
     * Load Fake Player khi server bật
     */
    public static void load() {


        if (config == null) {

            setup();

        }



        List<String> players =
                config.getStringList(
                        "fakeplayers"
                );



        for (String name : players) {


            if (!FakePlayerManager.exists(name)) {


                FakePlayerManager.add(name);


            }

        }


    }





    /**
     * Xóa dữ liệu lưu
     */
    public static void clear() {


        if (config == null) {

            return;

        }



        config.set(
                "fakeplayers",
                null
        );



        save();

    }





    /**
     * Reload file
     */
    public static void reload() {


        if (file == null) {

            setup();

        }



        config =
                YamlConfiguration
                        .loadConfiguration(file);

    }





    /**
     * Lấy file config
     */
    public static YamlConfiguration getConfig() {


        if (config == null) {

            setup();

        }



        return config;

    }

}
