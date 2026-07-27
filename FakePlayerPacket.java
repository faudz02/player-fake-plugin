package com.sentio.fakeplayer;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.EnumWrappers;

import com.mojang.authlib.GameProfile;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class FakePlayerPacket {


    private static final ProtocolManager manager =
            ProtocolLibrary.getProtocolManager();



    // Thêm Fake Player vào TAB
    public static void addFakePlayer(String name) {


        UUID uuid = UUID.randomUUID();


        GameProfile profile =
                new GameProfile(uuid, name);



        PacketContainer packet =
                manager.createPacket(
                        PacketType.Play.Server.PLAYER_INFO
                );



        List<PlayerInfoData> data =
                new ArrayList<>();


        PlayerInfoData info =
                new PlayerInfoData(
                        profile,
                        50,
                        EnumWrappers.NativeGameMode.SURVIVAL,
                        null
                );


        data.add(info);



        packet.getPlayerInfoAction()
                .write(0,
                EnumWrappers.PlayerInfoAction.ADD_PLAYER);



        packet.getPlayerInfoDataLists()
                .write(0, data);



        send(packet);


    }




    // Xóa Fake Player khỏi TAB
    public static void removeFakePlayer(String name) {


        PacketContainer packet =
                manager.createPacket(
                        PacketType.Play.Server.PLAYER_INFO
                );


        GameProfile profile =
                new GameProfile(
                        UUID.randomUUID(),
                        name
                );



        List<PlayerInfoData> data =
                new ArrayList<>();


        data.add(
                new PlayerInfoData(
                        profile,
                        0,
                        EnumWrappers.NativeGameMode.SURVIVAL,
                        null
                )
        );



        packet.getPlayerInfoAction()
                .write(
                    0,
                    EnumWrappers.PlayerInfoAction.REMOVE_PLAYER
                );



        packet.getPlayerInfoDataLists()
                .write(0, data);



        send(packet);

    }




    // Gửi packet cho toàn bộ người chơi
    private static void send(PacketContainer packet) {


        for (Player player :
                Bukkit.getOnlinePlayers()) {


            try {

                manager.sendServerPacket(
                        player,
                        packet
                );


            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }
                  }
