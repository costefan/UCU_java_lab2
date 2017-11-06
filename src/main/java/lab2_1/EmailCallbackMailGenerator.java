package lab2_1;

public class EmailCallbackMailGenerator implements lab2_1.MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "<html> don't call use we call you</html>";
    }
}
