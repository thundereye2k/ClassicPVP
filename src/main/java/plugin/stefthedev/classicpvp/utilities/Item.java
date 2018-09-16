package plugin.stefthedev.classicpvp.utilities;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

public class Item {

    private String key, name;
    private Material material;
    private int subID, amount, slot;
    private List<String> lore, enchantments;

    public Item(String key, String name, Material material, int subID, int amount, int slot, List<String> enchantments, List<String> lore) {
        this.key = key;
        this.name = name;
        this.material = material;
        this.subID = subID;
        this.amount = amount;
        this.slot = slot;
        this.enchantments = enchantments;
        this.lore = lore;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(material, amount, (short)subID);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(lore.stream().map(Chat::color).collect(Collectors.toList()));
        itemMeta.setDisplayName(Chat.color(name));
        itemMeta.spigot().setUnbreakable(true);
        if(enchantments != null) {
            for (String enchantment : enchantments) {
                String[] array = enchantment.split(":");
                String enchant = array[0].toUpperCase();
                int level = Integer.valueOf(array[1]);
                Enchantment realEnchantment = Enchantment.getByName(enchant);
                if(realEnchantment != null) {
                    itemMeta.addEnchant(realEnchantment, level, true);
                }
            }
        }
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public String getKey() {
        return key;
    }

    public int getSlot() {
        return slot;
    }
}
