package com.sparsh.tracker.visit.util;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * @author Prashant Swamy
 * @created on 19/12/2012
 */
@Service
public class NotificationService {

    private static String FROM_EMAIL = "prashant.swamy@nihilent.com";
    private static String SUBJECT_REGISTRATION = "VTSPro:: Employee Registration";
    private static String SUBJECT_RESET_PASSWORD = "VTSPro:: Reset Password";

    @Autowired
    private MailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void sendConfirmationEmail(final Map model) {
        // MimeMessagePreparator preparator = new MimeMessagePreparator() {
        // public void prepare(MimeMessage mimeMessage) throws Exception {
        // MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        // message.setTo((String) model.get("email"));
        // message.setFrom(NotificationService.FROM_EMAIL);
        // message.setSubject(NotificationService.SUBJECT_REGISTRATION);
        //
        // String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "register.vm", model);
        // message.setText(text, true);
        // }
        // };
        // this.mailSender.send(preparator);

        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setFrom(NotificationService.FROM_EMAIL);
        emailMessage.setTo((String) model.get("email"));
        emailMessage.setSubject(NotificationService.SUBJECT_REGISTRATION);

        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "register.vm", model);
        emailMessage.setText(text);
        mailSender.send(emailMessage);
    }

    public void sendResetPasswordEmail(final Map model) {
        // MimeMessagePreparator preparator = new MimeMessagePreparator() {
        // public void prepare(MimeMessage mimeMessage) throws Exception {
        // MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        // message.setTo((String) model.get("email"));
        // message.setFrom(NotificationService.FROM_EMAIL);
        // message.setSubject(NotificationService.SUBJECT_RESET_PASSWORD);
        //
        // String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "resetPassword.vm", model);
        // message.setText(text, true);
        // }
        // };
        // this.mailSender.send(preparator);

        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setFrom(NotificationService.FROM_EMAIL);
        emailMessage.setTo((String) model.get("email"));
        emailMessage.setSubject(NotificationService.SUBJECT_RESET_PASSWORD);

        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "resetPassword.vm", model);
        emailMessage.setText(text);
        mailSender.send(emailMessage);
    }

    /*
     * public void sendConfirmationEmail(final Login login) { MimeMessagePreparator preparator = new MimeMessagePreparator() { public void
     * prepare(MimeMessage mimeMessage) throws Exception { MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
     * message.setTo(login.getEmployee().getEmail()); message.setFrom("prashant.swamy@nihilent.com");
     * message.setSubject("VTSPro: Employee Registeration Details"); Map model = new HashMap(); model.put("login", login); String text =
     * VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "register.vm", model); message.setText(text, true); } };
     * this.mailSender.send(preparator); }
     */
}
