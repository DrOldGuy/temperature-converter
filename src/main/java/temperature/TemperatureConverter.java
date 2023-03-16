package temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import temperature.controller.TemperatureController;

/**
 * Entry point for Java application. This starts Spring Boot as a Web
 * application. Web requests are handled by the
 * {@link TemperatureController} class.
 * 
 * @author Promineo
 *
 */
@SpringBootApplication
public class TemperatureConverter {

  /**
   * Start Spring Boot.
   * @param args Unused.
   */
  public static void main(String[] args) {
    SpringApplication.run(TemperatureConverter.class, args);
  }

}
