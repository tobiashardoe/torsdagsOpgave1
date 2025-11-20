package code;

public class Vare {
    private String id;
    private String name;
    private String priceDate;
    private double price;
    private boolean isBudgetBrand;
    private double quantity;
    private String unit;
    private boolean isWeighted;
    private boolean isBio;
    private boolean isAvailable;


    public Vare(String[] cols) {
        this.id = cols[0];
        this.name = cols[1];
        this.priceDate = cols[2];
        this.price = Double.parseDouble(cols[3]);
        this.isBudgetBrand = Boolean.parseBoolean(cols[4]);
        this.quantity = Double.parseDouble(cols[5]);
        this.unit = cols[6];
        this.isWeighted = Boolean.parseBoolean(cols[7]);
        this.isBio = Boolean.parseBoolean(cols[8]);
        this.isAvailable = Boolean.parseBoolean(cols[9]);
    }

    // getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

