package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring.service.GameController;

import static org.springframework.shell.Availability.available;
import static org.springframework.shell.Availability.unavailable;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private final GameController gameController;

    @ShellMethod(value = "login", key = {"login", "l"})
    public String login() {
        gameController.login();
        return "Для старта теста введите start-game или sg или g";
    }

    @ShellMethodAvailability(value = "isLoginAvailable")
    @ShellMethod(value = "Start Game", key = {"start-game", "sg", "g"})
    public String startGame() {
        gameController.startTest();
        return "Тест завершен! Если хотите узнать результаты нажмите Y";
    }

    private Availability isLoginAvailable() {
        return gameController.isLogin()
                ? available()
                : unavailable("Вам нужно залогиниться. Введите login или l");
    }

    @ShellMethodAvailability(value = "testIsPassed")
    @ShellMethod(value = "Get score", key = {"Y"})
    public void getScore() {
        gameController.getScore();
    }

    private Availability testIsPassed() {
        return gameController.testIsPassed()
                ? available()
                : unavailable("Вы еще не прошли тест.");
    }
}
