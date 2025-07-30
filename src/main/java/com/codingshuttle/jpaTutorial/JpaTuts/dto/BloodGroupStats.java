package com.codingshuttle.jpaTutorial.JpaTuts.dto;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.type.BloodGroup;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroup bloodGroupType;
    private final Long count;
}
