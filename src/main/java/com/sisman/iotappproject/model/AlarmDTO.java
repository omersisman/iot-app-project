package com.sisman.iotappproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmDTO {

    private int devicePropertyId;

    private int maxThreshold;

    private int minThreshold;

    private String name;

    private int priority;

    private int startHour;

    private int version;

}
