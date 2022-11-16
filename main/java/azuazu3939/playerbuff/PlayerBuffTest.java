package azuazu3939.playerbuff;

import io.lumine.xikage.mythicmobs.MythicMobs;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class PlayerBuffTest implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        LivingEntity entity = event.getPlayer();
        if (!(hasTempHealth(entity))) return;

        removeAttributes(entity);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        LivingEntity entity = event.getPlayer();
        World world = entity.getWorld();
        String world1 = PlayerBuff.getInstance().getConfig().getString("worldName");
        ItemStack itemStack = Objects.requireNonNull(entity.getEquipment()).getHelmet();
        ItemStack itemStack1 = entity.getEquipment().getChestplate();
        ItemStack itemStack2 = entity.getEquipment().getLeggings();
        ItemStack itemStack3 = entity.getEquipment().getBoots();
        ItemStack mythicItem = MythicMobs.inst().getItemManager().getItemStack("HW2022_FF_Head");
        ItemStack mythicItem1 = MythicMobs.inst().getItemManager().getItemStack("HW2022_FF_Chest");
        ItemStack mythicItem2 = MythicMobs.inst().getItemManager().getItemStack("HW2022_FF_Legs");
        ItemStack mythicItem3 = MythicMobs.inst().getItemManager().getItemStack("HW2022_FF_Boots");

        if (!(world.getName().equals(world1))) return;
        if (entity.getEquipment() == null) removeAttributes(entity);
        if (!(mythicItem.isSimilar(itemStack) && !(mythicItem1.isSimilar(itemStack1)) && !(mythicItem2.isSimilar(itemStack2)) && !(mythicItem3.isSimilar(itemStack3)))) removeAttributes(entity);
        if (!(hasTempHealth(entity)) && mythicItem.isSimilar(itemStack)) addAttributes(entity);
        if (!(hasTempHealth(entity)) && mythicItem1.isSimilar(itemStack1)) addAttributes(entity);
        if (!(hasTempHealth(entity)) && mythicItem2.isSimilar(itemStack2)) addAttributes(entity);
        if (!(hasTempHealth(entity)) && mythicItem3.isSimilar(itemStack3)) addAttributes(entity);
    }

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {

        LivingEntity entity = event.getPlayer();
        World world = entity.getWorld();
        String world1 = PlayerBuff.getInstance().getConfig().getString("worldName");

        if (world.getName().equals(world1)) return;
        if (hasTempHealth(entity)) removeAttributes(entity);
    }

    private boolean hasTempHealth(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);

        if (attr == null) return false;
        for (AttributeModifier modifier : attr.getModifiers()) {

            if (modifier.getName().equals("PlayerBuff.temp_health_boost_number")) {
                return true;
            }
        } return false;
    }

    private static void removeAttributes(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        for (AttributeModifier modifier : attr.getModifiers()) {
            if (modifier.getName().equals("PlayerBuff.temp_health_boost_number")) {
                attr.removeModifier(modifier);
            }
        }
    }

    private void addAttributes(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        attr.addModifier(new AttributeModifier("PlayerBuff.temp_health_boost_number", PlayerBuff.getInstance().getConfig().getDouble("health_Amount"), AttributeModifier.Operation.ADD_NUMBER));
    }
}
