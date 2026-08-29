package Krish.src.SolidPrinciples.InterfaceSegregation;

public class Main {
    static void main() {
        VegetarianMenu vm = new VegetarianMenu();
        NonVegetarianMenu nvm = new NonVegetarianMenu();
        DrinkMenu dm = new DrinkMenu();

        vm.displayVegItems();
        nvm.displayNonVegItems();
        dm.displayDrinkItems();
    }
}