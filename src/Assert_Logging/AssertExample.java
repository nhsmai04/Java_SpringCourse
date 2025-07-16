import java.util.*;
public class AssertExample{
    static void checkPositive(int x)
    {
        System.out.println("Kiem tra gia tri x  ");
        assert x < 0 : "X là số âm , chương trình lỗi" + x ;
        System.out.println("X la so duong");
    }
    static void checkEven(int y)
    {
        System.out.println("Kiem tra x co phai so chan ? ");
        assert y % 2 == 0 : "X la so le , chuong trinh loi" + y;
        System.out.println("X la so chan");
    }
    public static void main(String[] args)
    {
        System.out.println("Demo Assert");
        checkPositive(5);
        checkEven(10);
    }

}