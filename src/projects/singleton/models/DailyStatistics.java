package projects.singleton.models;


public class DailyStatistics {

    // Some properties for example
    private int deliveries;
    private int dispatches;
    private double totalDeliveriesWeight;
    private double totalDispatchesWeight;

    // It's important to make the constructor private
    // Note that this constructor is available in nested private classes
    private DailyStatistics() {
    }

    // The main method of our singleton class
    public static DailyStatistics getInstance() {
        return InstanceHolder.INSTANCE;
    }

    // This class initializes only once even in multithreaded systems
    private static class InstanceHolder {
        private final static DailyStatistics INSTANCE = new DailyStatistics();
    }

    // Getters
    public int getDeliveries() {
        return this.deliveries;
    }

    public int getDispatches() {
        return this.dispatches;
    }

    public double getTotalDeliveriesWeight() {
        return totalDeliveriesWeight;
    }

    public double getTotalDispatchesWeight() {
        return totalDispatchesWeight;
    }

    // Setters
    public void setDeliveries(int deliveries) {
        this.deliveries = deliveries;
    }

    public void setDispatches(int dispatches) {
        this.dispatches = dispatches;
    }

    public void setTotalDispatchesWeight(double totalDispatchesWeight) {
        this.totalDispatchesWeight = totalDispatchesWeight;
    }

    public void setTotalDeliveriesWeight(double totalDeliveriesWeight) {
        this.totalDeliveriesWeight = totalDeliveriesWeight;
    }

    // Methods
    public void incrementDeliveriesAmount() {
        this.deliveries += 1;
    }

    public void incrementDispatchesAmount() {
        this.dispatches += 1;
    }

    public void increaseWeightOfDeliveries(double weight) {
        this.totalDeliveriesWeight += weight;
    }

    public void increaseWeightOfDispatches(double weight) {
        this.totalDispatchesWeight += weight;
    }

    // Reset the statistics
    public void reset() {
        this.deliveries = 0;
        this.dispatches = 0;
        this.totalDeliveriesWeight = 0.0;
        this.totalDispatchesWeight = 0.0;
        System.out.println("\nStatistics is empty for now!\n");
    }

    public String getInfo() {
        String info = "========================== OVERALL ===========================\n"
                + " + Total deliveries: " + this.deliveries + ";\n"
                + " + Total dispatches: " + this.dispatches + ";\n"
                + " + Deliveries weight: " + this.totalDeliveriesWeight + ";\n"
                + " + Dispatches weight: " + this.totalDispatchesWeight + ";\n"
                + "================================================================\n";

        return info;
    }

}
