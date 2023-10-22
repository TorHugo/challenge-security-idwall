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
@Table(name = "alias_tb")
public class AliasModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alias_id")
    private Long aliasId;
    private Long personId;
    private String aliasDescription;
}
