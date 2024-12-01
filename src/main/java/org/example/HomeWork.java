package org.example;


import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/problemset/problem/1324/C
     */
    @SneakyThrows
    public void frogSteps(InputStream in, OutputStream out) {
        try (var sc = new Scanner(in); var pw = new PrintWriter(out)) {
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                var input = sc.next();
                pw.println(minimalD(input));
            }
        }
    }



    static int minimalD(String s) {
        int n = s.length();

        var pos = new ArrayList<Integer>();
        pos.add(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                pos.add(i + 1);
            }
        }
        pos.add(n + 1);

        int ans = 0;
        for (int i = 0; i < pos.size() - 1; i++) {
            ans = Math.max(ans, pos.get(i + 1) - pos.get(i));
        }

        return ans;
    }

}
