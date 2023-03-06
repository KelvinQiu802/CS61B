package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    private StudentArrayDeque<Integer> stu;
    private ArrayDequeSolution<Integer> sol;

    @Before
    public void createDeque() {
        stu = new StudentArrayDeque<>();
        sol = new ArrayDequeSolution<>();
    }

    @Test
    public void randomTest() {
        while (true) {
            int randNum = StdRandom.uniform(0, 4);
            switch (randNum) {
                case 0: {
                    int num = StdRandom.uniform(1000);
                    stu.addFirst(num);
                    sol.addFirst(num);
                    assertEquals(stu.size(), sol.size());
                    break;
                }
                case 1: {
                    int num = StdRandom.uniform(1000);
                    stu.addLast(num);
                    sol.addLast(num);
                    assertEquals(stu.size(), sol.size());
                    break;
                }
                case 2: {
                    if (stu.size() != 0 && sol.size() != 0) {
                        Integer a = stu.removeFirst();
                        Integer b = sol.removeFirst();
                        assertEquals(a, b);
                        assertEquals(stu.size(), sol.size());
                    }
                    break;
                }
                case 3: {
                    if (stu.size() != 0 && sol.size() != 0) {
                        Integer a = stu.removeLast();
                        Integer b = sol.removeLast();
                        assertEquals(a, b);
                        assertEquals(stu.size(), sol.size());
                    }
                    break;
                }
            }
        }
    }
}
