package com.sentio.fakeplayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;


public class FakePlayerPacket {


    private static final Set<String> fakeTabPlayers =
            new HashSet<>();




    public static void addFakePlayer(String name) {


        if (fakeTabPlayers.contains(name)) {
            return;
        }


        fakeTabPlayers.add(name);



        for (Player player : Bukkit.getOnlinePlayers()) {

            sendAdd(player, name);

        }


        Bukkit.getLogger().info(
                "[SentioFakePlayer] Added TAB: " + name
        );

    }





    public static void removeFakePlayer(String name) {


        fakeTabPlayers.remove(name);



        for (Player player : Bukkit.getOnlinePlayers()) {

            sendRemove(player, name);

        }


        Bukkit.getLogger().info(
                "[SentioFakePlayer] Removed TAB: " + name
        );

    }





    private static void sendAdd(
            Player receiver,
            String name
    ) {


        /*
         * Paper 1.21.1 NMS:
         *
         * ClientboundPlayerInfoUpdatePacket
         * GameProfile
         * ServerPlayer
         *
         * Cần build theo mapping
         * paperweight-userdev
         */


        receiver.sendMessage(
                "§a[FakePlayer] §f" + name
        );

    }





    private static void sendRemove(
            Player receiver,
            String name
    ) {


        /*
         * ClientboundPlayerInfoRemovePacket
         */


    }





    public static boolean exists(String name) {


        return fakeTabPlayers.contains(name);

    }





    public static Set<String> getPlayers() {


        return fakeTabPlayers;

    }





    public static void clear() {


        fakeTabPlayers.clear();

    }

}
