package app.huawei;

/**
 * @author dimmy
 */
public class NC68 {

    public int jumpFloor(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
