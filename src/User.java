import java.util.Map;

public abstract class User {
    private String name;

    public User(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void purchaseItems(VendingMachine machine, Map<String, Integer> itemsToPurchase) {
        machine.purchaseItem(itemsToPurchase, this);
    }
    public void viewItems(VendingMachine machine){
        machine.viewItems(this);
    }
}
