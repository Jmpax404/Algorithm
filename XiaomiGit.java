public class Main {

    public int Git(String[] matrix, int versionA, int versionB) {
        //build the tree, only the parent node is needed, so use an array
        int n = matrix.length;
        int[] parents = new int[n];
        // Arrays.fill(parents, -1);
        for (int i = 0, len = parents.length; i < len; i++){
            parents[i] = -1;
        }
        //build in the order of BFS, or the root node errors will occur
        int[] queue = new int[n];
        int qf = 0, qr = 0;
        queue[qr++] = 0;
        qr %= n;
        while (qf != qr) {
            int i = queue[qf++];
            qf %= n;
            char[] cs = matrix[i].toCharArray();
            int pi = parents[i];
            for (int j = 0; j < pi; j++) {
                if (cs[j] == '1') {
                    parents[j] = i;
                    queue[qr++] = j;
                    qr %= n;
                }
            }
            for (int j = pi + 1, csl = cs.length; j < csl; j++) {
                if (cs[j] == '1') {
                    parents[j] = i;
                    queue[qr++] = j;
                    qr %= n;
                }
            }
        }
        int[] al = new int[n];
        int aln= 0;
        int[] bl = new int [n];
        int bln= 0;
        int cur = versionA;
        while (cur != -1) {
            al[aln++]=cur ;
            cur = parents[cur];
        }
        cur =versionB;
        while (cur != -1) {
            bl[bln++] = cur;
            cur = parents[cur];
        }
        int l = Math.min(aln, bln);
        int before = -1;
        int alnm1= aln-1;
        int blnm1=bln-1;
        for (int i = 0; i < l; i++) {
            int a = al[alnm1-i];
            int b = bl[blnm1-i];
            if (a == b) {
                before = a;
            } else {
                break;
            }
        }
        return before;
    }

    public static void main(String[] args) {
        System.out.println(new Main().Git(
                new String[]{"0001", "0001", "0001", "1110"},
                3, 2
        ));
    }

}