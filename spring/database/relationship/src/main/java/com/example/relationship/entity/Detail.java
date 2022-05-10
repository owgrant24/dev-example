package com.example.relationship.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "series")
    private String series;
    @Column(name = "number")
    private String number;
//    for Bi-directional
//    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)
//    private Person person;
}
