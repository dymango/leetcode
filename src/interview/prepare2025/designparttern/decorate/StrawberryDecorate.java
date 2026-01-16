package interview.prepare2025.designparttern.decorate;


/**
 * @author dimmy
 */
public class StrawberryDecorate extends DecorateFood {

    public StrawberryDecorate(Food food) {
        super(food);
    }

    @Override
    public void process() {
        super.process();
        System.out.println("add strawberry");
    }
}
