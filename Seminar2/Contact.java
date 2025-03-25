public class Contact {
    String name;
    String address;
    Contact nextContact;

    public Contact(String name, String address) {
        this.name = name;
        this.address = address;
        this.nextContact = null;
    }
}
