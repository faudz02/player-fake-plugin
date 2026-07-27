package com.sentio.fakeplayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class FakePlayerPacket {


    private static final Map<String, FakePlayerData> fakePlayers =
            new HashMap<>();



    public static void addFakePlayer(String name) {


        if (fakePlayers.containsKey(name)) {
            return;
        }


        FakePlayerData data =
                new FakePlayerData(
                        name,
                        UUID.randomUUID(),
                        20
                );


        fakePlayers.put(
                name,
                data
        );


        updateAllTab();


        Bukkit.getLogger().info(
                "[SentioFakePlayer] Added: " + name
        );

    }





    public static void removeFakePlayer(String name) {


        fakePlayers.remove(name);


        updateAllTab();


        Bukkit.getLogger().info(
                "[SentioFakePlayer] Removed: " + name
        );

    }





    public static void updateAllTab() {


        for (Player player :
                Bukkit.getOnlinePlayers()) {


            updateTab(player);

        }

    }





    private static void updateTab(Player player) {


        StringBuilder header =
                new StringBuilder();


        header.append("§b§lSentio Network\n");
        header.append("§7Fake Players: §f")
                .append(fakePlayers.size())
                .append("\n\n");



        StringBuilder footer =
                new StringBuilder();


        footer.append("\n§aOnline: §f")
                .append(
                        Bukkit.getOnlinePlayers().size()
                );



        player.sendPlayerListHeaderAndFooter(
                header.toString(),
                footer.toString()
        );

    }





    public static boolean exists(String name) {


        return fakePlayers.containsKey(name);

    }





    public static int getCount() {


        return fakePlayers.size();

    }





    public static Map<String, FakePlayerData> getPlayers() {


        return fakePlayers;

    }





    public static void clear() {


        fakePlayers.clear();

        updateAllTab();

    }





    public static class FakePlayerData {


        private final String name;

        private final UUID uuid;

        private final int ping;



        public FakePlayerData(
                String name,
                UUID uuid,
                int ping
        ) {

            this.name = name;
            this.uuid = uuid;
            this.ping = ping;

        }



        public String getName() {

            return name;

        }



        public UUID getUuid() {

            return uuid;

        }



        public int getPing() {

            return ping;

        }

    }

}
