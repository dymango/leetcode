package app.pdd;


/**
 * @author dimmy
 */
public class Food {
    public Cat cat = new Cat();

    /**
     * cms 标记清除 复制
     * g1 标记整理 分块收集 可预测停顿时间
     *
     *
     * wonder项目 inventory模块
     * 餐车库存管理， 线下餐馆库存管理
     * 复盘整个系统的设计
     * 库存扣减，库存补充
     * 并发库存操作
     * 事务
     * 异步架构
     * kafka
     * mysql
     * mongodb
     * 整个设计基础是 管理目标为sub item, 就是做菜的原料
     * 提供给app端使用的是 menu item级别的数量
     * 和其他系统的对接，库存数据需要上报财务
     * 需要管理库存的加载和卸载
     * zone级别的库存计算
     *
     * 车辆的选取
     * 一个zone内的餐车数量， 餐车库存， 餐车是否正在做餐， 餐车排队订单数， 发车时间缓冲， hoding room， 最后计算得出出餐时间最快的车辆
     *
     * c/s架构
     *
     * order management system
     * 主要管理公司tob的订单数据，包括订单管理， 发票管理， 货物管理， 业务复杂度，物流管理， 设备管理，
     * 订单open, ship, delivered
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        Cat cat1 = new Cat();
    }
}