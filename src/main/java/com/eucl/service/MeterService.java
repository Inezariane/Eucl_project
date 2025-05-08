package com.eucl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eucl.dto.MeterRegisterRequest;
import com.eucl.exception.UserNotFoundException;
import com.eucl.model.Meter;
import com.eucl.utils.MeterUtil;
import com.eucl.model.User;
import com.eucl.repository.MeterRepository;
import com.eucl.repository.UserRepository;

@Service
public class MeterService {
    
    @Autowired
    private MeterRepository meterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;


    public String registerMeter(MeterRegisterRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Meter meter = new Meter();
        meter.setMeterId(MeterUtil.generateMeterNumber());
        meter.setOwner(user);
                
        meterRepository.save(meter);
        notificationService.createNotification("Meter registered successfully", user);
        return "Meter registered successfully!";
    }

    public Optional<Meter> getMeterById(String meterId) {
        return meterRepository.findByMeterId(meterId);
    }
    public List<Meter> getByOwnerId(Long ownerId){
        return meterRepository.findByOwnerId(ownerId);
    }

}
