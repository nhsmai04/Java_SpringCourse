package GenericArrayLists53.AccessingArrayListElements531;

import java.util.ArrayList;
import java.util.Collections;
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>(); //khai bao ArrayList kieu string
        cars.add("honda");
        cars.add("toyota");
        cars.add(0, "BMW"); //Them BMW vao dau danh sach
        System.out.println(cars);
        String e = cars.get(0); //Lay phan tu dau tien cua ArrayList
        System.out.println(e);
        String a = cars.get(1); //Lay phan tu thu hai cua ArrayList
        System.out.println(a);
        cars.set(0, "Ford"); //Thay doi phan tu dau tien cua ArrayList thanh "Ford"
        System.out.println(cars);
        cars.remove(0); //Xoa phan tu dau tien cua ArrayList
        System.out.println(cars);
        cars.clear(); //Xoa het tat ca cac phan tu trong ArrayList
        System.out.println(cars);
        System.out.println(cars.size()); //Xuat ra so luong phan tu trong ArrayList
        //Dung vong lap de lay tung phan tu trong ArrayList
        cars.add("mitsubishi");
        cars.add("sa");
        cars.add("das");
        cars.add("Fox");
        for(int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i));
        }

        ArrayList<Integer> number = new ArrayList<Integer>(); //tao ArrayList de luu cac so nguyen
        number.add(10);
        number.add(20);
        number.add(30);
        number.add(0);
        Collections.sort(number); //sap xep lai ArrayList number
        for(int i = 0; i < number.size(); i++){
            System.out.println(number.get(i));
        }
    }
}
