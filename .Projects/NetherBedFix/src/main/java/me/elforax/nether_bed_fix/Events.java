package me.elforax.nether_bed_fix;

import me.elforax.nether_bed_fix.files.ConfigController;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onBedPlace(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();;

        if(isBed(player)) {
            if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
                World world = player.getWorld();
                String worldName = world.getName();

                if(ConfigController.worlds.contains(worldName) && ConfigController.prevent_place){
                    e.setCancelled(true);
                }
            }
        }
    }

    private boolean isBed(Player player){
        Material mainHand = player.getInventory().getItemInMainHand().getType();
        Material offHand = player.getInventory().getItemInOffHand().getType();

        for(String material : ConfigController.bedTypes){
            if(mainHand == Material.matchMaterial(material) || offHand == Material.matchMaterial(material)){
                return true;
            }
        }
        return false;
    }
}
