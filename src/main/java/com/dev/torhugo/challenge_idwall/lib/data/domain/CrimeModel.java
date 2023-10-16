package com.dev.torhugo.challenge_idwall.lib.data.domain;

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
@Table(name = "crime_tb")
public class CrimeModel extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crime_id")
    private Long crimeId;
    private Long personId;
    private String crimeDescription;
}
