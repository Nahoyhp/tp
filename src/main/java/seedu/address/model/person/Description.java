package seedu.address.model.person;

public class Description {
    public final String value;

    public Description(String val) {
        this.value = val;
    }

    public static boolean isValidDescription(String val) {
        return true;
    }
    
}
