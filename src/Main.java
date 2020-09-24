
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        List list = demo.getArrayOfPrimeNumber(20);

        if	(list != null) {
            for	(Object o : list) {
                System.out.println(o.toString());
            }
        } else {
            System.out.println("ko tìm đc các số thỏa mãn");
        }
    }
}


