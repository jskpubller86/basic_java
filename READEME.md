# chapter 24_1 

## File I/O에 대한 소개

- 자바는 입출력 대상에 상관없이 입출력 방식이 동일하도록 별도의 "I/O 모델"을 정의하고 있음.
- 자바는 스트림을 통해서 입출력을  지원함.
- 스트림은 크게 InputStream, OutputStream으로 나누어짐.
- InputStream의 read메소드는 1바이트의 데이터를 읽어와서 반환한다.
- OutputStream의 write 메소드는 1바이트의 데이터를 목적지로 전송한다.
- InputStream의 반환형이 int인 이유는 더이상 읽을 데이터 없을 경우 -1을 반환하기 때문이다. (byte로는 -1 표현 불가)

입력스트림 간략한 사용법은 다음과 같다.

~~~java
InpustStream in = new FileInputStream("run.exe");
while(true)
{
    int bData = in.read();
    if(bData == -1)
        break;
    ....
}
in.close() // 입력스트림 소멸
~~~

출력스트림도 위와 같은 방식이다. 

입출력 스트림은 서로 쌍을 이룬다. 

> InputStream <-> OutputStream
>
> FileInputStream <-> OutputStream

