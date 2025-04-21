package Krish.src.SolidPrinciples.InterfaceSegregation;

import java.util.List;

public class NonVegetarianMenu implements INonVegetarianMenu {
    @Override
    public List<String> getNonVegetarianItems() {
        return List.of("Mutton, Chicken");
    }

    public void displayNonVegItems() {
        System.out.println(getNonVegetarianItems());
    }
}