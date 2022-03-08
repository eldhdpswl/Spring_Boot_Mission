package dev.eldhdpswl.basic;

public abstract class AbstractPerson implements Person {

    /*
    * 추상클래스는 인터페이스의 구현을 하는데 있어서, 이 인터페이스의 구현체들이 동일하게 가지고 가야되는 영역들에 대한 이야기를 하게 된다.

    * * 즉, '사람이라면 누구나 이름과 나이를 가질수 있다.' 라는 의미를 가지고 있다.

    * 그런데 이름이 다른 곳에서, 상속받은 객체가 아닌 다른곳에서 이리저리 만질수 있다면 나중에 코드를 정리할떄 피곤해진다.
      그리고 사용성에 있어서도 맞는 형태로 사용을 한다고 하기 힘들다.
      AbstractPerson에 정의되어있는 private String name 이 변수는 상속받은 클래스(Student)들이 직접적으로 활용을 하기 위해서 만든 변수인데,
      외부에 있는 소스코드에서 직접적으로 변수에 접근을 한다는 것은 인캡슐레이션적인 측면에서도 말이 안된다.
      그래서 변수는 private로 두고, 사용을 하기위한 시점에서 사용을 하게끔 public String getName()으로 한다.
    * */

    private String name;
    private int age;

    public AbstractPerson() {
    }

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println(String.format("Hi, my name is %s.", this.name));
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "AbstractPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
