package Controller;

import Model.EmailSender;

public class EmailController {
    public static boolean sendVerificationCode(String toEmail) {
        String subject = "Your Verification Code";
        String code = String.valueOf((int)(Math.random() * 9000) + 1000); // 4-digit code
        String message = """
                         Dear User,
                         
                         Thank you for using our service.
                         Your verification code is: """ + code + "\n\n"
                       + "Please enter this code to complete your verification process.\n\n"
                       + "If you did not request this code, please ignore this message.\n\n"
                       + "Best regards,\n"
                       + "The Support Team";

        return EmailSender.sendEmail(toEmail, subject, message);
    }
}