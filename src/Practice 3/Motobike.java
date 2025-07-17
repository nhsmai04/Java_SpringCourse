import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
public class Motobike extends Vehicle
{
   private int capacity;
   public Motobike(String vehicleNumber,String manufacturer,LocalDate manuDate,
                   String color,VehicleOwner owner, int capacity)
   {
       super(vehicleNumber,manufacturer,manuDate,color,owner,"Bike");
       this.capacity = capacity;
   }
}