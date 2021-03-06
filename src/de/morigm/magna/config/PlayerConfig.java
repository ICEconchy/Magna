package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.chat.Chat;

public class PlayerConfig implements ConfigHelper
{
	
	private FileConfiguration configuration;
	public List<String> muted;
	public List<String> godmode;
	public List<String> cmdspy;

	public void loadFile()
	{
		FileConfiguration conf = YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder(),"/players.yml"));
		this.configuration = conf;
	}
	
	public void load()
	{
		this.loadFile();
		this.muted = this.configuration.getStringList("muted");
		this.godmode = this.configuration.getStringList("godmode");
		this.cmdspy = this.configuration.getStringList("cmdspy");
	}
	
	public void save()
	{
		this.configuration.set("muted", this.muted);
		this.configuration.set("godmode", this.godmode);
		this.configuration.set("cmdspy", this.cmdspy);
		try 
		{
			this.configuration.save(new File("./plugins/" + Chat.name + "/players.yml"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
