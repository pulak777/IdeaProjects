public class Main {

    public static void main(String[] args) {
        contactManager myContactsManager = new contactManager();
        Contact friendJames = new Contact();
        friendJames.name = "James";
        friendJames.phoneNumber = "0012223333";
        myContactsManager.addContact(friendJames);
        Contact friendCezanne = new Contact();
        friendCezanne.name = "Cezanne";
        friendCezanne.phoneNumber = "987654321";
        myContactsManager.addContact(friendCezanne);
        Contact friendJessica = new Contact();
        friendJessica.name = "Jessica";
        friendJessica.phoneNumber = "5554440001";
        myContactsManager.addContact(friendJessica);

        Contact result = myContactsManager.searchContact("Cezanne");
        System.out.println(result.phoneNumber);

    }
}
class contactManager{
    Contact [] myFriends;
    int friendsCount;

    contactManager(){
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }

    void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
    }
    Contact searchContact(String searchName){
        for(int i = 0; i < friendsCount; i++){
            if(myFriends[i].name.equals(searchName)){
                return  myFriends[i];
            }
        }
        return null;
    }
}
class Contact{
    String name;
    String phoneNumber;
}

