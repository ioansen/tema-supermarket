package events;

public class GenericEvent {

    private final int itemId;
    private final String whichList;
    private final String customerName;
    private final int depId;
    private final double itemPrice;
    private final String itemName;

    private GenericEvent(Builder builder){
        this.itemId = builder.itemId;
        this.whichList = builder.whichList;
        this.customerName = builder.customerName;
        this.depId = builder.depId;
        this.itemPrice = builder.itemPrice;
        this.itemName = builder.itemName;
    }

    public static class Builder {

        private int itemId;
        private String whichList;
        private String customerName;
        private int depId;
        private double itemPrice;
        private String itemName;

        public Builder itemId(int itemId){
            this.itemId = itemId;
            return this;
        }

        public Builder whichList(String whichList){
            this.whichList = whichList;
            return this;
        }

        public Builder customerName(String customerName){
            this.customerName = customerName;
            return this;
        }

        public Builder depId(int depId){
            this.depId = depId;
            return this;
        }

        public Builder itemPrice(double itemPrice){
            this.itemPrice = itemPrice;
            return this;
        }

        public Builder itemName(String itemName){
            this.itemName = itemName;
            return this;
        }

        public GenericEvent build(){
            return new GenericEvent(this);
        }
    }

    public int getItemId() {
        return itemId;
    }

    public String getWhichList() {
        return whichList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getDepId() {
        return depId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }


}
