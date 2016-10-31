/**
 * Created by Martin on 31/10/2016.
 */
public class test {

    private static int GetId(int num) {
        int Offset = 0;
        for (int i = 4; i < num + 1; i++) {
            int temp = i + Offset;
            int digits = 1;
            while (temp > 0) {
                if (temp % 10 == 4) {
                    Offset += digits;
                }
                digits *= 10;
                temp /= 10;
            }
        }
        return Offset + num;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(GetId(22));
    }
}
