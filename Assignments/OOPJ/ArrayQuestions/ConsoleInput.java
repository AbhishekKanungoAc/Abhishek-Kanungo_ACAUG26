public class ConsoleInput {

    public static float getFloat() {

        String obj = getString();

        float data = Float.parseFloat(obj);

        return data;
    }

    public static int getInt() {

        return Integer.parseInt(getString());
    }

    public static String getString() {

        try {

            byte arrInput[] = new byte[100];

            int len = System.in.read(arrInput);

            byte arrFinal[] = new byte[len - 2];

            System.arraycopy(arrInput, 0, arrFinal, 0, len - 2);

            String objString = new String(arrFinal);

            return objString;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
