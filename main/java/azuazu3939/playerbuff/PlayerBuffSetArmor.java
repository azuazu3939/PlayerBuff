package azuazu3939.playerbuff;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;

public class PlayerBuffSetArmor {

    public static boolean hasBuffArmor(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_ARMOR);

        if (attr == null) return false;
        for (AttributeModifier modifier : attr.getModifiers()) {

            if (modifier.getName().equals("PlayerBuff.SetArmor")) {
                return true;
            }
        }
        return false;
    }

    public static void removeArmorAttributes(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_ARMOR);
        if (attr == null) return;

        for (AttributeModifier modifier : attr.getModifiers()) {
            if (modifier.getName().equals("PlayerBuff.SetArmor")) {
                attr.removeModifier(modifier);
            }
        }
    }

    public static void addArmorAttributes(LivingEntity entity, double amount) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_ARMOR);
        if (attr == null) return;

        attr.addModifier(new AttributeModifier("PlayerBuff.SetArmor", amount , AttributeModifier.Operation.ADD_NUMBER));
    }
}
