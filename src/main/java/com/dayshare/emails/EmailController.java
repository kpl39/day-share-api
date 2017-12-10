package com.dayshare.emails;

import com.dayshare.parent.ParentRepository;
import com.dayshare.utils.email.EmailService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ParentRepository parentRepo;

    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    public ResponseEntity<String> sendEmail(@RequestBody String emailInfo) {
        Gson gson = new Gson();
        Email email = gson.fromJson(emailInfo, Email.class);

        email.setRecipient(parentRepo.findOne(email.getRecipientId()));
        email.setSender(parentRepo.findOne(email.getSenderId()));


        String recipient = emailService.sendEmail(email);

        return new ResponseEntity<String>(recipient, HttpStatus.OK);
    }


}
