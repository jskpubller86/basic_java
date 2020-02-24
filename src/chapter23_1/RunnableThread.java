package chapter23_1;

class Sum {
    int num;
    public Sum() {num=0;}
    public void addNum(int n) {num += n;}
    public int getNum() {
        return num;
    }
}
/* Runnable 인터페이스를 이용한 쓰레드 구현 */
class AddrThread extends Sum implements Runnable
{
    int start, end;
    public AddrThread(int s, int e) {
        start = s;
        end = e;
    }
    /* Thread 클래스를 상속할 때와 마찬가지로 run 메소드를 통해 쓰레드 생성 */
    public void run() {
        for (int i = start; i <= end; i++) {
            addNum(i);
            System.out.println(i);
        }
    }
}
public class RunnableThread {
    public static void main(String[] args) {
        // at1, at2 인스턴스 두 개 생성
        AddrThread at1 = new AddrThread(1, 50);
        AddrThread at2 = new AddrThread(51, 100);
        // 위 두 개의 인스턴스를 쓰레드 인스턴스로 할당
        Thread tr1 = new Thread(at1);
        Thread tr2 = new Thread(at2);
        
        
        // 쓰레드의 start 메소드를 호출하게 되면 Runnable 인터페이스의 run 메소드를 호출하게 된다.
        // 참고로 쓰레드는 호출한 순서를 보장하지 않는다.
        tr1.start();
        tr2.start();
        
        try
        {
            // 아래의 join 메소드는 쓰레드가 종료될 때 호출하는 메소드이다. 
            tr1.join(); // tr1 쓰레드가 종료될 때 호출 
            tr2.join(); // tr2 쓰레드가 종료될 때 호출
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1~100까지의 합 :" + (at1.getNum() +at2.getNum()));
    }
}
