package com.example.relationship.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    private String name;
    private Detail detail;
    private List<Car> cars;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {

        private String series;
        private String number;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Car {

        private String brand;
        private String model;
    }
}
