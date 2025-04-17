202230110 류준상

----


class Circle {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius + radius;
    }
}

public class qqq {

    public static void main(String[] args) {
        Circle[] c;
        c = new Circle[5];

        for (int i = 0; i < c.length; i++)
            c[i] = new Circle(i);

        for (int i = 0; i < c.length; i++)
            System.out.print((int) (c[i].getArea()) +  "");
    }
     
    
}

가비지 컬렉션

JVM이 가비지 자동 회수
 가용 메모리 공간이 일정 이하로 부족해질 때
 가비지를 수거하여 가용 메모리 공간으로 확보
 가비지 컬렉터(garbage collector)에 의해 자동 수행

 강제 가비지 컬렉션 강제 수행 : System 또는 Runtime 객체의 gc() 메소드 호출
System.gc(); // 가비지 컬렉션 작동 요청

 이 코드는 JVM에 강력한 가비지 컬렉션 요청
 그러나 JVM이 가비지 컬렉션 시점을 전적으로 판단

객체 소멸

 new로 할당 받은 객체와 메모리를 JVM으로 되돌려 주는 행위
 자바는 객체 소멸 연산자 없음
 객체 소멸은 JVM의 고유한 역할

 C/C++에서는 할당 받은 객체를 개발자가 프로그램 내에서 삭제해야 함
 C/C++의 프로그램 작성을 어렵게 만드는 요인
 자바에서는 사용하지 않는 객체나 배열을 돌려주는 코딩 책임으로부터 개발자 해방
