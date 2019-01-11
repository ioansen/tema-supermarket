package events;

public interface Event {

    void fire();

    static boolean figureOutItemList(String value){
        if ( "ShoppingCart".equals(value)) {
            return true;
        }
        if ( "WishList".equals(value)) {
            return false;
        }

        throw new AssertionError("not a recognizable item list");
    }
}
