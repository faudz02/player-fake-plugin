package com.sentio.fakeplayer;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FakePlayerEntity {


    // Lưu vị trí của Fake Player
    private static final Map<String, Location> locations = new HashMap<>();



    // Tạo Fake Player tại vị trí
    public static boolean spawn(String name, Location location) {


        if (locations.containsKey(name)) {
            return false;
        }


        locations.put(
                name,
                location.clone()
        );


        return true;
    }




    // Xóa Fake Player
    public static boolean remove(String name) {


        if (!locations.containsKey(name)) {
            return false;
        }


        locations.remove(name);


        return true;
    }




    // Di chuyển Fake Player
    public static void teleport(
            String name,
            Location location
    ) {


        if (locations.containsKey(name)) {

            locations.put(
                    name,
                    location.clone()
            );
        }
    }




    // Lấy vị trí
    public static Location getLocation(String name) {


        Location loc =
                locations.get(name);


        if (loc == null) {
            return null;
        }


        return loc.clone();
    }





    // Kiểm tra Fake Player tồn tại
    public static boolean exists(String name) {

        return locations.containsKey(name);
    }





    // Lấy toàn bộ Fake Player
    public static Set<String> getEntities() {

        return locations.keySet();
    }





    // Xóa tất cả
    public static void clear() {

        locations.clear();
    }
}
