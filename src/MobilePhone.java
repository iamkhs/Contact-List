import java.util.HashMap;

public class MobilePhone {

    private final HashMap<String, String> myContacts;
    public MobilePhone(){
        myContacts = new HashMap<>();
    }

    public void addNewContact(String name, String number){
        if (!findContact(name) && !this.myContacts.containsValue(number)){
            this.myContacts.put(name,number);
            System.out.println(name +" added successfully");
        }
        else System.out.println(name+ " already available on your contact list");
    }

    public void removeContact(String name){
        if (findContact(name)){
            this.myContacts.remove(name);
            System.out.println(name+" contact remove successfully.");
        }
        else System.out.println(name + " not found on your contact list.");
    }

    public void updateContact(String name, String oldNumber, String newNumber){
        if (findContact(name) && this.myContacts.containsValue(oldNumber)) {
            if (!this.myContacts.containsValue(newNumber)) {
                this.myContacts.replace(name,oldNumber,newNumber);
                System.out.println("old number "+oldNumber + " updated with new number " + newNumber);
            } else System.out.println("cannot update. " + newNumber + " is already available on your contact list");
        } else System.out.println(name+" or "+ oldNumber + " contact not found on your contact list");
    }

    public void queryContact(String name){
        if (this.myContacts.containsKey(name)){
            System.out.println("Name : "+name);
            System.out.println("Number : "+this.myContacts.get(name));
        }
        else System.out.println(name+" not found on your contact list.");
    }

    public void printContactList(){
        int i = 1;
        if (!myContacts.isEmpty()){
            System.out.println("You have "+ myContacts.size() +" contacts on your contact list.");
            for (String key : myContacts.keySet()){
                System.out.println(i+". "+key + " -> " +myContacts.get(key));
                i++;
            }
        }
        else System.out.println("0 contacts on your contact list");
    }

    private boolean findContact(String name){
        return myContacts.containsKey(name);
    }
}
