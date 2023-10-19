package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ObjectInterpolResponseNoticeDTO {
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("distinguishing_marks")
    private String distinguishingMarks;
    private String weight;
    private List<String> nationalities;
    @JsonProperty("eyes_colors_id")
    private List<String> eyesColors;
    @JsonProperty("sex_id")
    private String sex;
    @JsonProperty("place_of_birth")
    private String placeOfBirth;
    @JsonProperty("arrest_warrants")
    private List<ObjectArrestWarrantsDTO> arrestWarrants;
    @JsonProperty("country_of_birth_id")
    private String countyOfBirth;
    @JsonProperty("hairs_id")
    private List<String> hair;
    @JsonProperty("languages_spoken_ids")
    private List<String> languagesSpoken;
    private String height;
}
