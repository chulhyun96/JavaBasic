<h1>예외처리란? 예외처리의 필요성</h1>

<h2>자바에서 제공되는 예외 클래스</h2>
학습 목차
<ul>  
    <li> 프로그램에서의 오류</li>  
    <li> 예외 처리의 중요성</li>  
    <li> 오류와 예외 클래스의 종류</li>  
    <li> 요약 및 결론</li>
</ul>  

<h2 style="color: aqua">프로그램에서의 오류</h2>

프로그램에서의 오류에는 크게 2가지 종류가 존재한다.  
컴파일 오류와 실행 오류

이중 컴파일 오류는 흔히 말하는 좋은(?) 오류라고 소개한다.  
왜? 우리가 프로그램을 실행시키기 전에 미리 문법 적인 문제에서 발생하는 오류이기 때문에  
알려주기 때문이다.

허나 실행 오류 같은 경우에는 심각한 오류로 분류 될 수 있는데  
해당 부분이 가장 해결하기 힘들기도 하면서, 프로그램의 비정상적인 종료같은 경우가 일어날 경우 서비스함에 있어서 금전적인 손해와 함께 서비스 품질을 떨어뜨리기 때문이다.


컴파일 오류같은 경우에는 단순히 문법적으로 오류가 난 경우라면, 실행 오류는 프로그램이  
의도치 않은 동작을 하거나 프로그램이 중지되는 오류등 비정상 종료가 되는 경우 심각한 장애를 발생시킬 수 있다.  
이는 서비싱 중인 회사입장에서는 심각한 손실을 초래하기 때문에  <p style="color: red"> 이런 것들을 방지하기 위해서 예외 처리를 해야한다는 것.</p>

<h2 style="color: aqua">예외 처리의 중요성</h2>

앞서 프로그램에서의 오류 부분에서 설명했듯이, 프로그램이 비정상적으로 종료되었다는 것은, 실행상태에서 오류가 났다라는 것인데.  
실행 오류가 발생한 경우 해당 오류의 과정을 재현하여 오류를 찾아내는 것은 매우 힘든일이다. 사용자가 오류가 난 시점에서 오류 상황에 대해서 report한다 한들,  
그 사람의 시스템적 환경이 어떤지 하나하나 경우의 수를 따져가며 오류를 찾아내고 수정하는 것은 매우 비현실적이기 때문이다.

그래서 오류가 발생한 경우 log를 남겨서 추후 분석을 통해 해당 오류를 찾아내고 수정하는 것이 중요하다.

예외처리는 그 만큼 개발부분에서 중요한 부분을 차지하는데, 즉 예외 처리를 하는 행위 자체가 <p style="color: red"> 프로그램의 안정성 보장</p>을 하는 행위라고 생각하면 된다.  
그리고 오류가 발생 경우 log를 남기는 행위는 <p style="color: red">오류 발생 시 분석하고 해결책을 제시하기 위한 것</p> 이 두가지의 키포인트를  
되새김질하면서 예외 처리의 중요성을 인지하고 개발하는 것이 중요한 부분이다.


<h2 style="color: aqua">오류와 예외 클래스</h2>  
여기 오류와 예외에 대해서 간단하게라도 정확한 정의를 알고 가는 것이 중요하다.

<ul>  
<li>오류</li>  
오류란 영어로 Error를 가리키는데, JVM에서 발생하는 것으로, 이 부분은 프로그래머가 처리할 수 없는 Error로 분류된다.  
예를 들어 동적 메모리가 없는 경우, 스텍 메모리 오버플로우와 같은 상황들이 있다.  
<li>예외</li>  
프로그램에서 프로그래머가 제어할 수 있는 오류에 속하는데, 읽어들이려는 파일이 존재하지 않거나, 네트웍이나 DB연결이 안되는 경우를 뜻한다. (개발자가 코드를 잘못 작성하여 기대하는 값으로 안나오게 되는 논리적 오류도 포함)
</ul>  

즉 오류와 예외의 기준을 명확히 구별해주는 차이점은 다음과 같다.
<p style="color: yellow">오류는 주로 JVM의 문제로 인해 발생하며, 대부분 복구 불가능하다.  
예외는 프로그램의 일반적인 실행 흐름 환경에서 발생하여 이는 프로그래머가 충분히 핸들링 할 수 있다.</p>  

아래 이미지는 Exception의 계층 구조이다.(본래 최상단에는 Throable 클래스가 있으며 하위 클래스에 Excpetion 클래스가 존재한다.)

크게 예외의 계층 구조에서 또 다시  2가지로 나뉘어져 있는데  
입출력 예외처리와 실행오류 예외처리(RunTimeException)이 있다.


![img_1.png](img_1.png)

입출력예외인 IOException은 대표적으로 FileNotFoundException, 런타임중에  
읽어들일 파일을 찾지 못했을 경우에 프로그램이 종료되는 경우인데, IOException의 하위 클래스들은  
예외처리가 강요된다.

여기서 강요된다는 것이 어떤 것이냐면

![img_2.png](img_2.png)

해당 소스 코드를 보면   
FileInputStream 클래스를 인스턴스화 시켰을 경우 아래와 같이 빨간줄이 그어지는데, Unhandled Exception이라고 적혀있다. 예외처리를 하지 않아서 나는 오류라는 뜻이다.  
쉽게 말해 해당 객체를 사용하려면 적절한 예외처리를 해야만 사용할 수 있다는 것이다.

그럼 개발자 입장에서는 무조건 적절한 예외처리에 관한 코드를 작성해야하하는데, 이것이 예외처리를 강요한다는것.  
Checked Exception이다(컴파일 시점에 예외처리를 강제하는 예외, 하지 않으면 컴파일 에러 발생).

Checked Exception이 있다면 Unchecked Exception 또한 존재한다.

Unchecked Exception은 위에 보이는 사진의 계층에서 보이는 RuntimeException이 UncheckedException에 속한다  
Arithmetic Exception, IndexOutOfBoundsException 등등 있는데,


![img_3.png](img_3.png)  
근데 똑같이 예외가 발생하게 되었는데 왜 IOExcpetion은 예외 처리를 강요하고 Arithmetic Exception과 같은 RuntimeException은 예외처리를 강요하지 않을까??

<h2 style="color: aqua">Runtime Exception은 예외처리를 강요받지 않는 이유 </h2>  
위의 소스 코드를 예제로 설명을 해본다면, Arithmetic Exception은 정수를 0으로 나누려고 했을 때 발생하는 런타임 예외이다.

이러한 예외는 프로그램이 실행이 되다가 어느 순간 0이 되어서 발생하는 예외이다.   
이는 예측이 불가능한 예외라는 것을 말하는데.  
프로그램의 버그나 논리적 오류(개발자가 코드를 잘못짜서 기대한 값과 다르게 나올 경우) 로 인해서 발생하는 경우가 많다.

예를 들어 배열의 잘못된 인덱스에 대한 접근 혹은 null을 참조하는 경우가 있다.  
이는 논리적 오류인 경우가 99%이므로 예외처리를 강제하지 않는다.

만약 강제하게 된다면,   모든 경우의 수에 대해서 try-catch 블록을 작성해야 한다.

그러므로 Unchecked Exception은 프로그래머가 코드를 작성하는 시점에서 피할 수 있는 명백한 오류들(0으로 나누기만 피하면됨, null경우만 피하면됨)  
프로그래머가 코드를 더 신중하게 작성하여 오류를 사전에 방지하도록 하기 위함이다.

<h2 style="color: aqua">적절한 예외 처리를 하지 않을 경우</h2>

![img_3.png](img_3.png)  
위에서 설명한 같은 예외인 상황이다. 해당 소스코드에서는 Arithmetic Exception이 발생하면서  
프로그램이 비정상 종료되는 것을 볼 수 있다.



![img_4.png](img_4.png)

적절한 예외 처리를 했을 경우의 소스코드이다. 0으로 나누는 것에 대해서 try-catch 블록으로 감싸서  
예외처리를 하였다. try 구문은 해당 로직을 수행 할 때, 만약 오류가 발생한다면 catch문에서 해당 오류를 잡아서  
log를 출력하는 구문이다. 그리고 빠져나와서 "끝" 이라는 단어를 출력하게 하였는데.

![img_5.png](img_5.png)

결과가 잘 출력되는 것을 확인할 수 있다.

이처럼 적절하게 예외처리를 하는 것은 프로그램의 설계에 있어서 엄청나게 중요한 부분이다.  
앞서 위에서 언급했듯이 예외처리를 하는 것은 <p style="color:red">프로그램의 안정성 보장(비정상 종료 방지), 로그를 남겨 해결책을 제시</p>  
하기 위한것이다.

누가 물어본다면 이 두가지에 대해서 말하고 설명할 수 있을 거 같다!!

예외처리를 하는 것만으로도 프로그램이 비정상종료되지 않는다. 막 코드를 작성하고나서 실행했을 때  
비정상 종료 되는 것만큼 당황스러운게 없다.

[[예외처리와 예외처리 미루기(02)]]


<h1>예외 처리 방법(리소스 파일 예외처리)</h1>
![[Pasted image 20240121185328.png]]

자바에서 예외를 처리하는 방식에는 보통 두가지가 제공된다(내가 아는 한에선...)

첫 번째에서 제공되는 Add exception to method signature 방식은 예외처리를 미루는 방식이고
두 번째에서 제공되는 Surround with try/catch는 해당 소스코드를 try-catch블럭을 소스코드로 작성하여 감싸는 방식이다.

먼저 두번째 방식을 살펴 보면서 finally 구분과 try-with-resources 구분을 알아보도록 하겠다.

<h2>finally</h2>
해당 키워드는 try - catch 블록을 감싼 상태에서 리소스의 파일을 닫아야 하는 경우 사용하는 구분이다.(리소스를 안 닫아도 되는 상황이라면 finally 구분은 사용하지 않아도 된다.)

```java
FileInputStream fis = null;  
try {  
    fis = new FileInputStream("text.txt");  
} catch (FileNotFoundException e) {  
    throw new RuntimeException(e);  
} finally {  
    fis.close();  
}
```

이와 같은 코드가 있을 때 (현재 text 파일은 존재하지 않는다.)

파일 리소스를 읽어들이는 과정에서 모두 읽어들이면 파일 리소스를 닫아주는 close 메서드를 사용해서 닫아줘야한다.
만약 finally 키워드를 사용하지 않는다면 매 과정에서 close 메서드를 수행시켜줘야 한다.(반복이 발생함)

```java
FileInputStream fis = null;  
try {  
    fis = new FileInputStream("text.txt"); 
    fis.close(); 
} catch (FileNotFoundException e) {  
    throw new RuntimeException(e);  
    fis.close();
}
```
finally 키워드를 사용함으로써 파일의 리소스를 닫아주는 close 메서드를 한번만 호출하면 된다.

근데 맨 처음에 본 finally 키워드를 사용한 소스코드를 볼 때 fianlly 구분에서 close 메서드를 사용한 시점에서
NullPointExecption, FileNotFoundException이 발생 할 수 있다.  그렇다면 finally 구분을 다시한번 try-catch 블럭으로 감싸줘야 하는데

```java
FileInputStream fis = null;  
try {  
    fis = new FileInputStream("text.txt");  
} catch (FileNotFoundException e) {  
    throw new RuntimeException(e);  
} finally {  
    try {  
        fis.close();  
    } catch (IOException e) {  
        throw new RuntimeException(e);  
    }  
}
```
벌써 보기에 뭔가 불편하다... (일단 이 부분은 나중에 고쳐보도록 하겠다)

해당 소스코드에서 finally 구분은 try 구분이 수행하게 되면 finally 구분은 무조건적으로 수행하게 되어있다.

```java
FileInputStream fis = null;  
try {  
    fis = new FileInputStream("src/text");  
} catch (FileNotFoundException e) {  
    System.out.println(e.getMessage());  
    return;  
} finally {  
    System.out.println("finally");  
    try {  
        fis.close();  
    } catch (IOException e) {  
        System.out.println(e.getMessage());  
    }  
    System.out.println("끝");  
}
```

![[Pasted image 20240121191313.png]]
해당 소스코드를 실행시켜보면 catch 구분에서 분명 return을 사용했음에도 불구하고 블럭을 벗어나지 않고 finally까지 가서 "finally" 와 try-catch 구분을 완전히 벗어난 "끝" 도 출력된 것을 볼  수 있다. (여기서는 text파일을 하나 만들었습니다.)

finally는 무조건 실행된다는 것.

<p style="color: aqua">결론 : finally는 리소스를 불러오는 경우 예외 처리에 대해서 각각의 예외 구분에서 close 메서드를 사용하지 않고 finally 구분에서 한꺼번에 리소스의 close 메서드를 호출하게 함으로써 한번에 이를 도와주는 용도이다.</p>

<h2>try-with-resources</h2>
해당 구분을 살펴보려면 finally 사용시의 불편함을 인지해야만 한다.
나는 예제하나만으로도 이해를 했다. 그냥 일단 try-catch 블럭을 사용하고 그뒤 벗어날 때 finally로 연결 짓는다. 그 후 파일의 리소스를 닫아주는 close 메서드를 사용하는 건데, 런타임 시점에서 close할 때 해당 파일이 Null일 수도 있고, 파일을 찾지 못했을 상황도 있기에 이를 한번 더 try-catch로 감싸준다.

런타임 시점에 close 메서드를 수행 할 경우 이러한 예외 상황이 있으니 try-catch로 감싸주는 건 알겠는데, 가독성 측면에서 이게 뭔가 싶기도 하다. 나는 개인적으로 가독성이 좋은 코드가 유지보수와 직결된다고 생각하는 사람이다.


```java
FileInputStream fis = null;  
try {  
    fis = new FileInputStream("src/text");  
} catch (FileNotFoundException e) {  
    System.out.println(e.getMessage());  
} finally {  
    try {  
        fis.close();  
    } catch (IOException e) {  
        System.out.println(e.getMessage());  
    }  
}
```
그럼 결국 이딴식의 코드가 작성된다. 이 정말 간단한 예제에서도 finally안에 또 try-catch가 쓰인다니 쓰기 싫어진다.

이러한 불편함을 자바진영에서도 알고 있었고, 그래서 자바7부터는 try-with-resources 가 제공되게 되었다.

<p style="color: aqua">해당 구분은 close 메서드를  명시적으로 사용하지 않아도 자동적으로 리소스를 해제해준다.</p>
조건이 존재하는데 사용중인 리소스 클래스가 AutoCloseable 인터페이스를 구현중이여야 한다.
AutoCloseable 인터페이스는 close() 메서드 단 하나만을 정의하고 있다. 이를 자동적으로 구현하고 있는 클래스 들이 있는데, oracle 문서에 따르면 이러한 아이들이 자동적으로 구현을 하고있다.

- `java.io.InputStream`
- `java.io.OutputStream`
- `java.io.Reader`
- `java.io.Writer`
- `java.util.Scanner`
- `java.net.Socket`
- `java.sql.Connection`
- `java.sql.ResultSet`
- `java.sql.Statement`
- `java.nio.channels.Channel`의 여러 구현체들, 예를 들어 `FileChannel`
- `java.nio.file.DirectoryStream`
- `java.util.zip.ZipFile`
- `javax.sound.sampled.Line`

InputStream과 OutputStream은 이를 구현하고 있음을 알 수 있다.

그렇다면 사용예제를 보도록 하겠다.

```java
try (FileInputStream fis = new FileInputStream("src/text")) {  
  
} catch (FileNotFoundException e) {  
    System.out.println(e.getMessage());  
} catch (IOException e) {  
    throw new RuntimeException(e);  
}
```
try-with-resources 구문을 사용하는 방법은 try 옆에 ()괄호를 사용하여 선언해주는 것이다.
근데 이 방법을 사용하면 FileNotFoundException(파일이 없을 때만을 특정지어서 예외처리를 해주는 것) 이외의

IOExecption에 대한 구문도 적어줘야 한다. 이는 AutoCloseable 인터페이스가 close 메서드를 지원하는데, close 메서드 사용시 발생 가능한 예외를 FileNotFoundException에만 국한짓지 않고, 더 넓은 범위에 대해서 예외 처리를 해주기 위함이다.


```java
//AutoCloseable의 close 메서드가 진짜로 불렸는지 확인해보기
public class AutoCloseableTest implements AutoCloseable{  
    @Override  
    public void close() throws Exception {  
        System.out.println("close() called");  
    }  
  
}
```
해당 클래스는 내가 정의한 클래스이다 -> close 메서드가 try-catch-resources 구문에서 진짜로 불렸는지 확인해보기 위해

```java
public class AutoCloseableTestMain {  
    public static void main(String[] args) {  
        AutoCloseableTest act = new AutoCloseableTest();  
  
        try (act){  
            throw new Exception();  
        } catch (Exception e) {  
            System.out.println("예외가 발생하였고 close 메서드가 호출된걸 알 수 있음");  
        }  
    }  
}
```

try () 안에 내가 정의한 클래스의 참조변수를 매개변수로 넘겨주고 try 문에서 일부러 오류를 던져보았다.
![[Pasted image 20240121195746.png]]
예외를 성공적으로 발생시켰고, close 메서드(내가 오버라이딩한)가 불린걸 알 수 있다.


<hr>

<h2>예외 처리 미루기</h2>

예외를 처리하는 방식에는 위에서 살펴본 try-catch문이 있고, 해당 메서드를 사용하는 쪽에서 try-catch를 사용하게 하는(예외 처리에 대한 책임을 넘기는)  throws 라는 방식이 있다.

![[Pasted image 20240121201310.png]]
(FileNotFondException인것)
이번에는 Add exception to method signature를 선택하게게 되면 throws 키워드가 나오게 된다.

해당 방식이 예외 처리를 미루는 것.
![[Pasted image 20240121201823.png]]
이제 내가 정의해놓은 메서드(throws 한 메서드)를 처리하려고 하게되면 이런식으로 다시한번 예외처리를 어떤 식으로 할 건지 나오게 된다.

여기서 다시한번 throws를 하게 되면 즉 메인 메서드에서도 예외 처리를 미루게 되어버리면 JVM이 이를 처리하게 되는데, 예외 처리를 안했으니, 예외가 발생한 경우 프로그램이 비정상적으로 종료되고 콘솔에서 우리가 흔히 보는 빨간색 줄의 예외 메시지를 볼 수 있는 것이다.(<p style="color:aqua">아래 사진은 main 메서드에서 예외를 던진 후 일부러 예외를 일으켰을 때 콘솔창에서 출력된 모습입니다.</p>)


![[Pasted image 20240121202632.png]]

정상적으로 try-catch를 메인 메서드에서 실행한 경우
```java
ThrowsTest tt = new ThrowsTest();  
try {  
    tt.testThrowsException("src/a","java.lang.String");  
} catch (FileNotFoundException e) {  
    System.out.println(e.getMessage());  
} catch (ClassNotFoundException e) {  
    System.out.println(e.getMessage());  
}
```
해당 코드는 성공적으로 실행 될 것이다(a라는 파일은 없으니 no such 구문이 콘솔에 출력될 것.)
![[Pasted image 20240121203139.png]]
<p style="color:aqua">이는 비정상적인 종료가 아닙니다!</p>

```java
ThrowsTest tt = new ThrowsTest();  
try {  
    tt.testThrowsException("src/a","java.lang.String");  
} catch (FileNotFoundException e) {  
    System.out.println(e.getMessage());  
} catch (ClassNotFoundException e) {  
    System.out.println(e.getMessage());  
} catch (Exception e) {  
    System.out.println(e.getMessage());  
}
```

그리고 또 한가지 마지막 구문에 예외의 최상위 클래스인 Exception 클래스를 명시해 놓은 이유

FileNotFound, ClassNotFound이외의 다른 예외가 발생할 경우에 대해서도 처리를 하고 싶을 경우, 최상위 클래스를 catch 블럭에 명시해 놓을 수 있다.(가장 마지막에 놓아야 한다. 그렇지 않을 경우, 중간에 최상위 클래스인 Exception이 잡히므로 상세하게 명시해놓은 catch블럭에서 못잡고 Exception에서 잡아버리기 때문에)

<p style="color:aqua">이는 보통 Default Exception이라고 한다.(상위 클래스로 업캐스팅해서 catch 블럭에서 잡히는 메커니즘이다.)</p>

<h1 style="color:aqua">왜 사용자 정의형태가 필요한지</h1>
예를 들어 어떠한 로그인 시스템을 만든다고 가정을 해보겠다.

그럼 필요한 조건들이 있게되는데, 이메일 형식, 아이디와 패스워드의 형식, 생년월일을 입력하는 형식 등등
여러가지 조건이 존재하게 된다. 위에서 예시로 든 조건 같은 경우에는 자바에서는 지원하지 않는 형식인데
예를 들어 이메일 형식은 javadoesntknow@naver.com 이라는 문자와 특수문자의 조합이여만한다.

이러한 경우에는 자바에서 지원하지 않은 형태이기 때문에 개발자가 직접 정의해서 사용해야한다.

그리고 이러한 형태로 개발자가 직접 정의해놓게 되면, 더 직관적이며 가독성 측면에서도 우수하니 유지보수에도 이점으로 작용하게 된다.


<h2>사용자 정의 예외 클래스 만들기</h2>

<p style="color:yellow"> 패스워드를 검증하는 클래스를 만들건데, null일수 없으며, 5글자 이상, 문자로만 이루어져서는 안된다(숫자 및 특수문자가 반드시 포함되어야 함)</p>

내가 정의한 예외 클래스
```java
public class PassWordExceptionTest extends Exception{  
  
    public PassWordExceptionTest(String message) {  
        //해당 메서드는 getMessage를 출력해주는 생성자 메서드  
        //Exception의 메서드임.  
        super(message);  
    }  
}
```

```java
class PassWord {  
    String pw;  
    public PassWord(String pw) throws PassWordExceptionTest {  
        validatePw(pw);  
        this.pw = pw;  
    }  
  
    public String getPw() {  
        return pw;  
    }  
  
    //null일수 없으며, 5글자 이상, 문자로만 이루어져서는 안된다.  
    // (숫자 및 특수문자가 반드시 포함되어야 함)  
    public void validatePw(String pw) throws PassWordExceptionTest {  
        if (pw == null) {  
            throw new PassWordExceptionTest("Pw can't be null");  
        } else if (pw.length() > 5) {  
            throw new PassWordExceptionTest("Pw can't be over 6 you pushed " + pw.length() );  
        } else if (pw.matches("[a-zA-Z]+")) {  
            throw new PassWordExceptionTest("Pw can't include only letter" );  
        }  
    }  
  
    public void printSuccess(String pw) {  
        System.out.println("pw = " + pw + " pw 형식 일치 성공!!");  
    }  
}
```
그리고 Password 클래스에서 유효성 검증 메서드를 작성하고 조건에 부합할 경우 예외를 던지는 식으로 작성하였다.


```java
  try {  
     PassWord pw = new PassWord("1234567");  
    } catch (PassWordExceptionTest e) {  
        System.out.println(e.getMessage());  
    }  
}
```
그리고 사용하는 쪽(메인 메서드)에서 사용하기 위해 try-catch 블럭을 사용하였다.
(해당 소스코드에서는 문자열의 길이에 대한 예외 메세지가 출력된다.프로그램은 비정상 종료되지 않음)
![[Pasted image 20240121215233.png]]

<p style="color:aqua">결론 : 사용자 정의 클래스를 따로 만들어서 예외 처리를 하게 함으로써, 어떠한 종류의 예외가 발생하였는지 직관적으로 알 수 있다. 이는 객체지향 설계 방식에서 역할과 책임을 결정짓는 부분에서 적절하게 사용하면 코드의 가독성과 유지보수를 둘다 챙겨갈 수 있는 좋은 방식이다.</p> 
PasswordException이라는 명시적인 이름으로써 어디서 예외가 발생했는지 알 수 있음.

