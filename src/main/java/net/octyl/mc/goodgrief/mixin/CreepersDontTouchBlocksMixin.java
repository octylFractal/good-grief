package net.octyl.mc.goodgrief.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Makes creepers not break blocks.
 */
@Mixin(Creeper.class)
public class CreepersDontTouchBlocksMixin {
    @Redirect(
        method = "explodeCreeper",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFLnet/minecraft/world/level/Level$ExplosionInteraction;)Lnet/minecraft/world/level/Explosion;"
        )
    )
    private Explosion changeExplodeCreeperExplosionInteraction(
        Level instance, Entity source, double x, double y, double z, float radius,
        Level.ExplosionInteraction explosionInteraction
    ) {
        return instance.explode(source, x, y, z, radius, false, Level.ExplosionInteraction.NONE);
    }
}
