package com.sentio.fakeplayer;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Random;

public class FakePlayerReplyAI implements Listener {


    private final Random random = new Random();



    private final String[] defaultBots = {

            "1Steve",
            "2Steve",
            "Bot01",
            "MinerBot",
            "PlayerAI"

    };





    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {


        String message =
                event.getMessage()
                        .toLowerCase();



        String reply =
                getReply(message);



        if (reply == null) {
            return;
        }



        Bukkit.getScheduler()
                .runTaskLater(
                        SentioFakePlayer.getInstance(),
                        () -> {


                            String bot =
                                    getRandomBot();



                            Bukkit.broadcastMessage(

                                    "§7" + bot +
                                    " §8» §f" +
                                    reply

                            );


                        },
                        40L
                );

    }





    private String getRandomBot() {


        if (!FakePlayerManager.getPlayers().isEmpty()) {


            return FakePlayerManager
                    .getPlayers()
                    .get(
                            random.nextInt(
                                    FakePlayerManager
                                            .getPlayers()
                                            .size()
                            )
                    );

        }


        return defaultBots[
                random.nextInt(
                        defaultBots.length
                )
        ];

    }







    private String getReply(String msg) {



        // Chào hỏi
        if (contains(msg,
                "hello",
                "hi",
                "hey",
                "chào",
                "xin chao",
                "alo")) {


            return randomReply(
                    "Chào bạn!",
                    "Hello 😄",
                    "Xin chào, chúc bạn chơi vui!",
                    "Có chuyện gì không?"
            );
        }




        // Hỏi bot
        if (contains(msg,
                "bot",
                "robot",
                "ai là ai",
                "mày là ai")) {


            return randomReply(
                    "Mình là Fake Player của Sentio.",
                    "Mình là bot trong server.",
                    "Mình đang online nè."
            );
        }





        // PvP
        if (contains(msg,
                "pvp",
                "solo",
                "đấu",
                "fight",
                "1v1")) {


            return randomReply(
                    "Ai PvP thì vào đấu trường nhé!",
                    "Solo không? 😎",
                    "Chuẩn bị gear đi!"
            );
        }





        // Lag
        if (contains(msg,
                "lag",
                "delay",
                "ping",
                "crash")) {


            return randomReply(
                    "Mình thấy server vẫn ổn.",
                    "Ping của mình bình thường.",
                    "Có thể do mạng của bạn."
            );
        }





        // Server
        if (contains(msg,
                "server",
                "sv",
                "ip",
                "sentio")) {


            return randomReply(
                    "Đây là Sentio Network!",
                    "Server đang hoạt động.",
                    "Chúc bạn chơi vui vẻ."
            );
        }





        // Staff
        if (contains(msg,
                "admin",
                "owner",
                "staff",
                "helper",
                "mod")) {


            return randomReply(
                    "Bạn cần hỗ trợ hãy gọi staff.",
                    "Staff sẽ giúp bạn.",
                    "Hãy dùng /help nếu cần."
            );
        }





        // Giúp đỡ
        if (contains(msg,
                "help",
                "giúp",
                "hướng dẫn",
                "làm sao")) {


            return randomReply(
                    "Bạn có thể hỏi mình.",
                    "Mình sẽ cố giúp!",
                    "Hãy xem hướng dẫn server."
            );
        }





        // Tạm biệt
        if (contains(msg,
                "bye",
                "tạm biệt",
                "thoát",
                "quit")) {


            return randomReply(
                    "Tạm biệt!",
                    "Hẹn gặp lại.",
                    "Bye bye 😄"
            );
        }





        // GG
        if (contains(msg,
                "gg",
                "good game",
                "ez",
                "win",
                "thắng")) {


            return randomReply(
                    "GG!",
                    "Chơi hay lắm!",
                    "Trận đấu vui đấy."
            );
        }




        return null;
    }






    private boolean contains(
            String msg,
            String... words) {


        for (String word : words) {


            if (msg.contains(word)) {

                return true;

            }

        }


        return false;
    }







    private String randomReply(
            String... replies) {


        return replies[
                random.nextInt(
                        replies.length
                )
        ];
    }

}
