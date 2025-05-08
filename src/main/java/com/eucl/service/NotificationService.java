package com.eucl.service;

import com.eucl.repository.NotificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eucl.model.Notification;
import com.eucl.model.User;
import java.util.List;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    public void createNotification(String message, User user) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setUser(user);
        notificationRepository.save(notification);
    }
    public List<Notification> getByUserId(Long userId){
        return notificationRepository.findByUserId(userId);
    }

}