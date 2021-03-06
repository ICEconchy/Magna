package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class GodMode extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("godmode")))
			{
				if(args.length >= 1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null)
					{
						Main.getInstance().getGodModeManager().togglePlayer(t);
						p.sendMessage(Chat.prefix + translate("cmd.godmode") + " " + (Main.getInstance().getGodModeManager().containsPlayer(t) ? translate("cmd.godmode.on") : translate("cmd.godmode.off")) + " " + translate("cmd.godmode.for") + " " + t.getName());
					}
					else
						p.sendMessage(Chat.prefix + Chat.no_online);
						
				}
				else
				{
					Main.getInstance().getGodModeManager().togglePlayer(p);
					p.sendMessage(Chat.prefix + translate("cmd.godmode") + " " + (Main.getInstance().getGodModeManager().containsPlayer(p) ? translate("cmd.godmode.on") : translate("cmd.godmode.off")));
				}
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
		{
			if(args.length >= 1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null)
				{
					Main.getInstance().getGodModeManager().togglePlayer(t);
					Chat.writeMessage(translate("cmd.godmode") + " " + (Main.getInstance().getGodModeManager().containsPlayer(t) ? translate("cmd.godmode.on") : translate("cmd.godmode.off")) + " " + translate("cmd.godmode.for") + " " + t.getName());
				}
				else
					Chat.writeMessage(Chat.no_online);
			}
			else
				Chat.writeMessage(getCommand() + " <Player>");
		}
		return false;
	}

}
