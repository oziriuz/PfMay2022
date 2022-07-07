package ObjectsAndClasses.exercise.vehicle_catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Vehicle> vehicleList = new ArrayList<>();
        while (!input[0].equals("End")) {
            String typeOfVehicle = input[0];
            typeOfVehicle = typeOfVehicle.substring(0, 1).toUpperCase(Locale.ROOT) + typeOfVehicle.substring(1);
            String model = input[1];
            String color = input[2];
            int horsePower = Integer.parseInt(input[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePower);
            vehicleList.add(vehicle);

            input = scanner.nextLine().split(" ");
        }

        String endString = "Close the Catalogue";
        String model = scanner.nextLine();
        while (!model.equals(endString)) {
            for (Vehicle vehicle : vehicleList) {
                if(model.equals(vehicle.getModel())) {
                    System.out.printf("Type: %s%n", vehicle.getTypeOfVehicle());
                    System.out.printf("Model: %s%n", vehicle.getModel());
                    System.out.printf("Color: %s%n", vehicle.getColor());
                    System.out.printf("Horsepower: %d%n", vehicle.getHorsePower());
                }
            }
            model = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averagePower(vehicleList, "Car"));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averagePower(vehicleList, "Truck"));
    }

    private static double averagePower(List<Vehicle> vehicleList, String filter) {
        double sum = 0;
        int counter = 0;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getTypeOfVehicle().equals(filter)){
                sum += vehicle.getHorsePower();
                counter++;
            }
        }
        if (counter > 0) {
            return sum / counter;
        } else {
            return 0;
        }
    }
}
