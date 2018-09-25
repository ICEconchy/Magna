package de.morigm.magnaworld.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

import com.sun.istack.internal.NotNull;

import de.morigm.magnaworld.api.world.WorldStruct;

public class MagnaWorld 
{
	
	private static List<WorldStruct> worlds = new ArrayList<>();
	
	public static void registerWorld(@NotNull WorldStruct world,@NotNull WorldType type,@NotNull Environment ev)
	{
		if(!containsWorld(world) && !containsWorld(world.getName()))
		{
			WorldCreator creator = new WorldCreator(world.getName());
			if(world.getSeed() != null)
				creator.seed(world.getSeed());
			creator.environment(ev);
			creator.type(type);
			World w = Bukkit.createWorld(creator);
			world.load(w);
			getWorlds().add(world);
		}
	}
	
	public static void loadWorld(@NotNull WorldStruct world)
	{
		if(!containsWorld(world) && !containsWorld(world.getName()))
		{
			WorldCreator creator = new WorldCreator(world.getName());
			World w = Bukkit.createWorld(creator);
			world.load(w);
			getWorlds().add(world);
		}
	}
	
	public static List<WorldStruct> getWorlds()
	{
		return worlds;
	}
	
	public static WorldStruct getWorld(String world)
	{
		for(WorldStruct w : worlds)
			if(w.getName().equals(world))
				return w;
		return null;
	}
	
	public static boolean containsWorld(WorldStruct world)
	{
		return worlds.contains(world);
	}
	
	public static boolean containsWorld(String world)
	{
		return getWorld(world) != null;
	}
	
}
