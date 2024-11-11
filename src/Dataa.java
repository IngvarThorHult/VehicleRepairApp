public class Dataa {
    private final String location;
    private final String name;
    private final String repairCost;
    private final String rate;

    public Dataa(String location, String name, String repairCost, String rate) {
        this.location = location;
        this.name = name;
        this.repairCost = repairCost;
        this.rate = rate;
    }




    public String getLocation() { return location; }
    public String getName() { return name; }
    public String getRepairCost() { return repairCost; }
    public String getRate() { return rate; }
}


}
