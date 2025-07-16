import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
public class Truck extends Vehicle{
    private double tonnage;
    public Truck(String vehicleNumber,String manufacturer,LocalDate manuDate,
                 String color,VehicleOwner owner,double tonnage)
    {
        super(vehicleNumber,manufacturer,manuDate,color,owner,"Truck");
        this.tonnage=tonnage;
    }
}