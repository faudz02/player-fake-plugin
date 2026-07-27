package com.sentio.fakeplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FakePlayerCommand implements CommandExecutor {


    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {


        if (!sender.hasPermission("sentio.fakeplayer")) {

            sender.sendMessage(
                    "§cBạn không có quyền sử dụng lệnh này!"
            );

            return true;
        }



        if (args.length == 0) {

            sendHelp(sender);
            return true;

        }





        // /fakeplayer create
        if (args[0].equalsIgnoreCase("create")) {



            // /fakeplayer create --random 100

            if (args.length >= 3 &&
                    args[1].equalsIgnoreCase("--random")) {


                if (!(sender instanceof Player)) {

                    sender.sendMessage(
                            "§cConsole không thể dùng spawn location!"
                    );

                    return true;
                }



                Player player =
                        (Player) sender;



                int amount;


                try {

                    amount =
                    Integer.parseInt(args[2]);


                } catch (Exception e) {


                    sender.sendMessage(
                            "§cSố lượng phải là số!"
                    );

                    return true;

                }




                if (amount <= 0) {

                    sender.sendMessage(
                            "§cSố lượng phải lớn hơn 0!"
                    );

                    return true;

                }





                int created = 0;



                for (int i = 0; i < amount; i++) {



                    String name;



                    do {

                        name =
                        RandomNameGenerator.generate();


                    } while (
                            FakePlayerManager.exists(name)
                    );




                    FakePlayerManager.add(name);



                    FakePlayerPacket.addFakePlayer(
                            name
                    );



                    FakePlayerEntity.spawn(
                            name,
                            player.getLocation()
                    );



                    created++;

                }




                sender.sendMessage(
                        "§aĐã tạo §e"
                        + created
                        + " §aFake Player!"
                );


                return true;

            }





            // /fakeplayer create Steve

            if (args.length >= 2) {


                String name =
                        args[1];



                if (FakePlayerManager.exists(name)) {

                    sender.sendMessage(
                            "§cTên này đã tồn tại!"
                    );

                    return true;

                }




                FakePlayerManager.add(name);



                FakePlayerPacket.addFakePlayer(
                        name
                );



                if (sender instanceof Player) {


                    Player p =
                            (Player) sender;



                    FakePlayerEntity.spawn(
                            name,
                            p.getLocation()
                    );

                }



                sender.sendMessage(
                        "§aĐã tạo Fake Player: §e"
                        + name
                );


                return true;

            }

        }






        // /fakeplayer remove <name>

        if (args[0].equalsIgnoreCase("remove")) {


            if (args.length < 2) {

                sender.sendMessage(
                        "§c/fakeplayer remove <tên>"
                );

                return true;

            }



            String name =
                    args[1];



            FakePlayerPacket.removeFakePlayer(
                    name
            );


            FakePlayerEntity.remove(
                    name
            );


            FakePlayerManager.remove(
                    name
            );



            sender.sendMessage(
                    "§aĐã xóa: §e"
                    + name
            );


            return true;

        }






        // /fakeplayer list

        if (args[0].equalsIgnoreCase("list")) {


            sender.sendMessage(
                    "§6Fake Players:"
            );


            for (String name :
                    FakePlayerManager.getPlayers()) {


                sender.sendMessage(
                        "§e- "
                        + name
                );

            }


            return true;

        }





        sendHelp(sender);

        return true;

    }






    private void sendHelp(
            CommandSender sender
    ) {


        sender.sendMessage(
                "§8&m----------------"
        );

        sender.sendMessage(
                "§6SentioFakePlayer"
        );

        sender.sendMessage(
                "§e/fakeplayer create <name>"
        );

        sender.sendMessage(
                "§e/fakeplayer create --random <số lượng>"
        );

        sender.sendMessage(
                "§e/fakeplayer remove <name>"
        );

        sender.sendMessage(
                "§e/fakeplayer list"
        );

        sender.sendMessage(
                "§8&m----------------"
        );

    }

}
