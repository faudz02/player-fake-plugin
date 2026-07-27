package com.sentio.fakeplayer;

import java.util.Random;

public class RandomNameGenerator {


    private static final Random random = new Random();



    private static final String[] names = {


            // ===== TÊN VIỆT =====

            "MinhKhang",
            "GiaBao",
            "BaoLong",
            "QuangHuy",
            "AnhKhoa",
            "TuanAnh",
            "DucAnh",
            "ThanhDat",
            "HoangNam",
            "HaiDang",

            "HuyHoang",
            "MinhQuan",
            "QuocKhanh",
            "DuyKhang",
            "AnhTuan",
            "KienAnh",
            "ThanhTung",
            "NhatMinh",
            "GiaHuy",
            "BaoKhanh",

            "NgocAnh",
            "PhuongAnh",
            "MaiAnh",
            "KhanhVy",
            "ThaoNhi",
            "YenNhi",
            "KimAnh",
            "MyLinh",
            "ThuTrang",
            "BaoTran",

            "TrungHieu",
            "ManhHung",
            "DinhLong",
            "HuuPhuc",
            "XuanBach",
            "VanAnh",
            "QuangMinh",
            "HaiNam",
            "PhucAn",
            "DuyAnh",


            // ===== NICK GAME VIỆT =====

            "BaoPvP",
            "KhangPvP",
            "MinhMC",
            "HuyGaming",
            "NamCraft",
            "DuyBuilder",
            "KietMC",
            "LongMiner",
            "AnhClutch",
            "BeoGaming",

            "ProBao",
            "NoobKhang",
            "DarkMinh",
            "CrazyNam",
            "LuckyHuy",
            "RealBao",
            "OnlyKhang",
            "ItsMinh",
            "BaoOP",
            "KhangOP",

            "MinhLegend",
            "HuyPro",
            "NamMaster",
            "DatPvP",
            "SonMC",
            "PhucCraft",
            "AnSurvival",
            "TungGaming",
            "BaoClutch",
            "KhangCombo",



            // ===== TÊN ANH =====

            "Shadow",
            "Hunter",
            "Phoenix",
            "Dragon",
            "Storm",
            "Frost",
            "Blaze",
            "Raven",
            "Ghost",
            "Nova",

            "Titan",
            "Legend",
            "Knight",
            "Wolf",
            "Viper",
            "Venom",
            "Reaper",
            "Omega",
            "Axel",
            "Ryan",

            "Liam",
            "Noah",
            "Ethan",
            "Leo",
            "Max",
            "Alex",
            "Jack",
            "Luke",
            "Oliver",
            "Henry",



            // ===== JAPAN / GAME STYLE =====

            "Akira",
            "Kaito",
            "Yuki",
            "Sora",
            "Haru",
            "Ryu",
            "Kenji",
            "Ren",
            "Kai",
            "Zane",



            // ===== GAMING =====

            "ShadowWolf",
            "DarkKnight",
            "FireDragon",
            "IceHunter",
            "NightRaven",
            "VoidWalker",
            "CyberGhost",
            "StarLord",
            "MoonLight",
            "SkyMaster",

            "ClutchKing",
            "ComboMaster",
            "PvPMaster",
            "BlockKing",
            "CraftLegend",
            "DiamondPro",
            "NetherKing",
            "EnderLord",
            "SpeedRun",
            "PixelMaster",



            // ===== TREND =====

            "OnlyShadow",
            "RealPlayer",
            "ItsDragon",
            "HeyGhost",
            "NotLegend",
            "IamNova",
            "TheHunter",
            "OfficialWolf",
            "DarkPlayer",
            "SilentWolf",

            "xShadow",
            "xHunter",
            "xPhoenix",
            "YTLegend",
            "TwitchKing",
            "StreamerX",
            "ProGamer",
            "ElitePlayer",
            "GamingLegend",
            "UnknownPlayer"

    };



    private static final String[] suffix = {

            "",
            "_YT",
            "_MC",
            "_PvP",
            "_Pro",
            "_X",
            "_VN",
            "_GG"

    };



    public static String generate() {


        String name =
                names[
                        random.nextInt(
                                names.length
                        )
                ];



        // thêm hậu tố
        if (random.nextBoolean()) {

            name += suffix[
                    random.nextInt(
                            suffix.length
                    )
            ];

        }



        // thêm số
        if (random.nextBoolean()) {

            name += random.nextInt(999);

        }



        // giới hạn Minecraft 16 ký tự

        if (name.length() > 16) {

            name = name.substring(
                    0,
                    16
            );

        }



        return name;

    }

      }
