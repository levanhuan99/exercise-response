import java.util.ArrayList;
import java.util.List;

public class Demo {

    //sét xem đầu vào có là số nguyên tố không
    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public List getArrayOfPrimeNumber(int number) {

        //kiểm tra số có phải số nguyên tố hay ko?
        if (isPrime(number)) {
            return null;
        } else {
            //khai báo 2 mảng chứa phần danh sách các số nguyên tố và danh sách chứa các số thỏa mãn
            List listOfPrime = new ArrayList<>();
            List resultList = new ArrayList<>();

            //lấy mảng các số nguyên tố với điều kiện nhỏ hơn input/2
            for (int i = 2; i <= number / 2; i++) {
                if (isPrime(i)) {
                    listOfPrime.add(i);
                }
            }


            int size = listOfPrime.size();
            //kiểm tra số lượng phần tử trong mảng.nếu có 1 phâng tử
            if (size == 1) {
                int element = (int) listOfPrime.get(0);
                if (number % element == 0) {
                    //nếu input chia hết cho thì add vào mảng phần tử đó vào mảng
                    resultList.add(element);
                    int y = number / element;
                    if (isPrime(y)) {
                        resultList.add(y);
                    }
                    return resultList;
                } else {
                    return resultList;
                }
            }
            //nếu mảng có nhiều hơn 1 phần tử thì ta duyệt mảng
            else {
                for (int i = 1; i <= listOfPrime.size(); i++) {

                    //lấy phần tử cuối cùng để xet xem input có chia hết hay không
                    int x = (int) listOfPrime.get(size - i);
                    //nếu chia hết thì thêm phần tử đó vào mảng
                    if (number % x == 0) {
                        resultList.add(x);
                        int m = number / x;
                        //nếu kết quả của phép chia là số nguyên tố thì add số đó vào mảng
                        if (isPrime(m)) {
                            resultList.add(m);
                            return resultList;
                        } else {
                            //nếu kết quả không là số nguyên tố thì gọi lại chính hàm này với số đó
                            List subList = getArrayOfPrimeNumber(m);
                            resultList.addAll(subList);
                            return resultList;
                        }
                    }
                }
            }
        }
        return null;
    }
}
