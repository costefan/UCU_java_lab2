package lab2_1;


import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender2 {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    public MailSender2() throws IllegalAccessException, InstantiationException {
        Reflections scanner = new Reflections("lab2_1");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        int mailTypeIndex = 1;
        for (Class<? extends MailGenerator> clazz: classes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                map.put(mailTypeIndex, clazz.newInstance());
            }
            mailTypeIndex++;
        }
    }

    public void sendMail(MailInfo mailInfo) {

        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
        if (mailGenerator == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);


    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }


}
