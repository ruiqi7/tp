package seedu.nutrigoals.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.nutrigoals.model.tag.Tag;

class CalorieTest {

    @Test
    public void isValidCalorie() {
        assertTrue(Calorie.isValidCalorie("0"));
        assertTrue(Calorie.isValidCalorie("1"));
        assertTrue(Calorie.isValidCalorie("100"));
        assertFalse(Calorie.isValidCalorie(Long.MAX_VALUE + ""));
        assertFalse(Calorie.isValidCalorie("-1"));
        assertFalse(Calorie.isValidCalorie("1.0"));
    }

    @Test
    public void getCalorieValue() {
        assertEquals(new Calorie("2000").getCalorieValue(), 2000);
        assertEquals(new Calorie("0").getCalorieValue(), 0);
    }

    @Test
    public void testEquals() {
        assertEquals(new Calorie("1000"), new Calorie("1000"));
        assertEquals(new Calorie("100"), new Calorie("100"));
        assertNotEquals(new Calorie("100"), new Calorie("10"));
        assertFalse(new Calorie().equals(new Tag("breakfast")));
        assertFalse(new Calorie().equals(null));
    }

    @Test
    public void calculateCalorieDifference_success() {
        int expectedCalorie = 100;
        Calorie calorie1 = new Calorie("250");
        Calorie calorie2 = new Calorie("150");
        assertEquals(expectedCalorie, calorie1.calculateDifference(calorie2));

        expectedCalorie = -100;
        assertEquals(expectedCalorie, calorie2.calculateDifference(calorie1));
    }

    @Test
    public void addCalorie_success() {
        Calorie expectedCalorie = new Calorie("300");
        Calorie calorie1 = new Calorie("160");
        Calorie calorie2 = new Calorie("140");
        assertEquals(expectedCalorie, calorie1.addCalorie(calorie2));
    }
}
