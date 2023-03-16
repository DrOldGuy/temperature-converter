# Temperature converter

This simple project introduces records, functional programming and unit testing in a Spring Boot Web environment.

# Running the application

Start the application by running temperature.TemperatureConverter as a Java application.

## Application endpoints

### Convert Farenheit to Celsius and Kelvin

To convert a temperature in Farenheit to Celsius and Kelvin, send an HTTP GET request to the running application at **http://localhost:8080/temperature/farenheit/{deg-F}** where {deg-F} is the degrees in Farenheit to convert. For example, to convert 59 degrees F, send and HTTP GET request to **http://localhost:8080/temperature/farenheit/59**. Since the request is a GET request you can use a browser for this.

### Convert Celsius to Farenheit and Kelvin

To convert a temperature in Celsius to Farenheit and Kelvin, send an HTTP GET request to the running application at **http://localhost:8080/temperature/celsius/{deg-C}** where {deg-C} is the degrees in Celsius to convert. For example, to convert 59 degrees C, send and HTTP GET request to **http://localhost:8080/temperature/celsius/59**. Since the request is a GET request you can use a browser for this.

### Convert Kelvin to Farenheit and Celsius

To convert a temperature in Kelvin to Farenheit and Celsius, send an HTTP GET request to the running application at **http://localhost:8080/temperature/kelvin/{deg-K}** where {deg-K} is the degrees in Kelvin to convert. For example, to convert 59 degrees K, send and HTTP GET request to **http://localhost:8080/temperature/kelvin/59**. Since the request is a GET request you can use a browser for this.

## Formulas

This application uses the well-known formulas to convert temperatures as follows:

C = (F - 32) * 5 / 9
F = C * 9 / 5 + 32
K = C + 273.15

In the formulas above, C = degrees Celsius, F = degrees Farenheit, and K = degrees Kelvin.

## Where things happen

**temperature.TemperatureConverter.java** starts the Spring application.

**temperature.controller.TemperatureController.java** This class contains methods to handle the HTTP GET requests.

**temperature.model.Temperature.java** This is a Java record (a read-only class-ish structure) that holds the converted temperature data.

**temperature.service.TemperatureService.java** This class performs the temperature conversions and returns the results to the controller.

## How things happen

All conversions happen in the service class. The service defines an internal (i.e., not public) Functional Interface named Op. The Op interface has a single method (hence the Functional Interface designation) with the signature *Double convert(Double value)*. 

The service defines four variables of type Op that take Lambda expressions. They define the conversions:

* Farenheit to Celsius
* Celsius to Farenheit
* Celsius to Kelvin
* Kelvin to Celsius

From these Lambda expresions, all of the conversions can be performed. Here are the Lambda expressions:

```
Op fToC = f -> (f - 32) * 5 / 9;
Op cToF = c -> c * 9 / 5 + 32;
Op cToK = c -> c + 273.15;
Op kToC = k -> k - 273.15;
```

In the expressions above, f = degrees Farenheit, c = degrees Celsius, and k = degrees Kelvin. To convert from one temperature system to another, call the convert() method on the appropriate variable. For example, to convert from Farenheit to Celsius, call:

```
Double c = fToC.convert(f);
```

## Unit tests

Unit tests are in src/test/java in the temperature.controller package.