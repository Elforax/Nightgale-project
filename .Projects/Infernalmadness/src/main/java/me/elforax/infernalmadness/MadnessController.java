package me.elforax.infernalmadness;

import me.elforax.infernalmadness.files.FileManager;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.*;

public class MadnessController implements Listener {
    private FileManager configFile;
    private Plugin plugin;
    private Server server;
    private Scoreboard board;

    public MadnessController(Plugin main) {
        this.plugin = main;
        this.configFile = new FileManager(this.plugin, "config.yml");
        this.server = this.plugin.getServer();
    }

    public void scoreboardTest(){
        ScoreboardManager manager = server.getScoreboardManager();
        this.board = manager.getNewScoreboard();

        Objective objective = this.board.registerNewObjective("test", "dummy", "test");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Test Scoreboard");

        Score score = objective.getScore("TestPlayer");
        score.setScore(1);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setScoreboard(this.board);
    }
}
