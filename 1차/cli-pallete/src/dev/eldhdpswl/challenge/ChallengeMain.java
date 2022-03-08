package dev.eldhdpswl.challenge;


import dev.eldhdpswl.basic.Lecturer;
import dev.eldhdpswl.basic.Person;
import dev.eldhdpswl.basic.Student;

import java.util.*;

public class ChallengeMain {
    public static void main(String[] args) {

        /*

        ## Challenge Mission

        1. Java 클래스 중 `ArrayList`, `LinkedList`, `Vector`, `HashSet` 를 찾아봅시다. 클래스들의 공통점을 살펴보세요.
        2. 위에서 언급한 클래스들은 전부 여러 객체를 들고있을 수 있습니다. 이 클래스가 가지고 있는 `item` 을 형식을 맞춰 출력하는 함수를 작성해 봅시다.

        ### 세부 조건

        1. 출력은 아래와 같은 형식으로 작성합니다.

            ```
            idx item
            0   Item 1
            1   Item 2

            ...

            n   Item n
            ```

        2. `Item n` 부분은 클래스의 Item (또는 Element)를 `String`으로 전환했을때의 값으로 나오면 됩니다.
        3. Item이 없으면 `No Elements` 라고 출력합니다.

        * */

        //아래 4개는 모두 Collection의 일종이다.
//        ArrayList a;
//        LinkedList b;
//        Vector c;
//        HashSet d;

        Person studentKim = new Student("kim", 26);
        Person studentLee = new Student("Lee", 28);
        Person studentPark = new Student("Park", 24);

        Person lecturer = new Lecturer("eldhdpswl", 32);


        List<Person> everyone = new ArrayList<>();
//        List<Person> everyone = new LinkedList<>();
//        List<Person> everyone = new Vector<>();
//        Set<Person> everyone = new HashSet<>();

        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        printItems(everyone);

    }

    public static <T> void printItems(Iterable<T> iterable){

        Iterator<T> iterator = iterable.iterator();
        if(!iterator.hasNext()){
            System.out.println("No Elements");
            return;
        }

        //문자열을 한번에 다 쓰기 힘든 것들을 원하는 시점에 문자열을 합칠수 있는 builder이다.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for(int i=0; iterator.hasNext(); i++){
            T item = iterator.next();
            stringBuilder.append(
                    String.format("%d\t\t%s\n", i, item));

        }

        System.out.println(stringBuilder);

    }
}
