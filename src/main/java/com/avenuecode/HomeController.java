package com.avenuecode;

import com.avenuecode.repositories.UserConnectionInternalRepository;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.inject.Provider;
import java.security.Principal;

/**
 * Created by ac-jlima on 11/29/15.
 */
@Controller
public class HomeController {

    private final Provider<ConnectionRepository> connectionRepositoryProvider;

    private final UserConnectionInternalRepository userConnectionInternalRepository;

    @Inject
    public HomeController(Provider<ConnectionRepository> connectionRepositoryProvider, UserConnectionInternalRepository userConnectionInternalRepository) {
        this.connectionRepositoryProvider = connectionRepositoryProvider;
        this.userConnectionInternalRepository = userConnectionInternalRepository;
    }

    @RequestMapping("/")
    public String home(Principal currentUser, Model model) {
        model.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());
        model.addAttribute("user", userConnectionInternalRepository.findByUserId(currentUser.getName()));
        return "home";
    }

    private ConnectionRepository getConnectionRepository() {
        return connectionRepositoryProvider.get();
    }
}
