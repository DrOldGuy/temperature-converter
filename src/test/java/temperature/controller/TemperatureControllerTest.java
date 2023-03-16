/**
 * 
 */
package temperature.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import temperature.model.Temperature;

/**
 * This test class tests the various conversion methods in the
 * {@link TemperatureController} class.
 * 
 * @SpringBootTest This sets up an application context for the tests,
 * which allows Dependency Injection to be performed by Spring.
 * 
 * @author Promineo
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class TemperatureControllerTest {
  /** Inject a controller. */
  @Autowired
  private TemperatureController controller;

  /**
   * Test that the temperature in Farenheit is correctly converted to
   * Celsius and Kelvin.
   */
  @Test
  void testFarenheitConversion() {
    // Given: The temperature in Farenheit
    Double f = 84.7;
    Temperature expected = new Temperature(84.7, 29.28, 302.43);

    // When: the temperature is converted to Celsius and Kelvin
    Temperature actual = controller.convertFarenheit(f);

    // Then: the values are converted correctly.
    assertThat(actual).isEqualTo(expected);
  }

  /**
   * Test that the temperature in Celsius is correctly converted to
   * Farenheit and Kelvin.
   */
  @Test
  void testCelsiusConversion() {
    // Given: The temperature in Celsius
    Double c = 23.68;
    Temperature expected = new Temperature(74.62, 23.68, 296.83);

    // When: the temperature is converted to Farenheit and Kelvin
    Temperature actual = controller.convertCelsius(c);

    // Then: the values are converted correctly.
    assertThat(actual).isEqualTo(expected);
  }

  /**
   * Test that the temperature in Kelvin is correctly converted to
   * Farenheit and Celsius.
   */
  @Test
  void testKelvinConversion() {
    // Given: The temperature in Kelvin
    Double k = 932.14;
    Temperature expected = new Temperature(1218.18, 658.99, 932.14);

    // When: the temperature is converted to Farenheit and Celsius
    Temperature actual = controller.convertKelvin(k);

    // Then: the values are converted correctly.
    assertThat(actual).isEqualTo(expected);
  }
}
