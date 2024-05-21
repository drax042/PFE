package com.example.MNPETR.Service;

import com.example.MNPETR.Repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;
}
