package gfz.functionalapparel.item;

import gfz.functionalapparel.FunctionalApparel;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup functionalApparelItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(FunctionalApparel.MOD_ID, "functionalapparel"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.functionalapparel")).icon(() -> new ItemStack(ModItems.BLOODSOAKED_BOW)).entries((displayContext, entries) -> {
            entries.add(ModItems.BLOODSOAKED_BOW);
            entries.add(ModItems.CRACKLING_HORNS);
        }).build());

    public static void registerItemGroups(){
        FunctionalApparel.LOGGER.info("Registering mod item groups for " + FunctionalApparel.MOD_ID + "...");
    }
}
