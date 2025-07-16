import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
public record VehicleOwner(String cmnd, String name, String email) {
    public VehicleOwner {
        if (cmnd == null || name == null || email == null) {
            throw new IllegalArgumentException("Thông tin không được để trống.");
        }

        if (!cmnd.matches("\\d{12}")) {
            throw new IllegalArgumentException("CMND phải gồm đúng 12 chữ số.");
        }

        // Kiểm tra định dạng email
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email không đúng định dạng.");
        }
    }

    private static boolean isValidEmail(String email) {
        // Regex kiểm tra đơn giản
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
