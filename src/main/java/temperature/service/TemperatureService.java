package temperature.service;

import org.springframework.stereotype.Service;
import temperature.model.Temperature;

/**
 * This class performs the temperature conversions using a Functional
 * Interface and Lambda expressions.
 * 
 * @author Promineo
 *
 * @param <R>
 */
@Service
public class TemperatureService {
  @FunctionalInterface
  interface Op {
    Double convert(Double value);
  }

  Op fToC = f -> (f - 32) * 5 / 9;
  Op cToF = c -> c * 9 / 5 + 32;
  Op cToK = c -> c + 273.15;
  Op kToC = k -> k - 273.15;

  /**
   * Convert from Farenheit to Celsius and Kelvin.
   * 
   * @param f The degrees Farenheit to convert.
   * @return The converted values.
   */
  public Temperature convertFarenheit(Double f) {
    Double c = fToC.convert(f);
    Double k = cToK.convert(c);
    return new Temperature(f, c, k);
  }

  /**
   * Convert from Celsius to Farenheit and Kelvin.
   * 
   * @param c The degrees Celsius to convert.
   * @return The converted values.
   */
  public Temperature convertCelsius(Double c) {
    Double f = cToF.convert(c);
    Double k = cToK.convert(c);
    return new Temperature(f, c, k);
  }

  /**
   * Convert from Kelvin to Farenheit and Celsius.
   * 
   * @param k The degrees Kelvin to convert.
   * @return The converted values.
   */
  public Temperature convertKelvin(double k) {
    Double c = kToC.convert(k);
    Double f = cToF.convert(c);
    return new Temperature(f, c, k);
  }
}
