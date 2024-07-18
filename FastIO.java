import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int a = (int) st.nval;
            st.nextToken();
            double b = st.nval;
            st.nextToken();
            String c = st.sval;//读不到 123 这种
            st.nextToken();
            // 不能用 Long.parseLong(st.sval); 此时无法识别到数字
            long d = (long) st.nval;
            pw.printf("a=%d, b=%f, c=%s, d=%d\n", a, b, c, d);
            pw.flush();
        }

        pw.close();
    }
}
