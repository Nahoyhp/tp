package seedu.address.model.person;

public class Calorie {
        private final String calorie;

        public Calorie(String calorie) {
            this.calorie = calorie;
        }

        public static boolean isValidCalories(String calorie) {
            return true;
        }
}
