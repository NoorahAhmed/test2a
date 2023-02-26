package nl.multicode;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.multicode.controller.PersonController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

import java.util.stream.Collectors;

@Slf4j
@Validated
@AllArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {

    private PersonController controller;

    public static void main(String[] args) {

        log.info("STARTING THE APPLICATION");
        SpringApplication.run(Application.class, args);
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {

        log.info("EXECUTING : command line runner");
        if (args.length > 0) {
            log.info(controller.readPersonsFile(args[0]).stream()
                    .map(p -> p.toString() + "\n")
                    .collect(Collectors.joining()));
        } else log.warn("No csv file provided! Nothing to read!");
    }
}