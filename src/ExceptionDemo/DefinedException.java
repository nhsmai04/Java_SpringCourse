import java.io.*;





public class DefinedException{
    public static void mainUserDefined()
    {
        int age = 16;
        Validator temp1 = new Validator();
        try
        {
            temp1.Checkage(age);
        }
        catch (UserException e)
        {
            System.out.println("Loi xay ra:" + e.getMessage());
        }
    }
}