import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService
{
    void sendMessage();
}
class SMSMessagingService implements MessagingService
{
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the mobile number:");
        long mobileNumber = scanner.nextLong();
        System.out.println("Enter the message:");
        String message = scanner.next();
        String regex = "[6-9]\\d{9}";
        String number=String.valueOf(mobileNumber);
        if(number.matches(regex)) {
            System.out.println("Mobile Number:" +mobileNumber);
            System.out.println("Message: " + message);
            System.out.println("Message sent successfully through SMS");
        }
        else
        {
            System.out.println("Enter a valid mobile number");
        }
    }
}
class EmailMessagingService implements MessagingService
{
    @Override
    public void sendMessage()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Email address:");
        String emailAddress = scanner.next();
        System.out.println("Enter the subject:");
        String subject=scanner.next();
        System.out.println("Enter the message:");
        String message = scanner.next();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
        if(emailAddress.matches(regex))
        {
            System.out.println("Email: "+emailAddress);
            System.out.println("Subject: "+subject);
            System.out.println("Message: "+message);
            System.out.println("Message sent successfully through E-Mail");
        }
        else
        {
            System.out.println("Enter a valid E-mail");
        }
    }
}
class WhatsappMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the mobile number:");
        long mobileNumber = scanner.nextLong();
        System.out.println("Enter the message:");
        String message = scanner.next();
        System.out.println("Enter 1 if you are a existing user or 0 if you are not a user");
        int whatsappUser=scanner.nextInt();
        String number=String.valueOf(mobileNumber);
        if(whatsappUser==1) {
            if (number.matches("[6-9]\\d{9}")) {
                System.out.println("Sent To : " + number);
                System.out.println("Message : " + message);
            }
        }
        else if (whatsappUser==0){
            System.out.println("User does not exist in Whatasapp");
        }
        else{
            System.out.println("Invalid number");
        }
    }
}
public class MessengerApp
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("Enter the mode of service -- 1.SMS 2.E-mail 3.Whatsapp 4.Exit");
            int modeOfMessage = scanner.nextInt();
            if (modeOfMessage==1) {
                MessagingService smsMessagingService = new SMSMessagingService();
                smsMessagingService.sendMessage();
            }
            else if (modeOfMessage==2) {
                MessagingService emailMessagingService = new EmailMessagingService();
                emailMessagingService.sendMessage();
            }
            else if (modeOfMessage==3) {
                MessagingService whatsappMessagingService = new WhatsappMessagingService();
                whatsappMessagingService.sendMessage();
            }
            else if (modeOfMessage==4) {
                break;
            } else {
                System.out.println("Invalid Mode");
            }
        }
        while (true);

    }
}
