<h1>202230110 류준상</h1>

<i>컴퓨터의 잦은 초기화로 인해서 커밋이 제대로 되지 않고 있습니다   
대신 이곳에 학습내용을 최대한 보기 좋게 작성하겠습니다</i>

<b><h2>2025 05 22</h2></b>

<b></b>



















<b><h2>2025 05 15</h2></b>

<b>모듈이란</b>  

자바 9에서 도입된 개념 

패키지와 이미지 등의 리소르를 담은 컨테이너  

모듈 파일로 저장됨   

<b>Object 클래스</b>  
모든 자바 클래스는 반드시 Object를 상속받도록 자동 설계됨  

모든 클래스의 최상위 클래스  

모든 클래스가 상속받는 공통 메소드 포함  

Object 클래스는 객체의 속성을 나타내는 메소드 제공  

<b>hashCode 메소드</b>  
객체의 해시코드 값을 리턴하며, 객체마다 다름  
  
<b>getClass 메소드</b>  
현재의 클래스 정보를 담은 Class 객체 리턴  
Class 클래스의 getName 메소드는 객체의 클래스 이름 리턴  
   
<b>toString 메소드</b>  
객체를 문자열로 리턴 

```
class Point3 {
    int x, y;
    public Point3(int x, int y) {
        this.x = x; this.y = y;
    }

    public boolean equals(Object obj) {
        Point3 p = (Point3)obj;  // obj를 Point3 타입으로 형변환
        if (x == p.x && y == p.y) return true;
        else return false;
    }
}

public class Ex63EqualsEx {
    public static void main(String[] args) {
        Point3 a = new Point3(2, 3);
        Point3 b = new Point3(2, 3);
        Point3 c = new Point3(3, 4);
        
        if (a == b) System.out.println("a == b");
        if (a.equals(b)) System.out.println("a is equal to b");
        if (a.equals(c)) System.out.println("a is equal to c");
    }
}

```
<b>실행 결과 = a is equal to b인 이유</b>  
a랑 b는 값이 같은거지 주소가 같은게 아니기 때문에 a == b는 출력되지 않는 것  
equals는 주소가 아닌 값을 비교하는 것이기 때문에 출력됨  

<b>toString 메소드</b>
각 클래스는 toString()을 오버라이딩하여 자신만의 문자열 리턴값 제공 가능  
객체를 문자열로 반환 public String toString()  

사용 예시 >>  

객체 + 문자열 → 객체.toString() + 문자열로 자동 변환  

객체를 출력하려고 할 경우 → 객체.toString()으로 자동 호출  



```
Point a = new Point(2, 3);
String s = "a = " + a;
System.out.println(s);
// a 객체는 문자열과 더해질 때 자동으로 알아서 a.toString() 호출됨

Point a = new Point(2, 3);
System.out.println(a.toString());
// 명시적으로 toString() 호출
```

wraaper 클래스
자바의 기본 타입을 클래스화 한 8개의 클래스를 통칭
| 기본 타입       | byte | short | int     | long | char      | float | double | boolean |
| ----------- | ---- | ----- | ------- | ---- | --------- | ----- | ------ | ------- |
| Wrapper 클래스 | Byte | Short | Integer | Long | Character | Float | Double | Boolean |  

```
Integer i = Integer.valueOf(10);
Character c = Character.valueOf('A');
Double d = Double.valueOf(3.14);
Boolean b = Boolean.valueOf(true);

Integer i = new Integer(10);
Character c = new Character('A');
Double d = new Double(3.14);
Boolean b = new Boolean(true);
```
  
Integer i = new Integer("10");  
Integer i = Integer.valueOf("abc");  문자열로도 묶을 수 있으나 abc같은 경우엔 오류 발생 <i>(abc는 숫자변환이 안되니)</i>  

<b>박싱</b> : 기본 타입의 값을 wrapper 객체로 변환 하는 것  
<b>언박싱</b> : wrapper 객체에 들어있는 기본 타입의 값을 빼내는 것  
```
integer ten = 10; // 10을 ten 안으로 박싱
int n = ten; // "ten" 안에 있는 값 빼내서 언박싱
```
스트링 리터럴과 new Strin 스트링 리터럴    

자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리됨  
응용프로그램에서 공유됨  

new String()으로 생성된 스트링
스트링 객체는 힙에 생성
스트링은 공유되지 않음    

```
String a = "Hello";
String b = "Java";
String c = "Hello"; // 여기서 a와 c는 같은 리터럴을 참조하지만
String d = new String("Hello");
String e = new String("Java");
String f = new String("Java"); // new string은 e와 f의 값이 같아도 각각의 메모리에 별도로 저장된다
```
<h2><b>2025 05 08</b></h2>  

<b>패키지(package)</b>

서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 디렉터리

하나의 응용프로그램은 한 개 이상의 패키지로 작성

패키지는 jar 파일로 압축할 수 있음

<b>모듈(module)</b>

여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너

하나의 모듈을 하나의 .imod 파일에 저장 
  
<b>모듈화의 목적</b>

Java 9부터 자바 API를 여러 모듈(99개)로 분할 : Java 8까지는 rt.jar의 한 파일에 모든 API 저장, 현재 70개로 정리됨.

응용프로그램이 실행할 때 꼭 필요한 모듈들로만 실행 환경 구축 : 메모리 자원이 열악한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 실행 이미지를 만들기 위함
  

---  



소프트웨어를 규격화된 모듈로 만들고, 인터페이스가 맞는 모듈을 조립하듯이 응용프로그램을 작성하기 위해서 사용.
자바의 인터페이스
클래스가 구현해야 할 메소드들이 선언되는 추상형  

인터페이스 선언 : interface 키워드로 선언.
Ex) public interface SerialDriver { … }  

자바 인터페이스에 대한 변화
Java 7까지 : 인터페이스는 상수와 추상 메소드로만 구성
Java 8부터
상수와 추상메소드 포함
default 메소드 포함 (Java 8)
private 메소드 포함 (Java 9)
static 메소드 포함 (Java 9)  

여전히 인터페이스에는 필드(멤버 변수) 선언 불가  



abstract public String getName();  추상 메소드  
abstract public String fail() { return "Good Bye"; }  추상 메소드 아님. 컴파일 오류  

<b>추상 메소드를 가진 추상 클래스</b>

```
abstract class Shape {
    public Shape() { ... }
    public void edit() { ... }
    abstract public void draw();  추상 메소드
}
```

<b>추상 메소드 없는 추상 클래스</b>
```
abstract class JComponent {
    String name;
    public void load(String name) {
        this.name = name;
    }
}
```
<b>추상 메소드를 상속받으면 추상클래스가 됨</b>
```
abstract class A {  추상 클래스
    abstract public int add(int x, int y);  추상 메소드
}

abstract class B extends A {  추상 클래스
    public void show() {
        System.out.println("B");
    }
}

A a = new A(); 컴파일 오류 추상 클래스의 인스턴스 생성 불가
B b = new B(); 아래도 동일하게 오류

```
<b>추상 클래스를 구현한 서브 클래스는 추상 클래스가 아님</b> 상속 X
(부분적으로만 가져온것)
```
class C extends A { // 추상 클래스 구현. C는 정상 클래스
    public int add(int x, int y) {
        return x + y; // 추상 메소드 구현. 오버라이딩
    }

    public void show() {
        System.out.println("C");
    }
}

C c = new C();  정상 실행

```
예제
```
public class qqq {

    abstract class Calculator {

        public abstract int add(int a, int b);
    
        public abstract int subtract(int a, int b);
    
        public abstract double average(int[] a);
    }

    abstract class GoodCal extends Calculator { 
        
        @Override
        public int add(int a, int b) { // 추상 메소드 구현
            return a + b;
        }

        @Override
        public int subtract(int a, int b) { 
            return a - b;
        }

        @Override
        public double average(int[] a) { 
            double sum = 0;
            for (int i = 0; i < a.length; i++)
                sum += a[i];
                return sum / a.length;
        }

}
```






<h2>2025 1학기 중간고사 이전 학습내용</h2>
멤버 접근 지정

 public 멤버: 패키지에 관계없이 모든 클래스에게 접근 허용<br/>
 private 멤버: 동일 클래스 내에만 접근 허용. 상속 받은 서브 클래스에서 접근 불가.<br/>
 protected 멤버: 같은 패키지 내의 다른 모든 클래스에게 접근 허용 상속 받은 서브 클래스는 다른 패키지에 있어도 접근 가능<br/>
 디폴트(default) 멤버: 같은 패키지 내의 다른 클래스에게 접근 허용<br/>


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

 static 메소드의 제한

 static 메소드는 오직 static 멤버만 접근 가능
 객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문에, non-static 멤버 활용 불가
 non-static 메소드는 static 멤버 사용 가능

