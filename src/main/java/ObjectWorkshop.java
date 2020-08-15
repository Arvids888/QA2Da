import Model.Contact;

public class ObjectWorkshop {

    public static void main (String[] args) {
        Contact alise = new Contact();
        alise.setFirstName("Alisa");
        alise.setLastName(null);
        alise.setPhoneNumber("112");

        Contact hacker = new Contact("Hacker", "Hackerovichs","02");

        System.out.println(alise.getFirstName() + " " +alise.getLastName() + ": " + alise.getPhoneNumber());
        System.out.println(hacker.getFullInfo());
    }
}
