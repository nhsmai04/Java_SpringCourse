import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
public abstract class Vehicle{
    private String vehicleNumber;
    private String manufacturer;
    private LocalDate manuDate ;
    private String color;
    private VehicleOwner owner;
    private String type;
    public Vehicle(String vehicleNumber,String manufacturer,LocalDate manuDate,
                   String color,VehicleOwner owner , String type)
    {
       if(vehicleNumber.length()!=5)
           throw new IllegalArgumentException("Vehicle number must be 5 digits");
       Set<String> validManufacturers = Set.of("Honda", "Yamaha", "Toyota", "Suzuki");
       if(!validManufacturers.contains(manufacturer))
           throw new IllegalArgumentException("Manufacturers only include: Honda, Yamaha, Toyota, Suzuki");
        // Kiểm tra năm sản xuất
        int currentYear = LocalDate.now().getYear();
        int manufactureYear = manuDate.getYear();
        if (manufactureYear <= 2000 || manufactureYear > currentYear) {
            throw new IllegalArgumentException("The year of manufacture must be less than or equal to the current year and greater than 2000");
        }
        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.manuDate = manuDate;
        this.color = color;
        this.owner = owner;
        this.type = type;
    }
    public String getVehicleNumber() { return vehicleNumber;};
    public String getManufacturer() { return manufacturer;};
    public String getType() {return type;};
    public VehicleOwner getOwner() {
        return owner;
    }
}

