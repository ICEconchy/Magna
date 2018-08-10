package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class IP extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("ip");
		util().registerTranslation("cmd.ip");
		util().registerTranslation("cmd.ip.is");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(testPermission(com, "ip"))
		{
			if(args.length >= 1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null)
					com.sendMessage(Chat.prefix + translate("cmd.ip") + " " + t.getName() + " " + translate("cmd.ip.is") + " " + t.getAddress().getHostString());
				else
					Chat.noOnline(com);
			}
			else
				com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <Player>");
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
