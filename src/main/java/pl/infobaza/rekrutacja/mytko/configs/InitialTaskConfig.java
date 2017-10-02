package pl.infobaza.rekrutacja.mytko.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pl.infobaza.rekrutacja.mytko.models.Task;
import pl.infobaza.rekrutacja.mytko.repositories.JpaTaskRepository;

import javax.annotation.PostConstruct;

@Configuration
public class InitialTaskConfig {

    private JpaTaskRepository jpaTaskRepository;

    @Autowired
    public InitialTaskConfig(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @PostConstruct
    public void init() {

        Task task1 = new Task("Clear the kitchen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Task task2 = new Task("Clear the bedroom", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Task task3 = new Task("Clear the garage", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        task3.setCompleted(true);
        Task task4 = new Task("Clear the bathroom", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

        jpaTaskRepository.save(task1);
        jpaTaskRepository.save(task2);
        jpaTaskRepository.save(task3);
        jpaTaskRepository.save(task4);
    }
}
