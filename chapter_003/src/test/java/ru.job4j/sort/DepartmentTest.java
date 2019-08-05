package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentTest {
    @Test
    public void whenGetSortedDepartments() {
        String[] deps = new String[]{
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        Department department = new Department(deps);
        String[] result = new String[9];
        result = department.sortDepartments().toArray(result);
        String[] expect = {
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenGetReverseSortedDepartments() {
        String[] deps = new String[]{
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        Department department = new Department(deps);
        String[] result = new String[9];
        String[] expect = {
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1",
        };
        result = department.reverseSortDepartments().toArray(result);
        assertThat(result, is(expect));
    }
}
