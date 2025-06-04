package Controller;

import Model.EmailSender;

public class EmailController {
    public static boolean sendVerificationCode(String toEmail) {
        String subject = "Your Verification Code";
        String code = String.valueOf((int)(Math.random() * 9000) + 1000); // 4-digit code
        String message = "Your code is " + code;

        return EmailSender.sendEmail(toEmail, subject, message);
    }
}