package com.example.MNPETR.Service;

import com.example.MNPETR.Model.User;

public interface INotificationService {
    void createNotification(String content, User user);
}
