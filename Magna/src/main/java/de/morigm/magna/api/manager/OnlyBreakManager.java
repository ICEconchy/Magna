package de.morigm.magna.api.manager;

import java.util.List;

import org.bukkit.entity.Player;

import de.morigm.magna.stuff.MagnaStuff;

public class OnlyBreakManager
{
	
	public void addPlayer(Player p)
	{
		if(!containsPlayer(p))
			getOnlyBreakPlayers().add(p);
	}
	
	public void removePlayer(Player p)
	{
		if(containsPlayer(p))
			getOnlyBreakPlayers().remove(p);
	}
	
	public void togglePlayer(Player p)
	{
		if(containsPlayer(p))
			removePlayer(p);
		else
			addPlayer(p);
	}
	
	public boolean containsPlayer(Player p)
	{
		return getOnlyBreakPlayers().contains(p);
	}
	
	public List<Player> getOnlyBreakPlayers()
	{
		return MagnaStuff.getOnlybreaks();
	}

}
