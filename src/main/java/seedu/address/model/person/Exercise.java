package seedu.address.model.person;

import java.util.Objects;


import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;


public class Exercise {
    
    // Identity fields
    private final Name name;
    private final Description description;
    private final Calorie calorie;
    private final Date date;

    public Exercise(Name name, Description description, Date date, Calorie calorie) {
        requireAllNonNull(name, description, date, calorie);
        
        this.name = name;
        this.description = description;
        this.date = date;
        this.calorie = calorie;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Calorie getCalories() {
        return calorie;
    }


    public boolean isSameExercise(Exercise otherExercise) {
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, description, calorie, date);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Name: ")
                .append(getName())
                .append(" Description: ")
                .append(getDescription())
                .append(" Date: ")
                .append(getDate())
                .append(" Calories: ")
                .append(getCalories());
        
        return builder.toString();
    }
}
