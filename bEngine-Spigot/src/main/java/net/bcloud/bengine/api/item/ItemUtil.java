package net.bcloud.bengine.api.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.bcloud.bengine.api.color.Colorizer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class ItemUtil {

    public static ItemStack createItem(Material material) {
        return createItem(material, null, null);
    }

    public static ItemStack createItem(Material material, String name) {
        return createItem(material, name, null);
    }

    public static ItemStack createItem(Material material, List<String> lore) {
        return createItem(material, null, lore);
    }

    public static ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        if (name != null) meta.setDisplayName(Colorizer.apply(name));

        if (lore != null) {
            List<String> colorizedLore = new ArrayList<>();
            for (String lore0 : lore) {
                colorizedLore.add(Colorizer.apply(lore0));
            }
            meta.setLore(colorizedLore);
        }

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack createHead(String value) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField;
        try {
            assert meta != null;
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        head.setItemMeta(meta);
        return head;
    }

    public static ItemStack createHead(String value, String name) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        head.setItemMeta(meta);
        return head;
    }

    public static ItemStack createHead(String value, String name, List<String> lore) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Colorizer.apply(name));
        meta.setLore(Colorizer.apply(lore));
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        head.setItemMeta(meta);
        return head;
    }
}
