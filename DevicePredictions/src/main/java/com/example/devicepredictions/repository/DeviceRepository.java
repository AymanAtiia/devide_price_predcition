package com.example.devicepredictions.repository;

import com.example.devicepredictions.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}

