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
@Table(name = "person_tb")
public class PersonModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "criminal_classification")
    private String criminalClassification;

    @Column(name = "dt_publication")
    private String datePublication;

    @Column(name = "person_description")
    private String personDescription;

    @Column(name = "title_of_publication")
    private String titlePublication;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "in_active")
    private Boolean inActive;
}
