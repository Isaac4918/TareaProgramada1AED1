/*package sample;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Telefono {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "AC9ed937743a17e1e7b07bb69beece4f41";
    public static final String AUTH_TOKEN = "2af50b9caee26471d7c3ebea67224ca9";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+50687140079"),
                new com.twilio.type.PhoneNumber("+50687140079"),
                "This is the ship that made the Kessel Run in fourteen parsecs?")
                .create();

        System.out.println(message.getSid());
    }
}*/