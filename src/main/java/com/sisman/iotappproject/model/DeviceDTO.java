package com.sisman.iotappproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
{
"brand": "my new brand",
"customId": "sn:111111111111111",
"deviceProfileId": 53,
"locationId": 1,
"model": "Heat-29",
"name": "Farm Heat Sensor",
"servedAppId": 6,
"vendorId": 1,
"status": "active"
}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    private String brand;
    private String customId;
    private int deviceProfileId;
    private int locationId;
    private String model;
    private String name;
    private int servedAppId;
    private int vendorId;
    private String status;

}
