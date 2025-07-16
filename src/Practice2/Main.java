import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public abstract class Goods{
    private String code;
    private String name;
    private int quantity;
    private double price;
    private String status;

    public Goods(String code , String name, int quantity, double price)
    {
        if( quantity < 0)  throw new IllegalArgumentException("Quantity must be => 0.");

        if (price < 0) throw new IllegalArgumentException("Unit price must be >= 0");
        this.code=code;
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.status="NULL";
    }

    public String getCode(){return code;};
    public String getName(){return name;};
    public int getQuantity(){return quantity;};
    public double getPrice(){return price;};
    public void setStatus(String status){ this.status= status;};
    public abstract void methodMeasure();
    public  void display()
    {
        System.out.println("Food Product:");
        System.out.println("  Code: " + code);
        System.out.println("  Name: " + name);
        System.out.println("  Quantity: " + quantity);
        System.out.println("  Unit Price: " + price);
        System.out.println("  Status: "+ status);
    }
}

public abstract class PerishableProduct extends Goods
{
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private String supplier;
    public PerishableProduct(String code , String name, int quantity,
                             double price, LocalDate manufactureDate,
                             LocalDate expiryDate,String supplier)
    {
        super(code,name,quantity,price);
        if(expiryDate.isBefore(manufactureDate))
            throw new IllegalArgumentException("Valid manufactureDate, Must be >= ExpiryDate");

        this.manufactureDate=manufactureDate;
        this.expiryDate=expiryDate;
        this.supplier=supplier;
    }
    @Override
    public void methodMeasure()
    {
        int temp = getQuantity();
        LocalDate currentDate = LocalDate.now();
        if(temp > 0 &&  expiryDate.isBefore(currentDate))
        {
            setStatus("Hard to sell");

        }    }
    public void display(){
        super.display();
        System.out.println("  Manufacture Date: " + manufactureDate);
        System.out.println("  Expiry Date: " + expiryDate);
        System.out.println("  Supplier: " + supplier);
    }
}

class Food extends PerishableProduct{

    public Food(String code , String name, int quantity,
                double price, LocalDate manufactureDate,
                LocalDate expiryDate,String supplier)
     {
        super(code, name, quantity, price, manufactureDate, expiryDate, supplier);
    }

    public double getVATRate(){
        return 0.05;
    }
}

class CareProduct extends  PerishableProduct{
    public CareProduct(String code , String name, int quantity,
                double price, LocalDate manufactureDate,
                LocalDate expiryDate,String supplier)
     {
        super(code, name, quantity, price, manufactureDate, expiryDate, supplier);
    }
}

class Electricalgoods extends Goods{
    private int warrantyDate;
    private double capacityKW;

    public Electricalgoods(String code , String name, int quantity, double price , int warrantyDate , double capacityKW)
            {
        super(code,name,quantity,price);
        if(warrantyDate < 0 )
            throw new IllegalArgumentException("Valid warrantyDate, Must be >= 0");
        if(capacityKW < 0)
            throw new IllegalArgumentException("Valid capacityKW, Must be >=0");

        this.warrantyDate = warrantyDate;
        this.capacityKW = capacityKW;
    }

    public void methodMeasure()
    {
        int temp = getQuantity();
        if(temp < 3)
        {
            setStatus("Sold");
        }
    }
    public void display(){
        super.display();
        System.out.println("  Warranty Month: " + warrantyDate);
        System.out.println("  Capacity KW: " + capacityKW);

    }
    public double getVATRate(){
        return 0.1;
    }
}

class Crockery extends Goods{
    private String author;
    private LocalDate arrivalDate;
    public Crockery (String code , String name, int quantity, double price , String author, LocalDate arrivalDate)

    {
        super(code,name,quantity,price);
        this.author = author;
        this.arrivalDate = arrivalDate;
    }

    public void display(){
        super.display();
        System.out.println("  Author:: " + author);
        System.out.println("  Arrival Date: " + arrivalDate);

    }

    public void methodMeasure()
    {
        int temp = getQuantity();
        LocalDate  currentDate = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(arrivalDate, currentDate);
        if(temp > 50 && daysBetween > 10 )
        {
            setStatus("Slow sale ");
        }
    }
    public double getVATRate(){
        return 0.1;
    }
}

public class DSHH{
    private Goods[] lists;
    private int count; // Số lượng phần tử
    private int capacity; // kích thước mảng

    public DSHH(int capacity)
    {
        this.capacity = capacity;
        this.lists = new Goods[capacity];
        this.count = 0 ;
    }
 //----Add single Good ------
    public void addGood(Goods temp)
    {
        if(count >= capacity)
        {
            System.out.println("List was full , cant be added");
            return;
        }
        lists[count] = temp;
        count++;
        System.out.println("Add Successfully");
    }
//----Display All Good------
    public void displayALL(){
        for(int i = 0 ; i < count ;i++)
        {
            System.out.println("----- Sản phẩm #" + (i + 1) + " -----");
            lists[i].display();
        }
    }
//--- Add good with input
    public void AddGoodInput()
    {
        if(count>=capacity)
        {
            System.out.println("List was full , cant be added");
            return;
        }

        Scanner sc = new Scanner(System.in);
        
        // Code input
        System.out.print("Enter code:");
        String code = sc.nextLine();

        //Check valid Code
        for(int i = 0;i < count;i++)
        {
            if(lists[i].getCode().equalsIgnoreCase(code))
            {
                System.out.println("Code already exists");
                return;
            }
        }

        // Name input
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();

        // Quantity input
        System.out.print("Nhập số lượng tồn kho: ");
        int quantity = Integer.parseInt(sc.nextLine());

        // Price input
        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());

        // choose type of good
        System.out.println("Chọn loại sản phẩm:");
        System.out.println("1. Food");
        System.out.println("2. Care Product");
        System.out.println("3. Electrical Goods");
        System.out.println("4. Crockery");
        System.out.print("Lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());

        Goods temp = null;

        switch (choice) {
            case 1: //Food
                System.out.print("Ngày sản xuất (yyyy-MM-dd): ");
                LocalDate manu1 = LocalDate.parse(sc.nextLine());
                System.out.print("Hạn sử dụng (yyyy-MM-dd): ");
                LocalDate exp1 = LocalDate.parse(sc.nextLine());
                System.out.print("Nhà cung cấp: ");
                String sup1 = sc.nextLine();
                temp = new Food(code, name, quantity, price, manu1, exp1, sup1);
                break;
            case 2: //CareProduct
                System.out.print("Ngày sản xuất (yyyy-MM-dd): ");
                LocalDate manu2 = LocalDate.parse(sc.nextLine());
                System.out.print("Hạn sử dụng (yyyy-MM-dd): ");
                LocalDate exp2 = LocalDate.parse(sc.nextLine());
                System.out.print("Nhà cung cấp: ");
                String sup2 = sc.nextLine();
                temp = new CareProduct(code, name, quantity, price, manu2, exp2, sup2);
                break;
            case 3: // ElectricalGoods
                System.out.print("Thời gian bảo hành (tháng): ");
                int warranty = Integer.parseInt(sc.nextLine());
                System.out.print("Công suất (KW): ");
                double kw = Double.parseDouble(sc.nextLine());
                temp = new Electricalgoods(code, name, quantity, price, warranty, kw);
                break;
            case 4: //Crockery
                System.out.print("Nhà sản xuất: ");
                String manuf = sc.nextLine();
                System.out.print("Ngày nhập kho (yyyy-MM-dd): ");
                LocalDate arrival = LocalDate.parse(sc.nextLine());
                temp = new Crockery(code, name, quantity, price, manuf, arrival);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        addGood(temp);

    }
}


public class Main{
    public static void main(String[] args)
    {
        DSHH goodlists = new DSHH(2);
        for(int i = 0 ; i < 2;i++)
        {
            goodlists.AddGoodInput();
        }

        goodlists.displayALL();
    }
}