
package com.sentio.fakeplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FakePlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (args.length == 0) {
            sender.sendMessage("§bSentioFakePlayer");
            sender.sendMessage("§7/fakeplayer create <name>");
            sender.sendMessage("§7/fakeplayer remove <name>");
            sender.sendMessage("§7/fakeplayer list");
            return true;
        }

        if (args[0].equalsIgnoreCase("create")) {
            if (args.length < 2) {
                sender.sendMessage("§cNhập tên fake player!");
                return true;
            }

            String name = args[1];
            sender.sendMessage("§aĐã tạo fake player: §f" + name);

            // Sau này thêm code tạo NPC/TAB ở đây
            return true;
        }

        if (args[0].equalsIgnoreCase("remove")) {
            sender.sendMessage("§cĐã xoá fake player!");
            return true;
        }

        if (args[0].equalsIgnoreCase("list")) {
            sender.sendMessage("§eDanh sách Fake Player:");
            sender.sendMessage("§7Chưa có dữ liệu");
            return true;
        }

        return true;
    }
}
