import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestOptional {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class City {

        private String name;
        private String yearOfFoundation;

        public String getUpperName() {
            return name.toUpperCase();
        }
    }

    private List<City> cities = List.of(new City("Санкт-Петербург", "1703"),
            new City("Красноярск", "1800"));


    public static void main(String[] args) {

        TestOptional testOptional = new TestOptional();
        String name = testOptional.getCities().stream()
                .filter(city -> city.getYearOfFoundation().equals("1700"))
                .findFirst()
                .map(City::getUpperName)
                .orElse(null);

        System.out.println(name);
    }
}
