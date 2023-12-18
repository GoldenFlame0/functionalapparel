package gfz.functionalapparel.item;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import gfz.functionalapparel.FunctionalApparel;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BLOODSOAKED_BOW = registerItem("bloodsoakedbow", new BloodsoakedBow(new FabricItemSettings().maxCount(1)));
    public static final Item CRACKLING_HORNS = registerItem("cracklinghorns", new CracklingHorns(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item){
        var output = Registry.register(Registries.ITEM, new Identifier(FunctionalApparel.MOD_ID, name), item);
        // TODO: Rendering world models.
        //TrinketRendererRegistry.registerRenderer(output, (TrinketRenderer) output);
        return output;
    }

    public static void registerModItems(){
        FunctionalApparel.LOGGER.info("Registering mod items for " + FunctionalApparel.MOD_ID + "...");
    }
}
