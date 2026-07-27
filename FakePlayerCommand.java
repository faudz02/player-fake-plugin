package com.sentio.fakeplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FakePlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        // /fakeplayer
        if (args.length == 0) {

            sender.sendMessage("§b§lSentioFakePlayer");
            sender.sendMessage("§7/fakeplayer create <name> <amount>");
            sender.sendMessage("§7/fakeplayer remove <name>");
            sender.sendMessage("§7/fakeplayer list");

            return true;
        }


        // CREATE
        if (args[0].equalsIgnoreCase("create")) {

            if (args.length < 3) {
                sender.sendMessage(
                        "§cDùng: /fakeplayer create <name> <amount>"
                );
                return true;
            }

            String name = args[1];

            int amount;

            try {
                amount = Integer.parseInt(args[2]);

            } catch (NumberFormatException e) {

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


            for (int i = 1; i <= amount; i++) {

                String fakeName = i + name;


                if (!FakePlayerManager.exists(fakeName)) {

                    FakePlayerManager.add(fakeName);

                    created++;
                }
            }


            sender.sendMessage(
                    "§a✔ Đã tạo §f" +
                    created +
                    " §aFake Player!"
            );


            return true;
        }



        // REMOVE
        if (args[0].equalsIgnoreCase("remove")) {


            if (args.length < 2) {

                sender.sendMessage(
                        "§cDùng: /fakeplayer remove <name>"
                );

                return true;
            }


            String name = args[1];


            if (!FakePlayerManager.exists(name)) {

                sender.sendMessage(
                        "§cKhông tìm thấy Fake Player: §f" + name
                );

                return true;
            }


            FakePlayerManager.remove(name);


            sender.sendMessage(
                    "§c✔ Đã xoá Fake Player: §f" + name
            );


            return true;
        }




        // LIST
        if (args[0].equalsIgnoreCase("list")) {


            sender.sendMessage(
                    "§b§lDanh sách Fake Player:"
            );


            if (FakePlayerManager.getPlayers().isEmpty()) {

                sender.sendMessage(
                        "§7Không có Fake Player."
                );

                return true;
            }


            for (String player :
                    FakePlayerManager.getPlayers()) {

                sender.sendMessage(
                        "§8- §f" + player
                );
            }


            return true;
        }




        // UNKNOWN COMMAND
        sender.sendMessage(
                "§cKhông có lệnh này!"
        );


        return true;
    }
}
