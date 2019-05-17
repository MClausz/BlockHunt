package nl.Steffion.BlockHunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.Steffion.BlockHunt.Serializables.LocationSerializable;

import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

@SerializableAs("BlockHuntArena")
public class Arena implements ConfigurationSerializable {
	public String arenaName;
	public LocationSerializable pos1;
	public LocationSerializable pos2;
	public int maxPlayers;
	public int minPlayers;
	public int amountSeekersOnStart;
	public int timeInLobbyUntilStart;
	public int waitingTimeSeeker;
	public int gameTime;
	public int timeUntilHidersSword;
	public int blockAnnouncerTime;
	public boolean seekersCanHurtSeekers;
	public boolean hidersCanHurtSeekers;
	public boolean hidersCanHurtHiders;
	public boolean seekersTakeFallDamage;
	public boolean hidersTakeFallDamage;
	public ArrayList<ItemStack> disguiseBlocks;
	public LocationSerializable lobbyWarp;
	public LocationSerializable hidersWarp;
	public LocationSerializable seekersWarp;
	public LocationSerializable spawnWarp;
	public List<String> seekersWinCommands;
	public List<String> hidersWinCommands;
	public List<String> allowedCommands;
	public int seekersTokenWin;
	public int hidersTokenWin;
	public int killTokens;

	public List<Player> playersInArena;
	public ArenaState gameState;
	public int timer;
	public List<Player> seekers;
	public Scoreboard scoreboard;

	public Arena(String arenaName, LocationSerializable pos1, LocationSerializable pos2, int maxPlayers, int minPlayers, int amountSeekersOnStart,
			int timeInLobbyUntilStart, int waitingTimeSeeker, int gameTime, int timeUntilHidersSword, int blockAnnouncerTime,
			boolean seekersCanHurtSeekers, boolean hidersCanHurtSeekers, boolean hidersCanHurtHiders, boolean seekersTakeFallDamage, boolean hidersTakeFallDamage,
			ArrayList<ItemStack> disguiseBlocks, LocationSerializable lobbyWarp, LocationSerializable hidersWarp, LocationSerializable seekersWarp, LocationSerializable spawnWarp,
			List<String> seekersWinCommands, List<String> hidersWinCommands, List<String> allowedCommands, int seekersTokenWin, int hidersTokenWin, int killTokens,
			List<Player> playersInArena, ArenaState gameState, int timer, List<Player> seekers, Scoreboard scoreboard) {
		this.arenaName = arenaName;
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.maxPlayers = maxPlayers;
		this.minPlayers = minPlayers;
		this.amountSeekersOnStart = amountSeekersOnStart;
		this.timeInLobbyUntilStart = timeInLobbyUntilStart;
		this.waitingTimeSeeker = waitingTimeSeeker;
		this.gameTime = gameTime;
		this.timeUntilHidersSword = timeUntilHidersSword;
		this.blockAnnouncerTime = blockAnnouncerTime;
		this.seekersCanHurtSeekers = seekersCanHurtSeekers;
		this.hidersCanHurtHiders = hidersCanHurtHiders;
		this.hidersCanHurtSeekers = hidersCanHurtSeekers;
		this.seekersTakeFallDamage = seekersTakeFallDamage;
		this.hidersTakeFallDamage = hidersTakeFallDamage;
		this.disguiseBlocks = disguiseBlocks;
		this.lobbyWarp = lobbyWarp;
		this.hidersWarp = hidersWarp;
		this.seekersWarp = seekersWarp;
		this.spawnWarp = spawnWarp;
		this.seekersWinCommands = seekersWinCommands;
		this.hidersWinCommands = hidersWinCommands;
		this.allowedCommands = allowedCommands;
		this.seekersTokenWin = seekersTokenWin;
		this.hidersTokenWin = hidersTokenWin;
		this.killTokens = killTokens;

		this.playersInArena = playersInArena;
		this.gameState = gameState;
		this.timer = timer;
		this.seekers = seekers;
		this.scoreboard = scoreboard;
	}

	public enum ArenaType {
		maxPlayers,
		minPlayers,
		amountSeekersOnStart,
		timeInLobbyUntilStart,
		waitingTimeSeeker,
		gameTime,
		timeUntilHidersSword,
		hidersTokenWin,
		seekersTokenWin,
		killTokens,
		blockAnnouncerTime
	}

	public enum ArenaState {
		WAITING,
		STARTING,
		INGAME,
		RESTARTING,
		DISABLED
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<>();
		map.put("arenaName", arenaName);
		map.put("pos1", pos1);
		map.put("pos2", pos2);
		map.put("maxPlayers", maxPlayers);
		map.put("minPlayers", minPlayers);
		map.put("amountSeekersOnStart", amountSeekersOnStart);
		map.put("timeInLobbyUntilStart", timeInLobbyUntilStart);
		map.put("waitingTimeSeeker", waitingTimeSeeker);
		map.put("blockAnnouncerTime", blockAnnouncerTime);
		map.put("gameTime", gameTime);
		map.put("timeUntilHidersSword", timeUntilHidersSword);
		map.put("disguiseBlocks", disguiseBlocks);
		map.put("lobbyWarp", lobbyWarp);
		map.put("hidersWarp", hidersWarp);
		map.put("seekersWarp", seekersWarp);
		map.put("spawnWarp", spawnWarp);
		map.put("seekersWinCommands", seekersWinCommands);
		map.put("hidersWinCommands", hidersWinCommands);
		map.put("allowedCommands", allowedCommands);
		map.put("seekersTokenWin", seekersTokenWin);
		map.put("hidersTokenWin", hidersTokenWin);
		map.put("killTokens", killTokens);
		return map;
	}

	@SuppressWarnings("unchecked")
	public static Arena deserialize(Map<String, Object> map) {
		LocationSerializable loc = new LocationSerializable(Bukkit.getWorld("world"), 0, 0, 0, 0, 0);
		return new Arena((String) map.getOrDefault("arenaName", "UNKNOWN_NAME"), (LocationSerializable) map.getOrDefault("pos1", loc), (LocationSerializable) map.getOrDefault( "pos2", loc),
				(Integer) map.getOrDefault( "maxPlayers", 12), (Integer) map.getOrDefault( "minPlayers", 3), (Integer) map.getOrDefault( "amountSeekersOnStart", 1), (Integer) map.getOrDefault( "timeInLobbyUntilStart", 90),
				(Integer) map.getOrDefault( "waitingTimeSeeker", 20), (Integer) map.getOrDefault( "gameTime", 200), (Integer) map.getOrDefault( "timeUntilHidersSword", 30),(Integer) map.getOrDefault( "blockAnnouncerTime", 45),
				(Boolean) map.getOrDefault( "seekersCanHurtSeekers", false),(Boolean) map.getOrDefault( "hidersCanHurtSeekers", false),(Boolean) map.getOrDefault( "hidersCanHurtHiders", false),(Boolean) map.getOrDefault( "seekersTakeFallDamage", false),(Boolean) map.getOrDefault( "hidersTakeFallDamage", false),
				(ArrayList<ItemStack>) map.getOrDefault( "disguiseBlocks", new ArrayList<ItemStack>()),(LocationSerializable) map.getOrDefault( "lobbyWarp", loc), (LocationSerializable) map.getOrDefault( "hidersWarp", loc), (LocationSerializable) map.getOrDefault( "seekersWarp", loc),
				(LocationSerializable) map.getOrDefault( "spawnWarp", loc), (ArrayList<String>) map.getOrDefault( "seekersWinCommands", new ArrayList<String>()),
				(ArrayList<String>) map.getOrDefault("hidersWinCommands", new ArrayList<String>()), (ArrayList<String>) map.getOrDefault( "allowedCommands", new ArrayList<String>()),
				(Integer) map.getOrDefault( "seekersTokenWin", 10), (Integer) map.getOrDefault( "hidersTokenWin", 50), (Integer) map.getOrDefault( "killTokens", 8), new ArrayList<>(),
				ArenaState.WAITING, 0, new ArrayList<>(), Bukkit.getScoreboardManager().getNewScoreboard());
	}
}