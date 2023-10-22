package com.dev.torhugo.challenge_idwall.lib.data.domain.service;

import com.dev.torhugo.challenge_idwall.lib.data.domain.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "characteristic_tb")
public class CharacteristicModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Long characteristicId;
    private Long personId;
    private String ageRange;
    private String birthPlace;
    private String eyeColor;
    private String ethnicity;
    private String height;
    private String weight;
    private String nationality;
    private String sex;
}
