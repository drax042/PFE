package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Notification;
import com.example.MNPETR.Model.User;
import com.example.MNPETR.Repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService implements INotificationService {

   @Autowired
   public NotificationRepo notificationRepo;

    @Override
    public void createNotification(String content, User user) {
        Notification notification = new Notification();
        notification.setContenu(content);
        notification.setUser(user);
        notification.setLue(false);
        notificationRepo.save(notification);
    }
}