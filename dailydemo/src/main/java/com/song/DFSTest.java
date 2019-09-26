package com.song;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DFSTest {

    public static void main(String[] args) {
        String s = Integer.toBinaryString('h');
         Integer.toBinaryString('e');
        Object[] a = new Object[0];
        byte[] destBytes = new byte[5];
        byte[] srcBytes = new byte[]{2, 4, 1, 2, 3, 4, 7, 10, 15, 50};
        System.arraycopy(srcBytes, 0, destBytes, 2, 3);
        System.out.println(Arrays.toString(destBytes));
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(4);
        for (int i = 1; i < 100; i++) {
            map.put(i, i);
        }

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (i == 1 && j == 4) {
//                    continue;
//                }
//                List<Point> points = new ArrayList<>();
//                dfs(i, j, points);
//            }
//        }
    }

    private static void dfs(int x, int y, List<Point> points) {
        if (x < 0 || x > 4 || y < 0 || y > 4) {
            return;
        }
        Point p = new Point(x, y);
        if (points.contains(p)) {
            return;
        }
        if (x == 1 && y == 4) {
            return;
        }
        if (points.contains(new Point(x + 1, y))
                && points.contains(new Point(x - 1, y))
                && points.contains(new Point(x, y + 1)) &&
                points.contains(new Point(x, y - 1))) {
            return;
        }

        points.add(p);
        if (points.size() == 24) {
            System.out.println(points);
        }
        dfs(x + 1, y, points);
        dfs(x - 1, y, points);
        dfs(x, y + 1, points);
        dfs(x, y - 1, points);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
