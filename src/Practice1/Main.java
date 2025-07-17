import java.util.*;

abstract class Shape<T>{
    private double width;
    private double height;
    public abstract double getArea();
    public abstract double getPerimeter();
    public double getWidth(){return width;};
    public double getHeight(){return height;};
    public void setWidth(double x){this.width=x;};
    public void setHeight(double y){this.height=y;};
}
class Rectangle extends Shape{
    public Rectangle(double x,double y)
    {
        setHeight(y);
        setWidth(x);
    }

    public double getArea()
    {
        return getHeight() * getWidth();
    }


    public double getPerimeter() {
       return 2 * (getHeight()+getWidth());
    }
}
class Circle extends Shape{
    private double r;
    public Circle(double r){this.r=r;};
    public double getArea(){
        return Math.PI * r * r;
    }
    public double getPerimeter(){
        return 2 * r * Math.PI;
    }
}
public class Main{
    public static void main(String[] args)
    {
        Rectangle hv1 = new Rectangle(3,4);
        System.out.println("Dien tich hinh chu nhat la:"+ hv1.getArea());
        System.out.println("Chu vi hinh chu nhat la:"+ hv1.getPerimeter());
        Circle tron1= new Circle(6);
        System.out.printf("Diện tích hình tròn: %.2f\n", tron1.getArea());
        System.out.printf("Chu vi hinh tron la: %.2f\n" , tron1.getPerimeter());
    }
}