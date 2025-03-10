import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static final Integer LOW_ITEM_COUNT_THRESHOLD = 5;
    private Map<String, Item> inventory;
    private boolean isMachineOn;

    public VendingMachine() {
        inventory = new HashMap<>();
        isMachineOn = true;
    }


    public synchronized void addItems(Map<String, Integer> itemsToAdd, Map<String, Double> itemPrices, Admin admin) {
        for (Map.Entry<String, Integer> entry : itemsToAdd.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            double price = itemPrices.getOrDefault(itemName, 10.00);

            if (inventory.containsKey(itemName)) {
                Item item = inventory.get(itemName);
                item.setQuantity(item.getQuantity() + quantity);
                item.setPrice(price);

            } else {
                inventory.put(itemName, new Item(itemName, quantity, price));
            }
            System.out.println("Added " + quantity + " of " + itemName + " at price rs. " + price + " by " + admin.getName());
            checkLowStockAlert(itemName);
        }
    }

    public synchronized void purchaseItem(Map<String, Integer> itemsToPurchase, User user) {
        if (!isMachineOn) {
            System.out.println("Vending Machine is off. Please come later.");
            return;
        }
        for (Map.Entry<String, Integer> entry : itemsToPurchase.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            if (inventory.containsKey(itemName)) {
                Item item = inventory.get(itemName);
                if (item.getQuantity() >= quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                    System.out.println("Purchased " + quantity + " " + itemName + " item(s) by " + user.getName());
                    checkLowStockAlert(itemName);
                } else {
                    System.out.println("Insufficient stock for " + itemName + ". Available quantity: " + item.getQuantity());
                }
            } else {
                System.out.println(itemName + " is not available");
            }
        }
    }

    public void viewItems(User user) {
        if (!isMachineOn) {
            System.out.println("Vending machine is off.");
            return;
        }
        System.out.println("Items in vending machine: ");
        for (Item item : inventory.values()) {
            System.out.println(item);
        }
    }

    public void toggleMachineState(Admin admin) {
        isMachineOn = !isMachineOn;
        System.out.println("Vending machine is now " + (isMachineOn ? "on" : "off") + " by " + admin.getName());
    }

    private void checkLowStockAlert(String itemName) {
        Item item = inventory.get(itemName);
        if (item != null && item.getQuantity() < LOW_ITEM_COUNT_THRESHOLD) {
            System.out.println("Alert for low stock of " + itemName + ". Current quantity is " + item.getQuantity());
        }
    }
}
// one assumption that by initially before any purchase made will there be more than 5 items
// did not go ahead with same method for add and purchase because it breaks SRP


/*

Multi lane bowling arena management software.

Users should be able to play game

User {
	String userId;
	Int phoneNo;

}

Lane {
	laneId;
laneStastus(OCCUPIED, EMPTY);

assginLane()
getAvailableLanes()

boolean


}

Booking {
	User userId;
	List<String> players;
	laneId;
	arena;

}


Arena {
	arenaId;
List<Lane> lanes;
Int pricePerUser;

geAllLanes(){

list<lanes>	}
}


User Table

userID varchar pk
phone No INT @non null & unique



Lane

Lane_id string  varcahr Pk
Lane_status ENUM(ASSIGNED, EMPTY)

Arena

Arena_id varcahr PK
Price_per_user

Booking

bookingId varchar PK
userId Varcahr FK
laneID varcahr FK
areanId Varchar FK
createdAt


Arena lanes

Arend id varchar
laneId varchar

primary_key(arenaId, laneID) compositeKey



registerUser(phoneNo);
Response userId;
Return userId(if user exists)


ListArena(){

}

booking(userID, arenaId, list<String> players)

Response bookingId, userID, arenaId, list<String> players, booked

Q<User>

Booking Id(){
getAll
getAvailable()
Assign laneS(userID);
Return booking Id;



if(getAvailable.size()){
	q.add(userId);
	assginLane()
	q.remove
}



Least recent table

Pending booking db


Booking got stored → sql → (Scorer lanes empty(list<lane>)) → assign lanes → booking confirmed


 */
