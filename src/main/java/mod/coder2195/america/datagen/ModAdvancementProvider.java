package mod.coder2195.america.datagen;

import java.util.ArrayList;
import java.util.function.Consumer;

import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.Advancement.Builder;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModAdvancementProvider extends FabricAdvancementProvider {
  public ModAdvancementProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
    AdvancementEntry rootAdvancement = Advancement.Builder.create()
        .display(
            ModItems.AMERICAN_BADGE, // The display icon
            Text.literal("America"), // The title
            Text.literal("The heart and story of America."), // The description
            new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        .criterion("got_bullet", InventoryChangedCriterion.Conditions.items(ModItems.BULLET))
        .build(consumer, "america/root");

    Builder gunAdvancementBuilder = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.BULLET, // The display icon
            Text.literal("2nd Amendment Rights"), // The title
            Text.literal("Obtain a gun."), // The description
            new Identifier("textures/gui/advancements/backgrounds/adventure.png"), //
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        );

    ArrayList<String> requirements = new ArrayList<String>();

    for (Item item : ModItems.GUNS) {
      String req = "got_" + item;
      requirements.add(req);
      LOGGER.info(req);
      gunAdvancementBuilder = gunAdvancementBuilder.criterion(req,
          InventoryChangedCriterion.Conditions.items(item));

    }

    gunAdvancementBuilder = gunAdvancementBuilder
        .requirements(AdvancementRequirements.anyOf(requirements));

    AdvancementEntry gunAdvancementEntry = gunAdvancementBuilder.build(consumer, "america/got_gun");

    Builder allGunsBuilder = Advancement.Builder.create().parent(gunAdvancementEntry)
        .display(
            ModItems.AR15, // The display icon
            Text.literal("Quite the Shooting Collection"), // The title
            Text.literal("Get all the guns."), // The description
            new Identifier("textures/gui/advancements/backgrounds/adventure.png"), //
            AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        );

    for (Item item : ModItems.GUNS) {
      allGunsBuilder = allGunsBuilder.criterion("got_" + item,
          InventoryChangedCriterion.Conditions.items(item));
    }

    allGunsBuilder.build(consumer, "america/got_all_guns");

    Advancement.Builder.create().parent(gunAdvancementEntry)
        .display(
            ModItems.COMMUNIST_BADGE, // The display icon
            Text.literal("Traitor to American Freedom"), // The title
            Text.literal("Obtain an AK47."), // The description
            new Identifier("textures/gui/advancements/backgrounds/adventure.png"), //
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other
        // advancements when they want to have 'requirements'
        .criterion("got_ak47",
            InventoryChangedCriterion.Conditions.items(ModItems.AK47))
        .build(consumer, "america/got_ak47");
  }

}
