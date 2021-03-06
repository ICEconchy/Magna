package de.morigm.magna.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Repair extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(isPlayer(com))
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("repair")))
			{
				if(p.getInventory().getItemInMainHand() != null && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR))
				{
					ItemStack item = p.getInventory().getItemInMainHand();
					item.setDurability((short)0);
					p.sendMessage(Chat.prefix + translate("cmd.repair"));
				}
				else
					p.sendMessage(Chat.prefix + translate("cmd.repair.error"));
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
