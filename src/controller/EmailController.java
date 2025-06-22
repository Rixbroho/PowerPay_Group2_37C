package Controller;

import Model.EmailSender;
import java.util.Map;
import java.util.HashMap;


public class EmailController {
    private static Map<String, String> verificationCodes = new HashMap<>();
    
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
                       + "The Support Team(PowerPay)";

        boolean sent = EmailSender.sendEmail(toEmail, subject, message);

        if (sent) {
            verificationCodes.put(toEmail, code);  // Store code for the email
        }
        return EmailSender.sendEmail(toEmail, subject, message);
    }
    public static boolean verifyCode(String email, String inputCode) {
        String correctCode = verificationCodes.get(email);
        return correctCode != null && correctCode.equals(inputCode);
    }

    public static void clearCode(String email) {
        verificationCodes.remove(email);
    }
}

