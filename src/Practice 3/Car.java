import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
public class Car extends Vehicle
{
    private int numberSeats;
    private String engineType;

    public Car(String vehicleNumber,String manufacturer,LocalDate manuDate,
               String color,VehicleOwner owner, int numberSeats , String engineType )
    {
        super(vehicleNumber,manufacturer,manuDate,color,owner,"Car");
        // Kiểm tra numberSeats
        if (numberSeats <= 0) {
            throw new IllegalArgumentException("Số ghế phải lớn hơn 0.");
        }

        // Kiểm tra engineType
        if (engineType == null || engineType.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại động cơ không được để trống.");
        }

        this.numberSeats = numberSeats;
        this.engineType = engineType;
    }
}