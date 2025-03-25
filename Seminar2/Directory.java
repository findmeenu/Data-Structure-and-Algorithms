public class Directory {
    private Contact head;


    public Directory() {
        head = null;
    }

    // Add a contact to the list
    public void addContact(String name, String address) {
        Contact newContact = new Contact(name, address);
        // if list is empty, add new contact as head
        if (head == null) {
            head = newContact;
            //temp is not a duplicate of head:

            //temp is just a reference to the same object as head.
            //When temp.nextContact is updated, it directly affects the object 
            //head is pointing to because both temp and head refer to the same memory.
        } else {
            Contact temp = head;
            while (temp.nextContact != null) {
                temp = temp.nextContact; // Traverse to the end of the list
            }
            temp.nextContact = newContact; // Add the new contact at the end
        }
    }

    // Remove a contact
    public void removeContact(String name) {
        if (head == null) {
            System.out.println("Address book is empty.");
            return;
        }

        // If the head node = contact
        if (head.name.equals(name)) {
            head = head.nextContact; // Move head to the next contact
            return;
        }

        Contact temp = head;
        while (temp.nextContact != null && !temp.nextContact.name.equals(name)) {
            temp = temp.nextContact; // Traverse the list to find the contact
        }

        if (temp.nextContact == null) {
            System.out.println("Contact not found.");
        } else {
            temp.nextContact = temp.nextContact.nextContact; // Remove the contact by skipping it
        }
    }

    // Get a contact by index
    public Contact getContact(int index) {
        Contact temp = head;
        int currentIndex = 0;

        while (temp != null) {
            if (currentIndex == index) {
                return temp; // Found  contact at given index
            }
            temp = temp.nextContact;
            currentIndex++;
        }

        System.out.println("Contact not found at index " + index);
        return null;
    }

    // Print all contacts
    public void printContacts() {
        if (head == null) {
            System.out.println("Address book is empty.");
            return;
        }

        Contact temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Address: " + temp.address);
            temp = temp.nextContact;
        }
    }
}
