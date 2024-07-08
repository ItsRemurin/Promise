package com.itsremurin.promise.mixin;

import net.minecraft.data.server.loottable.vanilla.VanillaEntityLootTableGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(WitherSkeletonEntity.class)
public abstract class WitherSkeletonEntityMixin extends AbstractSkeletonEntity {
    protected WitherSkeletonEntityMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * @author ItsRemurin
     * @reason My Reasoning: It's easier for me.
     */
    @Overwrite
    public void initEquipment(Random random, LocalDifficulty localDifficulty) {
        this.equipAtChance(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE), random);
        this.equipAtChance(EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS), random);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(random.nextFloat() > 0.25f ? Items.STONE_SWORD : Items.BOW));
    }

    @Unique
    private void equipAtChance(EquipmentSlot slot, ItemStack stack, Random random) {
        if (random.nextFloat() < 0.1f) {
            this.equipStack(slot, stack);
        }
    }
}
