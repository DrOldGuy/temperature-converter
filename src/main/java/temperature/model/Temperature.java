package temperature.model;

/**
 * This record is used by Jackson to convert the response to JSON like
 * this:
 * <pre>
 * {
 *   "farenheit": 1218.18,
 *   "celsius": 658.99,
 *   "kelvin": 932.14
 * }
 * </pre>
 * @author Promineo
 *
 */
public record Temperature(Double farenheit, Double celsius,
    Double kelvin) {
  /**
   * Add an all-argument constructor that rounds the Double values.
   * @param farenheit The degrees in Farenheit.
   * @param celsius The degrees in Celsius.
   * @param kelvin The degrees in Kelvin.
   */
  public Temperature(Double farenheit, Double celsius,
    Double kelvin) {
    this.farenheit = round(farenheit);
    this.celsius = round(celsius);
    this.kelvin = round(kelvin);
  }

  /**
   * Rounds the given Double value to 2 decimal places. 
   * @param deg The degree value to round.
   * @return The rounded value.
   */
  private Double round(Double deg) {
    return Math.round(deg * 100.0) / 100.0;
  }
}
