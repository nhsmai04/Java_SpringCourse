import java.util.*;

public class SuppressedExample{
    public static void main(String[] args)
    {
        try(MyResource res = new MyResource())
        {
         throw new RuntimeException("LOI CHINH TRONG TRY");
        }
        catch(Exception e)
        {
            System.out.println("Bat loi:" + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()){
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }

    public static class MyResource implements AutoCloseable
    {
        @Override
        public void close() throws Exception{
            throw new Exception("Loi khi dong tai nguyen");
        }
    }
}