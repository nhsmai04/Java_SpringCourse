import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggingExample{
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());
    public static void main(String[] args)
    {
        logger.info("Start");

        int x = 10 ;
        int y = 0;
        try{
            int z = x/y;
        }
        catch (Exception e){
            logger.log(Level.SEVERE,"Loi chia cho 0",e);
        }
        logger.warning("Đây là cảnh báo.");
        logger.fine("Thông tin chi tiết (DEBUG).");
        logger.info("Ứng dụng kết thúc.");
    }
}