package by.pstlabs.cognive.microservices.userlist.service;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GitService {

    private String username = "mage-wow@mail.ru";
    private String password = "mage7313";

    public GitService(){}

    public void push(String message) {
        CredentialsProvider cp = new UsernamePasswordCredentialsProvider(username, password);
        Git git = null;
        try {
            git = Git.open(new File(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddCommand add  = git.add();
        try {
            Files.walk(Paths.get(""))
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        if(!file.toFile().getAbsolutePath().contains(".lck")){
                            String name = Paths.get("").relativize(file.toFile().toPath()).toString().replace("..\\","").replace("\\","/");
                            add.addFilepattern(name);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            add.call();
        git.commit().setAuthor("Dobriy","mage-wow@mail.ru").setMessage(message).call();
        git.push().setCredentialsProvider(cp).setPushAll().call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }
}
