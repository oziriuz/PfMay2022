package ObjectsAndClasses.more_exercise.raw_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < input.length; j += 2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            printFragileAndLowTirePressure(cars);
        }

        if (command.equals("flamable")) {
            printFlamableAndHighPower(cars);
        }
    }

    public static void printFragileAndLowTirePressure(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().getType().equals("fragile")) {
                for (Tire tire : car.getTires()) {
                    if (tire.getPressure() < 1.0) {
                        System.out.println(car.getModel());
                        break;
                    }
                }
            }
        }
    }

    public static void printFlamableAndHighPower(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }
}
