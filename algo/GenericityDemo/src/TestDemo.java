import org.junit.Test;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/23 19:04
 */

class Demo<T>{

}

class Food{

}

class Fruit extends Food{

}

class Apple extends  Fruit{

}

class Banana extends Fruit{

}

class Plate<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }


}

public class TestDemo {

    @Test
    public void test1(){
        //<>当中的数据类型不参与类型的组成 JVM当中没有泛型的概念，泛型只存在于编译阶段
        Demo<String> demo = new Demo<>();
        System.out.println(demo);
        Demo<Integer> demo2 = new Demo<>();
        System.out.println(demo2);
    }

    @Test
    public void test2(){
        Plate<Apple> applePlate = new Plate<>();
        applePlate.setMessage(new Apple());
        func1(applePlate);

        Plate<Banana> bananaPlate = new Plate<>();
        bananaPlate.setMessage(new Banana());
        func1(bananaPlate);
    }

    public static void func1(Plate<? extends Fruit> tmp){//上界
        //这里不可以进行修改！
        System.out.println(tmp.getMessage());
    }

    @Test
    public void test3(){
        Plate<Fruit> fruitPlate = new Plate<>();
        fruitPlate.setMessage(new Fruit());
        func2(fruitPlate);

        Plate<Food> foodPlate = new Plate<>();
        foodPlate.setMessage(new Food());
        func2(foodPlate);
    }
    public static void func2(Plate<? super Fruit> tmp){//下界
        tmp.setMessage(new Apple());
        tmp.setMessage(new Banana());
    }

}
