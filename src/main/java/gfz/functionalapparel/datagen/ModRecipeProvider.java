package gfz.functionalapparel.datagen;

import gfz.functionalapparel.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLOODSOAKED_BOW, 1)
                .pattern(" W ")
                .pattern("SNW")
                .pattern(" S ")
                .input('W', ItemTags.WOOL)
                .input('S', Items.STICK)
                .input('N', Items.NETHER_WART)
                .criterion(hasItem(Items.NETHER_WART), conditionsFromItem(Items.NETHER_WART))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSOAKED_BOW)));
    }
}
