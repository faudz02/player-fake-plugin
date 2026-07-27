package com.sentio.fakeplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FakePlayerManager {


    private static final List<String> fakePlayers = new ArrayList<>();



    /**
     * Thêm Fake Player
     */
    public static boolean add(String name) {


        if (name == null || name.isEmpty()) {

            return false;

        }



        if (exists(name)) {

            return false;

        }



        if (isFull()) {

            return false;

        }



        fakePlayers.add(name);

        return true;

    }





    /**
     * Xóa Fake Player
     */
    public static boolean remove(String name) {


        if (name == null) {

            return false;

        }


        return fakePlayers.remove(name);

    }





    /**
     * Kiểm tra Fake Player tồn tại
     */
    public static boolean exists(String name) {


        return fakePlayers
                .contains(name);

    }





    /**
     * Lấy toàn bộ Fake Player
     */
    public static List<String> getPlayers() {


        return Collections
                .unmodifiableList(
                        fakePlayers
                );

    }





    /**
     * Số lượng Fake Player hiện tại
     */
    public static int getCount() {


        return fakePlayers.size();

    }





    /**
     * Xóa tất cả Fake Player
     */
    public static void clear() {


        fakePlayers.clear();

    }





    /**
     * Kiểm tra giới hạn
     */
    public static boolean isFull() {


        int max =
                500;



        if (SentioFakePlayer.getInstance() != null) {


            max =
            SentioFakePlayer
                    .getInstance()
                    .getConfig()
                    .getInt(
                        "settings.max-fakeplayers",
                        500
                    );

        }



        return fakePlayers.size() >= max;

    }





    /**
     * Tìm tên gần giống
     */
    public static String find(String text) {


        for (String name : fakePlayers) {


            if (name.equalsIgnoreCase(text)) {

                return name;

            }

        }


        return null;

    }





    /**
     * Đổi tên Fake Player
     */
    public static boolean rename(
            String oldName,
            String newName
    ) {


        if (!exists(oldName)) {

            return false;

        }



        if (exists(newName)) {

            return false;

        }



        int index =
                fakePlayers.indexOf(oldName);



        fakePlayers.set(
                index,
                newName
        );



        return true;

    }





    /**
     * In danh sách dạng String
     */
    public static String getList() {


        if (fakePlayers.isEmpty()) {

            return "Không có Fake Player";

        }



        return String.join(
                ", ",
                fakePlayers
        );

    }

}
