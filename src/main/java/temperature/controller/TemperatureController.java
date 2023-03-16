package temperature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import temperature.model.Temperature;
import temperature.service.TemperatureService;

/**
 * This class handles the HTTP GET requests to /temperature.
 * 
 * @author Promineo
 *
 */
@RestController
@RequestMapping("/temperature")
public class TemperatureController {

  /** The temperature service injected by Spring. */
  @Autowired
  private TemperatureService temperatureService;

  /**
   * Convert the temperature in Farenheit to Celsius and Kelvin. To
   * call this method, send an HTTP GET request to
   * /temperature/farenheit/{deg} where {deg} is the degrees Farenheit
   * to convert.
   * 
   * @param f The degrees Farenheit to convert.
   * @return An object with the given temperature converted to all the
   *         temperature systems.
   */
  @GetMapping("/farenheit/{f}")
  public Temperature convertFarenheit(@PathVariable double f) {
    return temperatureService.convertFarenheit(f);
  }

  /**
   * Convert the temperature in Celsius to Farenheit and Kelvin. To
   * call this method, send an HTTP GET request to
   * /temperature/celsius/{deg} where {deg} is the degrees Celsius
   * to convert.
   * 
   * @param c The degrees Celsius to convert.
   * @return An object with the given temperature converted to all the
   *         temperature systems.
   */
  @GetMapping("/celsius/{c}")
  public Temperature convertCelsius(@PathVariable double c) {
    return temperatureService.convertCelsius(c);
  }

  /**
   * Convert the temperature in Kelvin to Celsius and Farenheit. To
   * call this method, send an HTTP GET request to
   * /temperature/kelvin/{deg} where {deg} is the degrees Kelvin
   * to convert.
   * 
   * @param k The degrees Kelvin to convert.
   * @return An object with the given temperature converted to all the
   *         temperature systems.
   */
  @GetMapping("/kelvin/{k}")
  public Temperature convertKelvin(@PathVariable double k) {
    return temperatureService.convertKelvin(k);
  }
}
