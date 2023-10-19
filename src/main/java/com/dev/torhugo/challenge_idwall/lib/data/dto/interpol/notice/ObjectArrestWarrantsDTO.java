package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectArrestWarrantsDTO {
    @JsonProperty("issuing_country_id")
    private String issuingCountry;
    private String charge;
}
