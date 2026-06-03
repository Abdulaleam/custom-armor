package net.rainy.armor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.rainy.armor.effect.ModEffects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomArmor implements ModInitializer {
	public static final String MOD_ID = "custom-armor";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModEffects.registerEffects();


		// TNT EXPLODING EFFECT

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

			if (world.isClient()) {
				return ActionResult.PASS;
			}
			if (!player.hasStatusEffect(ModEffects.EXPLOSION)) {
				return ActionResult.PASS;}


			if (player.isSneaking()) {
				var pos = hitResult.getBlockPos();

				world.createExplosion(
						player, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 6.0f,
					     	World.ExplosionSourceType.MOB);
				return ActionResult.SUCCESS;
			}

			// Bounce ability ganggg
			else {

				player.addVelocity(0, 1.5, 0);
				player.velocityModified = true;

				world.createExplosion(
						player, player.getX(), player.getY(), player.getZ(),
						0.5f, World.ExplosionSourceType.NONE
				);

				player.fallDistance = 0;

				return ActionResult.SUCCESS;
			}
		});
	      }}