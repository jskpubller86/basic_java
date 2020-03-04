package chapter24_1;
import java.io.*;

public class ByteFileCopy {
    public static void main(String[] args) throws IOException {
        //
        String path = System.getProperty("user.dir");
        // 현재 클래스의 경로 
        //String path = ByteFileCopy.class.getResource("").getPath();  
        System.out.println(path);
        InputStream in = new FileInputStream("org.txt");
        OutputStream out = new FileOutputStream("copy.txt");
        
        int copyByte = 0;
        int bData;
        
        while (true) {
            bData = in.read(); // 1바이트 만큼 읽어옴.
            
            if(bData==-1) // 더이상 읽을 데이터가 없을 경우 종료
                break;
            out.write(bData); // 1바이트 만큼 전송
           
            // 읽어온 데이터의 크기
            copyByte++;
        }
        in.close();
        out.close();
        System.out.println("복사된 바이트 크기 " + copyByte);
    }
}
