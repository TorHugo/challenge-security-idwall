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
@Table(name = "marks_tb")
public class MarksModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marks_id")
    private Long marksId;
    private Long personId;
    private String marksDescription;
}
