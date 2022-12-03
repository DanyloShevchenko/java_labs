import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class findMaxElement {
    public byte main(byte arr[]) throws Exception {
        List<Byte> list = new ArrayList<Byte>();
        for (byte i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (byte i = 0; i < arr.length; i++) {
            if(list.get(i) > 0) {
                return Collections.max(list);
            }
        }
        throw new NegativeOnlyArrayException("Array has no positive numbers");
    }
}
