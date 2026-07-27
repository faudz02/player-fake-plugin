package com.sentio.fakeplayer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class FakePlayerEntity {


    // Lưu dữ liệu Fake Player
    private static final Map<String, FakeData> fakePlayers =
            new HashMap<>();





    /**
     * Tạo Fake Player
     */
    public static boolean spawn(
            String name,
            Location location
    ) {


        if (fakePlayers.containsKey(name)) {

            return false;

        }



        FakeData data =
                new FakeData(
                        name,
                        UUID.randomUUID(),
                        location.clone()
                );



        fakePlayers.put(
                name,
                data
        );



        Bukkit.getLogger().info(
                "[SentioFakePlayer] Spawn fake player: "
                + name
        );


        return true;

    }





    /**
     * Xóa Fake Player
     */
    public static boolean remove(
            String name
    ) {


        FakeData data =
                fakePlayers.remove(name);



        if (data != null) {


            Bukkit.getLogger().info(
                    "[SentioFakePlayer] Removed: "
                    + name
            );


            return true;

        }



        return false;

    }





    /**
     * Kiểm tra tồn tại
     */
    public static boolean exists(
            String name
    ) {


        return fakePlayers
                .containsKey(name);

    }





    /**
     * Lấy vị trí
     */
    public static Location getLocation(
            String name
    ) {


        FakeData data =
                fakePlayers.get(name);



        if (data == null) {

            return null;

        }



        return data.location;

    }





    /**
     * Lấy UUID
     */
    public static UUID getUUID(
            String name
    ) {


        FakeData data =
                fakePlayers.get(name);



        if (data == null) {

            return null;

        }



        return data.uuid;

    }





    /**
     * Lấy danh sách
     */
    public static Map<String, FakeData> getFakePlayers() {


        return fakePlayers;

    }





    /**
     * Xóa tất cả
     */
    public static void clear() {


        fakePlayers.clear();


        Bukkit.getLogger().info(
                "[SentioFakePlayer] All fake players removed"
        );

    }





    /**
     * Số lượng Fake Player
     */
    public static int size() {


        return fakePlayers.size();

    }





    /**
     * Data của Fake Player
     */
    public static class FakeData {


        private final String name;

        private final UUID uuid;

        private final Location location;



        public FakeData(
                String name,
                UUID uuid,
                Location location
        ) {


            this.name = name;

            this.uuid = uuid;

            this.location = location;

        }




        public String getName() {

            return name;

        }




        public UUID getUuid() {

            return uuid;

        }




        public Location getLocation() {

            return location;

        }

    }

}
