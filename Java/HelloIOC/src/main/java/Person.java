interface Ieat {
    void eat();
}


class EatApple implements Ieat {
    public void eat() {
        System.out.println("吃苹果！");
    }
}

class EatOrange implements Ieat {
    public void eat() {
        System.out.println("吃橘子！");
    }
}

// Person类
public class Person {
    Ieat eat;

    public void eat(){
        System.out.println("eating");
        eat.eat();
    }

    public Ieat getEat() {
        return eat;
    }

    public void setEat(Ieat eat) {
        this.eat = eat;
    }
}
