package com.fernsehheft.playerstatsremake.core.integration;

import com.fernsehheft.playerstatsremake.api.events.StatSharedEvent;
import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.util.DiscordUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import com.fernsehheft.playerstatsremake.core.msg.msgutils.ComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class DiscordSRVIntegration implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onStatShared(StatSharedEvent event) {
        String plainText = getPlainText(event.getStatResult());
        String discordMessage = "🎮 **" + event.getSharer().getName() + "** shared a statistic:\n" + plainText;
        sendToDiscord(discordMessage);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onStatCalculated(com.fernsehheft.playerstatsremake.api.events.StatCalculatedEvent event) {
        String plainText = getPlainText(event.getStatResult().formattedComponent());
        String discordMessage = "📊 **" + event.getRequester().getName() + "** looked up a statistic:\n" + plainText;
        sendToDiscord(discordMessage);
    }

    private String getPlainText(Component component) {
        ComponentSerializer serializer = new ComponentSerializer();
        String legacyText = serializer.getTranslatableComponentSerializer().serialize(component);
        return ChatColor.stripColor(legacyText);
    }

    private void sendToDiscord(String message) {
        TextChannel mainChannel = DiscordSRV.getPlugin().getMainTextChannel();
        if (mainChannel != null) {
            DiscordUtil.sendMessage(mainChannel, message);
        }
    }
}
