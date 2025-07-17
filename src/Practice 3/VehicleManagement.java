import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class VehicleManagement{
    public ArrayList<Vehicle> vehicles;
    public String Author;
    public VehicleManagement(String author)
    {
        this.Author = author;
        this.vehicles = new ArrayList<>();
    }
    public void AddVehicle(Vehicle vehicle)
    {
        for(Vehicle temp :vehicles)
            if(temp.getVehicleNumber().equals(vehicle.getVehicleNumber()))
                throw new IllegalArgumentException("Vehicle number already exists");
        vehicles.add(vehicle);
    }
    // Find by Number
    public Vehicle findbyNumber(String number)
    {
        for(Vehicle temp : vehicles)
        {
            if(temp.getVehicleNumber().equals(number))
                return temp;
        }
        return null;
    }


    // Find by ID
    public Vehicle findByID(String cmnd)
    {
        for(Vehicle temp : vehicles)
        {
            if(temp.getOwner().cmnd().equals(cmnd))
                return temp;
        }
        return null;
    }
    // Delete by Manu
    public void deleteByManu(String  manufacturer )
    {
        for(int i =vehicles.size() -1; i>=0 ;i--)
        {
            if(vehicles.get(i).getManufacturer().equals(manufacturer))
                vehicles.remove(i);
        }
    }

    // Find the most manufacturer vehicle
    public String Findthemost()
    {
        if(vehicles.isEmpty())
        {
            return "Khong co xe nao";
        }

        Map<String,Integer> CountMap = new HashMap<>();

        for(Vehicle v : vehicles)
        {
            String manu = v.getManufacturer();
            CountMap.put(manu,CountMap.getOrDefault(manu, 0) + 1);
        }


        Map.Entry<String,Integer> maxEntry = Collections.max(
                CountMap.entrySet(),
                Map.Entry.comparingByValue()
        );
        String maxManu = maxEntry.getKey();
        int max = maxEntry.getValue() ;
        return "Hãng sản xuất có nhiều xe nhất: " + maxManu + " (" + max + " xe)";
    }

    // Sort vehicles by number of vehicles in descending order
    public ArrayList<Vehicle> getVehiclesSortedByManufacturerCountDesc() {
        if (vehicles.isEmpty()) {
            return new ArrayList<>();
        }

        // 1. Đếm số lượng xe mỗi hãng
        Map<String, Integer> countMap = new HashMap<>();
        for (Vehicle v : vehicles) {
            String manu = v.getManufacturer();
            countMap.put(manu, countMap.getOrDefault(manu, 0) + 1);
        }

        // 2. Tạo comparator: dựa trên số lượng của hãng
        Comparator<Vehicle> comparator = (v1, v2) -> {
            int count1 = countMap.get(v1.getManufacturer());
            int count2 = countMap.get(v2.getManufacturer());
            // Sắp giảm dần
            return Integer.compare(count2, count1);
        };

        // 3. Tạo bản sao danh sách gốc để không làm thay đổi vehicles ban đầu
        ArrayList<Vehicle> sortedList = new ArrayList<>(vehicles);

        // 4. Sắp xếp
        sortedList.sort(comparator);

        return sortedList;
    }
     //Statistics of each vehicle type, how many vehicles are being managed
    public Map<String,Integer> StatisticVehicle(){
        int carCount =0;
        int motobikeCount =0;
        int truckCount =0;
        for ( Vehicle temp : vehicles)
        {
            String type = temp.getType();
            switch (type) {
                case "Car": carCount++; break;
                case "Bike": motobikeCount++; break;
                case "Truck": truckCount++; break;
            }
        }
        Map<String,Integer> sortType = new HashMap<>();
        sortType.put("Car",carCount);
        sortType.put("Bike",motobikeCount);
        sortType.put("Truck",truckCount);

        return sortType;
    }
    // Print

}