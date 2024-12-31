import java.util.Scanner;
public class SimpleTemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature value:");
        double temperature = scanner.nextDouble();
        System.out.println("Enter the unit of measurement (C for Celsius, F for Fahrenheit):");
        char unit = scanner.next().charAt(0);
        double convertedTemperature;
        if (unit == 'C' || unit == 'c') {
            convertedTemperature = (temperature * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
        } else if (unit == 'F' || unit == 'f') {
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + convertedTemperature);
        } else {
            System.out.println("Invalid unit of measurement.");
        }
        scanner.close();
    }
}
