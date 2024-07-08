package com.itsremurin.promise.mixin.client;

import com.itsremurin.promise.PromiseMod;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.brigadier.suggestion.Suggestion;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatInputSuggestor.class)
public class ChatInputSuggestorMixin {

    @Redirect(method = "sortSuggestions", at = @At(value = "INVOKE", target = "Ljava/lang/String;startsWith(Ljava/lang/String;)Z"))
    private boolean sortSuggestions(String instance, String prefix, @Local(ordinal = 1)String string2, @Local(ordinal = 0)Suggestion suggestion) {
        return !suggestion.getText().startsWith("minecraft:" + string2) || !suggestion.getText().startsWith(PromiseMod.MOD_ID + ":" + string2);
    }
}
