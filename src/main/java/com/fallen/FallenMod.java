package com.fallen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FallenMod implements ModInitializer {
    public static final String MOD_ID = "fallen";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Fallen Mod инициализирован!");

        // Регистрируем событие подключения игрока к серверу
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.getPlayer();
            
            // Создаем текст с приветствием фиолетового цвета
            Text welcomeMessage = Text.literal("Приветствую дорогой игрок")
                    .formatted(Formatting.LIGHT_PURPLE);
            
            // Отправляем сообщение игроку
            player.sendMessage(welcomeMessage, false);
            
            LOGGER.info("Отправлено приветствие игроку: {}", player.getName().getString());
        });
    }
}