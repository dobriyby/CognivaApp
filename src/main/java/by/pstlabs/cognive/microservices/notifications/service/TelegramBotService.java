package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.notifications.model.TelegramBot;
import by.pstlabs.cognive.microservices.userlist.repository.UserRepository;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
import com.github.sarxos.webcam.Webcam;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.attributes.AttributesNodeProvider;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Service
public class TelegramBotService{

    private static final Logger log = Logger.getLogger(TelegramBotService.class.getName());

    @Autowired
    UserService userService;

    private TelegramBot bot;

    public TelegramBotService() throws IOException {
        FileHandler fh = new FileHandler("logs/telegrambot.log");
        fh.setFormatter(new SimpleFormatter());
        log.addHandler(fh);
        log.setUseParentHandlers(false);
        ApiContextInitializer.init();
        bot = new TelegramBot(this);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToBigBoss(String text){
        bot.sendMsg("",text);
    }

    public TelegramBot getBot(){
        return bot;
    }

    public void checkUpdate(Update update) throws AWTException, IOException, GitAPIException {
        String user = update.getMessage().getFrom().getId().toString();
        switch (update.getMessage().getText()) {
            case ("/listusers"): {
                ArrayList<String> list = new ArrayList<String>();
                userService.getAllUsers().forEach(_user -> list.add(_user.getName()));
                bot.sendMsg(update.getMessage().getFrom().getId().toString(), list.toString());
                log.info("Send listusers to "+update.getMessage().getFrom().getFirstName());
                break;
            }
            case ("/screen"): {
                System.setProperty("java.awt.headless", "false");
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                bot.sendImage(user,image);
                log.info("Send screenshot to "+update.getMessage().getFrom().getFirstName());
                break;
            }
            case ("/camerashot"):{
                Webcam webcam = Webcam.getDefault();
                webcam.open();
                bot.sendImage(user,webcam.getImage());
                webcam.close();
                log.info("Send webcam screenshot to "+update.getMessage().getFrom().getFirstName());
                break;
            }
            case ("/gitpush"):{
                CredentialsProvider cp = new UsernamePasswordCredentialsProvider("mage-wow@mail.ru", "mage7313");
//                Git git = Git.cloneRepository()
//                        .setURI("https://dobriyby2@bitbucket.org/MTband/cognive-microservices.git")
//                        .setBranch("dev")
//                        .setCredentialsProvider(cp)
//                        .setDirectory(new File("/path/to/repo"))
//                        .call();
                Git git = Git.open(new File(""));
                System.out.println(git.getRepository().getDirectory().getAbsolutePath());
                git.branchList().call().forEach(branch -> System.out.println(branch.getName()));
                RevCommit rev =  git.commit().setAuthor("Dobriy","mage-wow@mail.ru").setMessage("test cfffommit").call();
                git.push().setCredentialsProvider(cp).setPushAll().call();
                break;
            }
            default:
                log.info(update.getMessage().getText()+" from "+ update.getMessage().getFrom().getFirstName());
                break;
            }
    }
}
