package Krish.src.SolidPrinciples.InterfaceSegregation;

public class Main {
    public static void main(String[] args) {
        VegetarianMenu vm = new VegetarianMenu();
        NonVegetarianMenu nvm = new NonVegetarianMenu();
        DrinkMenu dm = new DrinkMenu();

        vm.displayVegItems();
        nvm.displayNonVegItems();
        dm.displayDrinkItems();
    }
}