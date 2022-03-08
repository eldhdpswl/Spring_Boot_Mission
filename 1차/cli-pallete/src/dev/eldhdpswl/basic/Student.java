package dev.eldhdpswl.basic;

import javax.xml.namespace.QName;

public class Student extends AbstractPerson{

    public Student(String name, int age){
        //super는 자신이 상속받은 부모객체의 함수들을 호출하여 사용할수 있는 키워드이다.
        super(name, age);
    }

    @Override
    public void speak() {
        //super.speak();
        System.out.println(String.format("My name is %s, and I am a student.", getName()));
    }
}
