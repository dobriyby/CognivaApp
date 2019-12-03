package by.pstlabs.cognive.microservices.notifications.model;




import by.pstlabs.cognive.common.login.config.SecureConfig;
import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.notifications.service.TelegramBotService;
import by.pstlabs.cognive.microservices.userlist.repository.UserRepository;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.imageio.ImageIO;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private TelegramBotService telegramBotService;

    private static final String token  = "1044087270:AAHgw5xjjTeXzSV3jw5DRKoKPm9nuEvq1WQ";
    private static final String BIG_BOSS = "471858191";

    private Logger log = LoggerFactory.getLogger(TelegramBot.class);

    public TelegramBot(TelegramBotService service){
        this.telegramBotService = service;
    }

    public synchronized void sendMsg(String chatId, String s) {
        if(chatId.equals("")){
            chatId = BIG_BOSS;
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error( "Exception: " + e.toString());
        }
    }

    public synchronized void sendImage(String chatId, BufferedImage img) throws IOException {
        if(chatId.equals("")){
            chatId = BIG_BOSS;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        File file = new File("/screenshot.png");
        ImageIO.write(img, "png", file);
        sendPhoto.setPhoto(file);
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            log.error( "Exception: " + e.toString());
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        try {
            telegramBotService.checkUpdate(update);
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "CognivaBot";
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
