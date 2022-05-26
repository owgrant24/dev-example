import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDataFormatter {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate now = LocalDate.now();
        String text = now.format(formatter);
        System.out.println(text);
    }
}
