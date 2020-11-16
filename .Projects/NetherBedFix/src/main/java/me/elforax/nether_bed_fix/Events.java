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

/**
 * Events Class\n
 * Runs when a event is called from its list
 */
public class Events implements Listener {

    /**
     * Event called when a player interacts with something.\n
     * Will then check if it was the ground if the player holds a bed.\n
     * If true then cancel the event to stop the placing of the bed in the given world.
     * @param e event object
     */
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

    /**
     * check if the player holds a bed in one if there hands
     * @param player player who needs to be checked
     * @return returns true if a bed is found
     */
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
