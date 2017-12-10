package com.dayshare.utils.email;

import com.dayshare.emails.Email;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    public String sendEmail(Email email);
}
