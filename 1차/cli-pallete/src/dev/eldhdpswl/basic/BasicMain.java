package dev.eldhdpswl.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicMain {
    public static void main(String[] args) {

        /*

        # Mission 1
        # Interface 사용해보기

        Java의 Interface가 뭔지 직접 다뤄봅시다.

        이번 미션은 인터페이스에 대한 지식이 정확하다면 챌린지 미션이 베이직 미션보다 쉽습니다.

        ## Basic Mission

        1. 사람을 나타내는 `Person` 인터페이스를 정의하고,
        2. 사람을 구현하는 추상 클래스 `AbstractPerson` 을 구현한 다음,
        3. `AbstractPerson` 을 확장하는 `Student` 와 `Lecturer` 클래스를 각각 만들어보세요.

        ### 세부 조건

        1. `Person` 인터페이스는 사람을 나타내는 인터페이스로서, `void speak()` 함수를 가지고 있습니다. `Person` 인터페이스의 구현체는 `speak` 함수를 통해 자신의 정보를 출력합니다.
        2. `AbstractPerson` 추상 클래스는 사람이라면 공통적으로 가지는 정보, 기능 등을 구현하기 위한 클래스 입니다. 이름, 나이 정보 등을 가지고 있으며, `speak` 함수도 사용할 수 있습니다.
        3. `Student` 와 `Lecturer` 는 `AbstractPerson` 을 extend 하며, `speak` 함수를 사용할 때 자신의 이름과 학생인지, 강사인지를 이야기해줍니다.

        * */

        Person studentKim = new Student("kim", 26);
        Person studentLee = new Student("Lee", 28);
        Person studentPark = new Student("Park", 24);

        Person lecturer = new Lecturer("eldhdpswl", 32);


        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        for(Person person: everyone){
            person.speak();
        }

    }
}
