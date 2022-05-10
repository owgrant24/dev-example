package com.example.relationship.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String name;
    private Detail detail;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {
        private Long id;
        private String series;
        private String number;
    }
}
