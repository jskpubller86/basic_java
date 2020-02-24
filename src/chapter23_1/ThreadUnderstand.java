package chapter23_1;

/* Thread 클래스를 상속받아 개별적인 Thread를 할당 받아 실행할 수 있게 함. */ 

class ShowThread extends Thread
{
    String threadName;
    
    public ShowThread(String name) 
    {
        threadName=name;
    }
    
    public void run() // Thread의 run 메소드 오버라이딩
    {
        for (int i = 0; i < 100; i++) 
        {
            System.out.println("안녕하세요. " + threadName+"입니다.");
            try
            {
                sleep(100); // 1/1000 * 100 초가 맘춤.
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadUnderstand 
{
    public static void main(String[] args) 
    {
        ShowThread st1=new ShowThread("멋진 쓰레드");
        ShowThread st2=new ShowThread("예쁜 쓰레드");
        // 아래와 같이 start 메소드를 호출하면  st1, st2의 run 메소드가 동시에 시행된다.
        // run 메소드의 실행이 완료되면 해당 쓰레드도 소멸된다.
        // main 메소드가 종료되어도 실행중인 쓰레드가 아직 있다면 프로그램은 종료되지 않는다.
        st1.start();
        st2.start();
    }
}
