# 202230110 류준상

## !!Shift Alt F 줄 자동 정렬!!   

4장 5장 8장 9장 연습

## <b>2025 06 05</b>  

<b>이벤트 리스너 작성 방법</b>  
* 독립 클래스의 작성  
    - 이벤트 리스너를 구현한 클래스를 작성  
    - 이벤트 소스와 리스너 객체의 연결은 외부로 분리  

* 내부 클래스(Inner Class)의 작성  
    - 멤버, 지역, 익명(anonymous) 내부 클래스  
    - 이벤트 소스와 리스너 객체의 연결을 내부로 포함  

* 익명(anonymous) 클래스의 작성  
    - 일회용 클래스, 간단한 리스너 작성에 적합  
    - 클래스 정의, 객체 생성, 리스너 객체 생성과 연결을 동시에 수행  

<b>Key 이벤트와 포커스</b>   
키 입력 시, 다음 세 경우 각각 Key 이벤트 발생  
* 키를 누르는 순간 (keyPressed)  
* 누른 키를 떼는 순간 (keyReleased)  
* 누른 키를 떼는 순간, 문자가 입력 될 때 (Unicode키의 경우에만, keyTyped)  

<b>키 이벤트를 받을 수 있는 조건</b>
모든 컴포넌트  
현재 포커스(focus)를 가진 컴포넌트가 키 이벤트 독점  

<b>포커스(focus)</b>  
컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한  
컴포넌트에 포커스 설정 방법 : 다음 2 라인 코드 필요  

<b>유니코드(Unicode) 키</b>
유니코드 키의 특징  
국제 산업 표준  
전 세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계  
문자들에 대해서만 키 코드 값 정의 : A~Z, a~z, 0~9, !, 0, & 등  
문자가 아닌 키 경우에는 표준화된 키 코드 값 없음  
<Function> 키, <Home> 키, <Up> 키, <Delete> 키, <Control> 키, <Shift> 키, <Alt> 등은 플랫폼에 따라 키 코드 값이 다를 수 있음  

<b>유니코드 키가 입력되는 경우</b>  
keyPressed(), keyTyped(), keyReleased()가 순서대로 호출  
<b>유니코드 키가 아닌 경우</b>  
keyPressed(), keyReleased()만 호출됨  

<b>eyEvent 객체</b>
입력된 키 정보를 가진 이벤트 객체
KeyEvent 객체의 메소드로 입력된 키 판별

<b>char KeyEvent.getKeyChar()</b>  
키의 유니코드 문자 값 리턴  
Unicode 문자 키인 경우에만 의미 있음  
입력된 키를 판별하기 위해 문자 값과 비교하면 됨  
```
public void keyPressed(KeyEvent e) {
    if(e.getKeyChar() == 'q')
        System.exit(0);
}
```

<b>int KeyEvent.getKeyCode()</b>  
유니코드 키 포함  
모든 키에 대한 정수형 키 코드 리턴  
입력된 키를 판별하기 위해 가상키(Virtual Key) 값과 비교해야 함  
가상 키 값은 KeyEvent 클래스에 상수로 선언  
```
public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_F5)
        System.exit(0);
}
```
![Image](https://github.com/user-attachments/assets/17f971ae-6cad-4fc3-b275-46bbc2761c8f)  

마우스 리스너는 컴포넌트에 다음과 같이 등록  
```
component.addMouseListener(myMouseListener);
```
MouseMotion를 하고 싶으면 모션 리스너도 따로 등록해야 함  
```
component.addMouseMotionListener(myMouseMotionListener);
```
```
public void mousePressed(MouseEvent e) {
    int x = e.getX(); // 마우스가 눌러진 x좌표
    int y = e.getY(); // 마우스가 눌러진 y좌표
}
public void mouseClicked(MouseEvent e) {
    if(e.getClickCount() == 2) {
        // 더블클릭 처리 예시
    }
}
```


## <b>2025 05 29</b>

<b>스윙 gui 프로그램 만드는 과정</b>  
스윙 프레임 만들기  
main() 메소드 작성  
스윙 프레임에 스윙 컴포넌트 붙이기  

스윙 프레임 : 모든 스킬 컴포넌트를 담는 최상위 컨테이너  
프레임의 크기 반드시 지정 : setSize() 호출  
Swing 응용프로그램에서 main()의 기능과 위치  
스윙 응용프로그램에서 main()의 기능 최소화 바람직  
스윙 응용프로그램이 실행되는 시작점으로서의 기능만  
스윙 프레임을 생성하는 정도의 코드로 최소화  

```
public static void main(String[] args) {
    MyFrame frame = new MyFrame(); // 스윙 프레임 생성
}
```

**프레임에 컴포넌트 붙이기**
타이틀 달기  
super()나 setTitle() 이용  

```
public class MyFrame extends JFrame {
    MyFrame() {
        super("타이틀문자열");
        setTitle("타이틀문자열");

        // 프레임의 컨텐트팬을 알아낸다.
        Container contentPane = getContentPane();
    }
}
```  
컨텐트팬에 컴포넌트 달기  
**컨텐트팬이란?** 스윙 컴포넌트들이 부착되는 공간  
컨텐트팬 알아내기 : 스윙 프레임에 붙은 디폴트 컨텐트팬 알아내기  
컨텐트팬에 컴포넌트 붙이기  
// 버튼 컴포넌트 생성

```
JButton button = new JButton("Click");
contentPane.add(button); // 컨텐트팬에 버튼 부착
```    

```
class MyPanel extends JPanel {
    // JPanel을 상속받아 새로운 패널을 구현한다.
}
// frame의 컨텐트팬을 MyPanel 객체로 변경
frame.setContentPane(new MyPanel());
```
```
public class qqq extends JFrame {
    public qqq() {
        setTitle("ContentPane과 JFrame 예제"); // 프레임 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램 종료

        Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        contentPane.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 배치관리자 달기

        contentPane.add(new JButton("OK"));     // OK 버튼 달기
        contentPane.add(new JButton("Cancel")); // Cancel 버튼 달기
        contentPane.add(new JButton("Ignore")); // Ignore 버튼 달기

        setSize(300, 150); // 프레임 크기 300x150 설정
        setVisible(true);  // 프레임을 화면에 출력
    }

    public static void main(String[] args) {
        new qqq();
    }
}
```
실행 결과  
![Image](https://github.com/user-attachments/assets/ed037433-c47e-403e-988a-2371d17ce956)

## Swing 응용프로그램의 종료  
응용프로그램 내에서 스스로 종료하는 방법  
언제 어디서나 무조건 종료  
```
System.exit(0);
```
**프레임의 오른쪽 상단의 종료버튼(X)을 클릭해서 끈다면?**  
프레임 종료, 프레임 윈도우를 닫음 : 프레임이 화면에서 보이지 않게 됨  
프레임이 보이지 않게 되지만 응용프로그램이 종료한 것 아님  
  
키보드나 마우스 입력을 받지 못함  
다시 setVisible(true)를 호출하면, 보이게 되고 이전처럼 작동함  
프레임 종료버튼이 클릭될 때, 프레임과 함께 프로그램을 종료 시키는 방법  
```
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```
**배치 관리자 4가지**
FlowLayout  
BorderLayout  
GridLayout  
CardLayout   

**배치 관리자가 없는 컨테이너가 필요한 경우**  
컨테이너의 배치 관리자 제거 방법  
```
container.setLayout(null);
```
추가된 컴포넌트의 크기 0으로 설정, 위치는 예측할 수 없게 됨  
따라서 컴포넌트의 크기와 위치를 반드시 개발자가 직접 지정해야 하며, 그렇지 않으면 화면에 정상적으로 표시되지 않음.
+ 서로 겹칠 수 있음  
Ex) 버튼 100×40 크기로 하고, JPanel의 (50, 50) 위치에 배치
```
JPanel p = new JPanel();
p.setLayout(null); // 패널의 배치관리자 제거

JButton clickButton = new JButton("Click");
clickButton.setSize(100, 40);      // 버튼 크기를 100×40으로 지정
clickButton.setLocation(50, 50);   // 버튼 위치를 (50, 50)으로 지정
p.add(clickButton);                // 패널 (50, 50)에 100×40 크기의 버튼 추가
```


*참고*
```
//jdk 1.5 이후
getContentPane().setBackground(Color.ORANGE); // 오렌지색 배경 설정
getContentPane().setLayout(new FlowLayout());

//jdk 1.5 이전
Container contentPane = getContentPane(); // 컨텐트팬 알아내기
contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
contentPane.setLayout(new FlowLayout()); 
```

**이벤트 기반 프로그래밍(Event Driven Programming)**    
이벤트 발생에 의해 프로그램 흐름이 결정되는 방식   
이벤트가 발생하면 이벤트를 처리하는 루틴(이벤트 리스너) 실행  
실행될 코드는 이벤트의 발생에 의해 전적으로 결정  

**이벤트 종류**  
사용자의 입력 : 마우스 드래그, 마우스 클릭, 키보드 누름 등  
센서로부터의 입력, 네트워크로부터 데이터 송수신  
다른 응용프로그램이나 다른 스레드로부터의 메시지  
(각 이벤트마다 처리하는 리스너 코드 보유)    

*반대되는 개념 : 배치 실행(batch programming)*  
+ 프로그램의 개발자가 프로그램의 흐름을 결정하는 방식  

**자바 스윙 프로그램에서 이벤트 처리 과정**
1. 이벤트 발생  
2. 이벤트 객체 생성  
3. 현재 발생한 이벤트에 대한 정보를 가진 객체  
4. 응용프로그램에 작성된 이벤트 리스너 찾기  
5. 이벤트 리스너 실행  
6. 리스너에 이벤트 객체 전달  
7. 리스너 코드 실행  

**이벤트 객체가 포함하는 정보**  
이벤트 종류와 이벤트 소스  
이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표  
이벤트가 발생한 버튼이나 메뉴, 아이템의 무작위  
클릭된 마우스 버튼, 버튼 번호 및 마우스의 클릭 횟수  
키의 코드 값과 문자 값  
체크박스, 라디오버튼 등과 같은 컴포넌트에 이벤트가 발생했다면 체크 상태  
  
이벤트 소스를 알아 내는 메소드 : Object getSource()  
발생한 이벤트의 소스 컴포넌트 리턴  
Object 타입으로 리턴하므로 캐스팅하여 사용  
모든 이벤트 객체에 대해 적용  
  
**이벤트 작성 예)**
이벤트와 이벤트 리스너 선택  
버튼 클릭을 처리하고자 하는 경우  
→ 이벤트: Action 이벤트, 이벤트 리스너: ActionListener  
이벤트 리스너 클래스 작성: ActionListener 인터페이스 구현  
```
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) { // 버튼이 클릭될 때 호출되는 메소드
        JButton b = (JButton)e.getSource();      // 사용자가 클릭한 버튼 알아내기
        if(b.getText().equals("Action"))         // 버튼의 문자열이 "Action"인지 비교
            b.setText("액션");                   // JButton의 setText() 호출, 문자열 변경
        else
            b.setText("Action");                 // JButton의 setText() 호출, 문자열 변경
    }
}
```
이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록  
component.addXXXListener(listener)  
(XXX: 이벤트 명, listener: 이벤트 리스너 객체)  
```
MyActionListener listener = new MyActionListener(); // 리스너 인스턴스 생성
btn.addActionListener(listener);                    // 리스너 등록

```

<b><h2>2025 05 22</h2></b>

<b>자바의 GUI</b>  
GUI : 사용자가 컴퓨터와 대화할 수 있도록 그래픽으로 제공되는 그림, 글자, 아이콘에서 마우스나 키보드 등을 통해 명령을 처리하는 사용자 인터페이스   
자바 언어에서 GUI 응용프로그램 작성 : 과거엔 Java의 AWT가 있었지만 현재는 Swing이 더 많이 사용됨  
<i>AWT 컴포넌트는 운영체제의 자원을 이용하여 동작하며, 플랫폼마다 다르게 보임 현재 AWT는 거의 사용되지 않음</i>  
  
<b>Swing</b>  
AWT 기술을 기반으로 작성된 자바 라이브러리   
AWT의 모든 기능과 스윙 고유의 풍부하고 화려한 고급 컴포넌트  
Swing은 J로 시작하는 클래스   
AWT 컴포넌트 이름 앞에 J가 붙고 순수 자바 언어로 구현 가능  

<b>Vector<E>의 특징</b>  

객체 삽입, 삭제, 검색, 크기 조절이 간편  
배열의 길이 제한 단점을 극복한 자료구조  
맨 뒤 또는 중간에 객체 삽입 가능  
객체 수가 많아지면 자동으로 크기 조절  
객체 삭제 시 한 칸씩 앞으로 이동  
객체 삽입 시 한 칸씩 뒤로 이동  

Vector<E>는 List 인터페이스 구현

<b>ArrayList<E></b>
크기, 삽입, 삭제, 검색이 간편  
배열 기반, 크기 자동 증가, 중복 허용  
순서 O, 인덱스(0부터)로 관리  
다양한 타입의 객체 저장 가능  

<i>요즘은 어레이를 주로 사용하며 벡터와는 동기화 여부, 성능, 크기 증가 방식 등 내부 동작에 차이점이 있다.</i>

<b>컬렉션</b>  
여러 개의 데이터를 그룹으로 관리하는 자료구조의 집합  

데이터의 추가, 삭제, 검색 등이 용이  
다양한 자료구조(List, Set, Map 등) 제공  
제네릭(Generic) 지원으로 타입 안정성 보장  

배열: 고정된 크기, 같은 타입만 저장  
컬렉션: 크기 변경 가능, 다양한 타입 저장 가능
```
컬렉션 생성문
Vector<String> v = new Vector<>();  //자바 7 기준
var v = new Vector<String>();  //자바 10 이후 기준
```
<b>Math 클래스</b>  

수학 관련 다양한 메서드를 제공하는 클래스  

모든 메서드는 static임에 유의  

주요 메서드: Math.random() 등  

random() : 0.0 이상 1.0 미만의 double형 난수 반환  
(int)(Math.random()*n) : 0 이상 n 미만의 정수 난수 발생  
(int)(Math.random()*n) + start : start 이상 (start+n) 미만의 정수 난수 발생  

<b>StringTokenizer 클래스</b>  

문자열을 구분자로 분리하는 클래스  
구분자(delimiter): 문자열을 구분할 때 사용하는 문자  

<b>주요 메소드</b>  
  
hasMoreTokens() : 남아있는 토큰이 있는지 검사  
nextToken() : 다음 토큰을 반환  
hasMoreTokens() : 남은 토큰이 있는지 확인  
nextToken() : 다음 토큰 반환  
```
//예시 1
StringTokenizer st = new StringTokenizer("apple/orange/banana", "/");

//예시 2
String query = "name=kitae&addr=seoul&age=21";
StringTokenizer st = new StringTokenizer(query, "&");
while(st.hasMoreTokens()) {
    System.out.println(st.nextToken());
  }

//출력 결과
name=kitae
addr=seoul
age=21

```



<b>StringBuffer 클래스</b>  
가변 문자열을 위한 클래스  

StringBuffer 객체 생성  
StringBuffer sb = new StringBuffer();  

String 클래스와 달리 문자열 변경 가능  

문자열 추가, 삭제, 삽입, 변경 등 다양한 처리 가능  

메모리 낭비 없이 문자열 처리 효율적  

```
//예시
StringBuffer sb = new StringBuffer();
sb.append("Java");
```

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

