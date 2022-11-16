package azuazu3939.playerbuff;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;

public class PlayerBuffSetArmorToughness {

    public static boolean hasBuffArmorToughness(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS);

        if (attr == null) return false;
        for (AttributeModifier modifier : attr.getModifiers()) {

            if (modifier.getName().equals("PlayerBuff.SetArmor_Toughness")) {
                return true;
            }
        }
        return false;
    }

    public static void removeArmorToughnessAttributes(LivingEntity entity) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS);
        if (attr == null) return;

        for (AttributeModifier modifier : attr.getModifiers()) {
            if (modifier.getName().equals("PlayerBuff.SetArmor_Toughness")) {
                attr.removeModifier(modifier);
            }
        }
    }

    public static void addArmorToughnessAttributes(LivingEntity entity, double amount) {

        AttributeInstance attr = entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS);
        if (attr == null) return;

        attr.addModifier(new AttributeModifier("PlayerBuff.SetArmor_Toughness", amount , AttributeModifier.Operation.ADD_NUMBER));
    }
}
