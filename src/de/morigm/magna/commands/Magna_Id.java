package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Magna_Id extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("magna-id")))
		{
			if(getGroupManager().getGroups().length >= 1)
			{
				if(com instanceof Player)
				{
					Player t = (Player) com;
					if(args.length >= 1)
						t = Bukkit.getPlayer(args[0]);
					if(t != null)
					{
						Group group = getGroupManager().getGroupFromPlayer(t);
						if(group != null)
							com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.true") + " " + group.name);
						else
							com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.false"));
					}
					else
						com.sendMessage(Chat.prefix + Chat.no_online);
				}
				else
				{
					if(args.length >= 1)
					{
						Player t = Bukkit.getPlayer(args[0]);
						if(t != null)
						{
							Group group = getGroupManager().getGroupFromPlayer(t);
							if(group != null)
								com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.true") + " " + group.name);
							else
								com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.false"));
						}
						else
							com.sendMessage(Chat.prefix + Chat.no_online);
					}
					else
						Chat.writeMessage(getCommand() + " " + "<Player>");
				}
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_group);
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
