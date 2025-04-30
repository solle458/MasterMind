//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class MasterMind {
    private static int min = 65;
    private static int max = 90;
    private static char[] seikai;
    private static int limit;
    private static int numcheck;
    private static int[] answer;
    private static long start;
    private static long end;

    public MasterMind() {
    }

    public static void main(String[] var0) {
        for(int var1 = 0; var1 < Seikai.deck.length; ++var1) {
            seikai[var1] = Seikai.deck[var1];
        }

        start = System.currentTimeMillis();
        Solver.answer();
        System.out.println("*** No answer submitted. ***");
    }

    public static int getlimit() {
        return limit;
    }

    public static int getzigen() {
        return seikai.length;
    }

    public static void submit(char[] var0) {
        end = System.currentTimeMillis();
        --numcheck;
        int[] var1 = new int[2];
        var1 = evaluate(var0);
        System.out.println(end - start + " msecs.");
        System.out.println(numcheck + " evaluations.");
        System.out.print("Your answer = ");

        for(int var2 = 0; var2 < seikai.length; ++var2) {
            System.out.print(var0[var2]);
        }

        System.out.println();
        System.out.print("Seikai      = ");

        for(int var4 = 0; var4 < seikai.length; ++var4) {
            System.out.print(seikai[var4]);
        }

        System.out.println();
        System.out.print("hint0, hint1 = " + var1[0] + ", " + var1[1]);
        System.out.println();
        System.exit(0);
    }

    public static int[] evaluate(char[] var0) {
        if (numcheck > limit) {
            System.out.println("*** Too many checks. ***");
            System.exit(0);
        }

        if (var0.length != seikai.length) {
            System.out.println("*** Invalid array length. ***");
            System.exit(0);
        }

        for(int var1 = 0; var1 < seikai.length; ++var1) {
            if (var0[var1] < min) {
                System.out.println("*** Invalid card. *** " + var0[var1]);
                System.exit(0);
            } else if (var0[var1] > max) {
                System.out.println("*** Invalid card. *** " + var0[var1]);
                System.exit(0);
            }
        }

        ++numcheck;
        answer[0] = 0;
        answer[1] = 0;
        char[] var5 = new char[seikai.length];
        char[] var2 = new char[seikai.length];

        for(int var3 = 0; var3 < seikai.length; ++var3) {
            var5[var3] = var0[var3];
            var2[var3] = seikai[var3];
        }

        for(int var6 = 0; var6 < seikai.length; ++var6) {
            if (var5[var6] == var2[var6]) {
                int var10002 = answer[0]++;
                var5[var6] = '.';
                var2[var6] = '_';
            }
        }

        for(int var7 = 0; var7 < seikai.length; ++var7) {
            for(int var4 = 0; var4 < seikai.length; ++var4) {
                if (var5[var7] == var2[var4]) {
                    int var8 = answer[1]++;
                    var5[var7] = '.';
                    var2[var4] = '_';
                }
            }
        }

        return answer;
    }

    static {
        seikai = new char[Seikai.deck.length];
        limit = 10000;
        numcheck = 0;
        answer = new int[2];
    }
}
