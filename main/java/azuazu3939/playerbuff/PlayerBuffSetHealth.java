package azuazu3939.playerbuff;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;

public class PlayerBuffSetHealth {

    public static boolean hasBuffHealth(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);

        if (attr == null) return false;
        for (AttributeModifier modifier : attr.getModifiers()) {

            if (modifier.getName().equals("PlayerBuff.SetHealth")) {
                return true;
            }
        } return false;
    }

    public static void removeHealthAttributes(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        for (AttributeModifier modifier : attr.getModifiers()) {
            if (modifier.getName().equals("PlayerBuff.SetHealth")) {
                attr.removeModifier(modifier);
            }
        }
    }

    public static void addHealthAttributes(LivingEntity entity, double amount) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        attr.addModifier(new AttributeModifier("PlayerBuff.SetHealth", amount, AttributeModifier.Operation.ADD_NUMBER));
    }
}
