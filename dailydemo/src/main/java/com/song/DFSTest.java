package com.song;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DFSTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 1 && j == 4) {
                    continue;
                }
                List<Point> points = new ArrayList<>();
                dfs(i, j, points);
            }
        }
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
