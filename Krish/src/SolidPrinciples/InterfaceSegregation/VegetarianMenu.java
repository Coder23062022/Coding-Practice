package Krish.src.SolidPrinciples.InterfaceSegregation;

import java.util.List;

public class VegetarianMenu implements IVegetarianMenu {
    @Override
    public List<String> getVegetarianItems() {
        return List.of("Sabji, Paneer");
    }

    public void displayVegItems() {
        System.out.println(getVegetarianItems());
    }
}