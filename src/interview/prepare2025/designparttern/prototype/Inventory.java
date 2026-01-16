package interview.prepare2025.designparttern.prototype;

/**
 * @author dimmy
 */
public class Inventory {

    public int quantity;
    public String name;

   public static class Builder {
        public int quantity;
        public String name;

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Inventory build() {
            var inventory = new Inventory();
            inventory.name = this.name;
            inventory.quantity = this.quantity;
            return inventory;
        }
    }
}
