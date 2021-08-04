package com.sisman.iotappproject.controller;

import com.sisman.iotappproject.model.AlarmDTO;
import com.sisman.iotappproject.model.DeviceDTO;
import com.sisman.iotappproject.model.UserDTO;
import com.sisman.iotappproject.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private DeviceDataResource deviceDataResource;

    @Autowired
    private LoginResource loginResource;

    @Autowired
    private HomeResource homeResource;

    @Autowired
    private AlarmResource alarmResource;

    @Autowired
    private DeviceResource deviceResource;

    @Value("${temperatureCustomId}") private String temperatureCustomId;
    @Value("${rainCustomId}") private String rainCustomId;
    @Value("${windCustomId}") private String windCustomId;
    @Value("${humidityCustomId}") private String humidityCustomId;
    @Value("${irrigationCustomId}") private String irrigationCustomId;
    @Value("${cameraCustomId}") private String cameraCustomId;


    @PostMapping("/api/login")
    public String login(@RequestBody UserDTO userDTO){

        return loginResource.loginWithCredentials(userDTO.getUsername(), userDTO.getPassword());

    }

    @GetMapping("/api/home")
    public String getHomePage() throws Exception {

        return homeResource.getHomePage(loginResource.getXToken());

    }

    @GetMapping("/api/temperature")
    public String getTemperatureData() throws Exception {

        return deviceDataResource.getDeviceData(temperatureCustomId, loginResource.getXToken());

    }

    @PostMapping("/api/temperature/set-alarm")
    public String setTemperatureAlarm(@RequestBody AlarmDTO alarmDTO){

        return alarmResource.setAlarm(loginResource.getXToken(), alarmDTO.getDevicePropertyId(), alarmDTO.getMaxThreshold(),
                alarmDTO.getMinThreshold(), alarmDTO.getName(), alarmDTO.getPriority(), alarmDTO.getStartHour(), alarmDTO.getVersion());

    }


    @GetMapping("/api/wind")
    public String getWindData() throws Exception {

        return deviceDataResource.getDeviceData(windCustomId, loginResource.getXToken());

    }

    @PostMapping("/api/wind/set-alarm")
    public String setWindAlarm(@RequestBody AlarmDTO alarmDTO){

        return alarmResource.setAlarm(loginResource.getXToken(), alarmDTO.getDevicePropertyId(), alarmDTO.getMaxThreshold(),
                alarmDTO.getMinThreshold(), alarmDTO.getName(), alarmDTO.getPriority(), alarmDTO.getStartHour(), alarmDTO.getVersion());

    }

    @GetMapping("/api/humidity")
    public String getHumidityData() throws Exception {

        return deviceDataResource.getDeviceData(humidityCustomId, loginResource.getXToken());

    }

    @PostMapping("/api/humidity/set-alarm")
    public String setHumidityAlarm(@RequestBody AlarmDTO alarmDTO){

        return alarmResource.setAlarm(loginResource.getXToken(), alarmDTO.getDevicePropertyId(), alarmDTO.getMaxThreshold(),
                alarmDTO.getMinThreshold(), alarmDTO.getName(), alarmDTO.getPriority(), alarmDTO.getStartHour(), alarmDTO.getVersion());

    }

    @GetMapping("/api/rain")
    public String getRainData() throws Exception {

        return deviceDataResource.getDeviceData(rainCustomId, loginResource.getXToken());

    }

    @PostMapping("/api/rain/set-alarm")
    public String setRainAlarm(@RequestBody AlarmDTO alarmDTO){

        return alarmResource.setAlarm(loginResource.getXToken(), alarmDTO.getDevicePropertyId(), alarmDTO.getMaxThreshold(),
                alarmDTO.getMinThreshold(), alarmDTO.getName(), alarmDTO.getPriority(), alarmDTO.getStartHour(), alarmDTO.getVersion());

    }

    @GetMapping("/api/irrigation")
    public String getIrrigationData() throws Exception {

        return deviceDataResource.getDeviceData(irrigationCustomId, loginResource.getXToken());

    }

    @PostMapping("/api/create-device")
    public String createDevice(@RequestBody DeviceDTO deviceDTO){

        return deviceResource.create(loginResource.getXToken(), deviceDTO.getBrand(), deviceDTO.getCustomId(),
                deviceDTO.getDeviceProfileId(), deviceDTO.getLocationId(),deviceDTO.getModel(), deviceDTO.getName(),
                deviceDTO.getServedAppId(),deviceDTO.getVendorId(), deviceDTO.getStatus());

    }

}
