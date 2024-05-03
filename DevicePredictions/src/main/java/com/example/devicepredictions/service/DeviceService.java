package com.example.devicepredictions.service;

import com.example.devicepredictions.model.Device;
import com.example.devicepredictions.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found!"));
    }

    @Transactional
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Transactional
    public Device updateDevicePrice(Long deviceId, double price) {
        Device device = getDeviceById(deviceId);
        device.setPredictedPrice(price);
        return saveDevice(device); // save updated price
    }

    public double predictDevicePrice(String specs) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5000/predict"; // ensure to have the correct URL
        Double predictedPrice = restTemplate.postForObject(url, specs, Double.class);
        return predictedPrice;
    }
}

