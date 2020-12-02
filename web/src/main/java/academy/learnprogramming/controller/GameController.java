package academy.learnprogramming.controller;

import academy.learnprogramming.service.GameService;
import academy.learnprogramming.util.Attributes;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class GameController {
    // == fields ==
    private final GameService gameService;

    // == constructors ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // == handlers ==
    @GetMapping(Mappings.PLAY)
    public String play(Model model){

        model.addAttribute(Attributes.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(Attributes.RESULT_MESSAGE, gameService.getResultMessage());
        if (gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }

    @PostMapping(Mappings.PLAY)
    public String checkGuess(@RequestParam int guess){
        log.info("guess = {}",guess);
        gameService.checkGuess(guess);
        return Mappings.REDIRECT_PLAY;
    }

    @GetMapping(Mappings.HOME_AFTER_RESET)
    public String resetAndHome(Model model){
        log.info("game over");
        log.info("reset() game");
        gameService.reset();
        return ViewNames.HOME;
    }

    @GetMapping(Mappings.RESTART_GAME)
    public String restart(){
        log.info("reset() game");
        gameService.reset();
        return Mappings.REDIRECT_PLAY;
    }
}
