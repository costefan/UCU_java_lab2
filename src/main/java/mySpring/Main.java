package mySpring;


public class Main {
    public static void main(String[] args) {
        IRobot iRobot = ObjectFactory.getInstance().addConfigurators().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(iRobot.getVersion());
    }
}
