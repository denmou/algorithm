/**
 * @author denmou
 * @date 2021/2/3 09:55
 */
public class Util {
    public static char[] toCharArray(String value) {
        char[] array = null;
        if (value.trim().length() > 0) {
            String[] items = toArray(value);
            array = new char[items.length];
            for (int i = 0; i < items.length; i++) {
                array[i] = items[i].trim().charAt(0);
            }
        }
        return array == null ? new char[0] : array;
    }

    public static int[] toIntegerArray(String value) {
        int[] array = null;
        if (value.trim().length() > 0) {
            String[] items = toArray(value);
            array = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                array[i] = Integer.parseInt(items[i].trim());
            }
        }
        return array == null ? new int[0] : array;
    }

    public static String[] toArray(String value) {
        return value.split("[,|，]");
    }
}
