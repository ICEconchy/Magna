package de.morigm.magna.loader;

import de.morigm.magna.commands.CMD_Fly;
import de.morigm.magna.commands.CMD_GODMODE;
import de.morigm.magna.commands.CMD_MUTED;
import de.morigm.magna.listener.Listener_GODMODE;
import de.morigm.magna.listener.Listener_Muted;

public class PluginLoader 
{

	public void registerCommands()
	{
		new CMD_Fly().register("fly");
		new CMD_GODMODE().register("godmode");
		new CMD_MUTED().register("mute");
	}
	
	public void registerListener()
	{
		new Listener_GODMODE().register();
		new Listener_Muted().register();
	}
	
}
