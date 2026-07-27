
package com.sentio.fakeplayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class TabManager {


    // Bật hệ thống TAB
    public static void start() {

        new BukkitRunnable() {

            @Override
            public void run() {
                updateTab();
            }

        }.runTaskTimer(
                SentioFakePlayer.getInstance(),
                0L,
                40L
        );
    }




    // Cập nhật TAB
    public static void updateTab() {


        List<String> fakePlayers =
                FakePlayerManager.getPlayers();



        for (Player player : Bukkit.getOnlinePlayers()) {


            // Hiển thị tên player thật
            player.setPlayerListName(
                    "§a" + player.getName()
            );



            // Thêm Fake Player
            for (String fake : fakePlayers) {

                addFakeToTab(fake);

            }
        }
    }





    // Thêm Fake Player vào TAB
    private static void addFakeToTab(String name) {


        for (Player player : Bukkit.getOnlinePlayers()) {


            player.sendPlayerListHeaderAndFooter(

                    "§b§lSentio Network\n" +
                    "§7Online: §f" +
                    Bukkit.getOnlinePlayers().size(),

                    "\n§7sentio.vn"

            );

        }
    }





    // Xóa TAB
    public static void clear() {


        for (Player player : Bukkit.getOnlinePlayers()) {

            player.setPlayerListName(
                    player.getName()
            );

        }
    }
}
