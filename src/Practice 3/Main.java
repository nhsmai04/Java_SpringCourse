import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
public class Main{
    public static void main(String[] args)
    {
        VehicleOwner owner1 = new VehicleOwner("123456789012", "Nguyen Van A", "a@example.com");
        VehicleOwner owner2 = new VehicleOwner("234567890123", "Tran Thi B", "b@example.com");
        VehicleOwner owner3 = new VehicleOwner("345678901234", "Le Van C", "c@example.com");

        Vehicle car1 = new Car("A1234", "Honda", LocalDate.of(2015, 5, 10), "Red", owner1,7,"Diesel");
        Vehicle car2 = new Car("B5678", "Toyota", LocalDate.of(2018, 3, 20), "Blue", owner2,4,"Petrol");
        Vehicle car3 = new Car("C9012", "Honda", LocalDate.of(2020, 7, 15), "White", owner3,16,"Electric");

        Vehicle bike1 = new Motobike("D3456", "Yamaha", LocalDate.of(2017, 1, 5), "Black", owner1,20);
        Vehicle bike2 = new Motobike("E7890", "Suzuki", LocalDate.of(2019, 9, 25), "Green", owner2,50);

        Vehicle truck1 = new Truck("F1357", "Toyota", LocalDate.of(2016, 4, 18), "Yellow", owner3,16.2);
        Vehicle truck2 = new Truck("G2468", "Honda", LocalDate.of(2021, 11, 11), "Silver", owner1,10.0);

        VehicleManagement vm = new VehicleManagement("TestUser");
        vm.AddVehicle(car1);
        vm.AddVehicle(car2);
        vm.AddVehicle(car3);
        vm.AddVehicle(bike1);
        vm.AddVehicle(bike2);
        vm.AddVehicle(truck1);
        vm.AddVehicle(truck2);

        System.out.println("===== Statistics =====");
        Map<String, Integer> stats = vm.StatisticVehicle();
        stats.forEach((k,v)->System.out.println(k + ": " + v));
    }
}