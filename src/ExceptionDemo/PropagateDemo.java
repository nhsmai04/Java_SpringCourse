import java.io.*;
public class PropagateDemo{
    public static void method3() throws IOException{
        throw new IOException();
    }
    public static void method2() throws IOException{
        method3();
    }
    public static void method1(){
        try{
            method2();
        }catch(IOException e){
            System.out.println("Loi he thong");
        }
    }
}