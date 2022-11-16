package azuazu3939.playerbuff;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;

public class PlayerBuffSetSpeed {

    public static boolean hasBuffSpeed(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);

        if (attr == null) return false;
        for (AttributeModifier modifier : attr.getModifiers()) {

            if (modifier.getName().equals("PlayerBuff.SetSpeed")) {
                return true;
            }
        }
        return false;
    }

    public static void removeSpeedAttributes(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        if (attr == null) return;

        for (AttributeModifier modifier : attr.getModifiers()) {
            if (modifier.getName().equals("PlayerBuff.SetSpeed")) {
                attr.removeModifier(modifier);
            }
        }
    }

    public static void addSpeedAttributes(LivingEntity entity, double amount) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        if (attr == null) return;

        attr.addModifier(new AttributeModifier("PlayerBuff.SetSpeed", amount , AttributeModifier.Operation.ADD_NUMBER));
    }
}
