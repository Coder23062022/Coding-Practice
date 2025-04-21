package Krish.src.SolidPrinciples.InterfaceSegregation;

import java.util.List;

public class DrinkMenu implements IDrinkMenu {
    @Override
    public List<String> getDrinkItems() {
        return List.of("Water, Soda");
    }

    public void displayDrinkItems() {
        System.out.println(getDrinkItems());
    }
}