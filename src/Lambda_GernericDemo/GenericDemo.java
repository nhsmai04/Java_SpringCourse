import java.util.*;

class Person<T>{
    private Integer id;
    private T age;
    public Person(Integer id , T age){
        this.id = id;
        this.age = age;
    }
    public Integer getID(){
        return id;
    }
    public T getAge()
    {
        return age;
    }
}

class DemoMethod{
    @SafeVarargs
    public static <E> E getMiddle(E... array)
    {
        return array[array.length/2];
    }
}

class DemoUpperBound{
    public static double sumNumbers (List<? extends Number> list )
    {
        double sum = 0;
        for(Number n : list)
        {
            sum+=n.doubleValue();
        }
        return sum;
    }
}

class DemoLowerBound{
    public static void addIntergers(List<? super Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("List after adding:" + list);
    }
}
public class GenericDemo {
    public static void main(String[] args){
        // 1. Demo generic class
        Person<Double> person1 = new Person<>(1,2.1);
        System.out.println("Id Person 1 :" + person1.getID() + " Age Person 1 :" + person1.getAge());
        Person<Integer> person2 = new Person<>(2,20);
        System.out.println("Id Person 2 :" + person2.getID() + " Age Person 2 :" + person2.getAge());
        // 2. Demo generic method
        String mid1 = DemoMethod.<String>getMiddle("A", "Q","Public");
        System.out.println(mid1);

        Integer mid2 = DemoMethod.getMiddle(1,2,3);
        System.out.println(mid2);
        // 3. Demo Upper Bounded Wildcard
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3)) ;
        List<Double> list2 = new ArrayList<>(Arrays.asList(2.3,4.5,6.7));
        List<String> list3 = new ArrayList<>(Arrays.asList("A","B","c"));
        System.out.println("Sum of Interger:" + DemoUpperBound.sumNumbers(list1));
        System.out.println("Sum of Double:" + DemoUpperBound.sumNumbers(list2));
        // System.out.println("Sum of String:" + DemoUpperBound.sumNumbers(list3)); // Bi báo lỗi vì kiểu String không phải là con của Number

        // 4. Demo Lower Bouded Wildcard
        List<Number> list4 = new ArrayList<>();
        DemoLowerBound.addIntergers(list4);
        List<Object> list5 = new ArrayList<>();
        DemoLowerBound.addIntergers(list5);
        List<Double> list6 = new ArrayList<>();
        //DemoLowerBound.addIntergers(list6); // Báo lỗi do double không phải là suppertype của Integer
    }
}