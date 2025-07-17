import java.io.*;
public class Validator {
    public void Checkage(int age) throws UserException{
        if(age < 18)
            throw new UserException("Bạn chưa đủ 18 tuổi để bỏ phiếu.");
        else {
            System.out.println("Tuoi hop le");
        }
    }
}