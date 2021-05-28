package me.aisuma.testScanner;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.simpleyaml.configuration.file.YamlConfiguration;
import org.simpleyaml.configuration.file.YamlFile;

import javax.security.auth.login.LoginException;
import java.io.File;

public class testMain {

    public void testBotJoinWithConfig() {
        final YamlFile yamlFile = new YamlFile("test.yml");
        try {
            yamlFile.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String token = (String) yamlFile.get("settings.token");
        try {
            JDA jda = JDABuilder.createDefault(token)
                    .enableIntents(GatewayIntent.GUILD_PRESENCES) //Allows in depth data retrieval
                    .enableCache(CacheFlag.ACTIVITY) //Enables member.getActivities(); using ^
                    .setActivity(Activity.playing("Indev 0.1"))
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .build();
        }
        catch (LoginException ex) {
            ex.printStackTrace();
        }
    }
}
