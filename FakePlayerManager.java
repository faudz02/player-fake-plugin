
package com.sentio.fakeplayer;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakePlayerManager {

    private static final List<String> fakePlayers = new ArrayList<>();

    private static File file;
    private static YamlConfiguration config;


    // Khởi tạo file
    public static void setup() {

        File folder = SentioFakePlayer.getInstance().getDataFolder();

        if (!folder.exists()) {
            folder.mkdirs();
        }


        file = new File(folder, "fakeplayers.yml");


        if (!file.exists()) {

            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        config = YamlConfiguration.loadConfiguration(file);

        load();
    }



    // Load dữ liệu
    public static void load() {

        fakePlayers.clear();

        List<String> list =
                config.getStringList("fakeplayers");


        fakePlayers.addAll(list);
    }




    // Lưu dữ liệu
    public static void save() {

        config.set(
                "fakeplayers",
                fakePlayers
        );


        try {

            config.save(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }




    // Thêm fake player
    public static boolean add(String name) {

        if (exists(name)) {
            return false;
        }


        fakePlayers.add(name);

        save();

        return true;
    }





    // Xoá fake player
    public static boolean remove(String name) {

        if (!exists(name)) {
            return false;
        }


        fakePlayers.remove(name);

        save();

        return true;
    }





    // Kiểm tra tồn tại
    public static boolean exists(String name) {

        return fakePlayers.contains(name);
    }





    // Lấy danh sách
    public static List<String> getPlayers() {

        return fakePlayers;
    }





    // Xoá tất cả
    public static void clear() {

        fakePlayers.clear();

        save();
    }
}
