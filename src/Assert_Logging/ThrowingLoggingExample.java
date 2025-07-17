import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowingLoggingExample{
    private static final Logger logger = Logger.getLogger(ThrowingLoggingExample.class.getName());
    static void method() throws Exception{
        Exception ex = new Exception("File khong ton tai");

        logger.throwing("ThrowingLoggingExample","method",ex);
        throw ex;
    }
    public static void main(String[] args)
    {
        logger.setLevel(Level.ALL);
        Logger rootLogger = Logger.getLogger("");
        rootLogger.getHandlers()[0].setLevel(Level.ALL); // cho phep console in moi log
        try{
            method();
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE,"loi khi doc file ",e );
        }
    }
}