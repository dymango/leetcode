package interview.prepare2025.designparttern.decorate;

import interview.prepare2025.designparttern.prototype.Inventory;

/**
 * @author dimmy
 */
abstract class DecorateFood implements Food {
    Food food;

    public DecorateFood(Food food) {
        this.food = food;
    }

    @Override
    public void process() {
        food.process();
        var a1 = new Inventory.Builder().setName("a").setQuantity(1).build();
    }
}
