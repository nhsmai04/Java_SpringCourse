import java.util.*;

interface methodArea<T>{
    T calculateArea();
    T calculatePerimeter();
}

class Square<T extends Number> implements methodArea<Double>{
    private T side ;

    public Square(T side)
    {
        this.side = side;
    }
    public T getSide(){
        return side;
    }

    @Override
    public Double calculateArea() {
        return side.doubleValue() * side.doubleValue();
    }

    @Override
    public Double calculatePerimeter() {
        return 4 * side.doubleValue();
    }
}
class Rectangle<T extends Number> implements methodArea<Double>{
    private T width;
    private T length;

    public Rectangle(T width,T length)
    {
        this.width = width;
        this.length = length;
    }
    public T getWidth(){
        return width;
    }
    public T getLength(){
        return length;
    }
    @Override
    public Double calculateArea() {
        return width.doubleValue() * length.doubleValue();
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (width.doubleValue() + length.doubleValue());
    }
}
public class InterfaceDemo {
 public static void main(String[] args)
 {
    Square<Integer> hv1 = new Square<>(5);
     System.out.println("Dien tich hinh vuong la:" + hv1.calculateArea());
     System.out.println("Chu vi hinh vuong la:" + hv1.calculatePerimeter());

    Rectangle<Double> cn1 = new Rectangle<>(3.2,4.5);
     System.out.println("Dien tich hinh chu nhat  la:" + cn1.calculateArea());
     System.out.println("Chu vi hinh chu nhat la:" + cn1.calculatePerimeter());

 }
}