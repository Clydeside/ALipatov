package ru.job4j.Convertation;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void toListTest() {
        ConvertList convertList = new ConvertList();
        int length = 5;
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> list = convertList.toList(array);
        for (Integer elem : list)
            System.out.println(elem);
    }

    @Test
    public void toArrayTest() {
        ConvertList convertList = new ConvertList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        int[][] array = convertList.toArray(list, 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void convertTest() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expected));
    }
}