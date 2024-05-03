package com.example.devicepredictions.controller;

import com.example.devicepredictions.model.Device;
import com.example.devicepredictions.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.saveDevice(device);
        return ResponseEntity.ok(savedDevice);
    }

    @PostMapping("/predict/{id}")
    public ResponseEntity<Device> predictDevicePrice(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        double predictedPrice = deviceService.predictDevicePrice(device.getSpecifications());
        device.setPredictedPrice(predictedPrice);
        Device updatedDevice = deviceService.saveDevice(device);
        return ResponseEntity.ok(updatedDevice);
    }
}

