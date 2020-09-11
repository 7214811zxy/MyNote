import myAnnotation.MyAutoWired;


class Service {

    @MyAutoWired(value = "person123")
    static Person person;

    void test(){
        person.eat();
    }

}

