package lab2_1;

public class
HappyBirthdayMailGenerator implements MailGenerator {

    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClient().getName();
    }
}
