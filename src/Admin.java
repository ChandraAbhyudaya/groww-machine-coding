import java.util.Map;

public class Admin extends User{
    public Admin(String name){
        super(name);
    }
    public void addItems(VendingMachine machine, Map<String, Integer> itemsToAdd, Map<String, Double> itemPrices){
        machine.addItems(itemsToAdd, itemPrices, this);
    }
    public void toggleMachineState(VendingMachine machine){
        machine.toggleMachineState(this);
    }
}
