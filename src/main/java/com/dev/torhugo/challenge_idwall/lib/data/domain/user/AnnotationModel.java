package com.dev.torhugo.challenge_idwall.lib.data.domain.user;

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
@Table(name = "annotation_tb")
public class AnnotationModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "annotation_id")
    private Long annotationId;

    private Long userId;
    private String cardName;
    private String cardAddress;
    private String cardDescription;
    private String cardEmail;
    private String cardPhone;
    private Boolean inActive;
}
