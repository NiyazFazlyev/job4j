package ru.job4j.sort;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortByAge() {
        List<User> list = List.of(
                new User("Niyaz", 25),
                new User("Ivan", 21),
                new User("Misha", 20),
                new User("Artem", 21)
        );
        SortUser su = new SortUser();
        Set<User> result = su.sort(list);
        User[] expect = {
                new User("Misha", 20),
                new User("Artem", 21),
                new User("Ivan", 21),
                new User("Niyaz", 25)
        };
        assertThat(result.toArray(new User[3]), is(expect));
    }

    @Test
    public void whenSortByNameLength() {
        List<User> list = List.of(
                new User("Niyaz", 25),
                new User("Ivan", 21),
                new User("Misha", 20),
                new User("Yan", 21)
        );
        SortUser su = new SortUser();
        List<User> result = su.sortNameLength(list);
        List<User> expect = List.of(
                new User("Yan", 21),
                new User("Ivan", 21),
                new User("Niyaz", 25),
                new User("Misha", 20)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortByAllFields() {
        List<User> list = List.of(
                new User("Petr", 22),
                new User("Petr", 20),
                new User("Ivan", 25),
                new User("Ivan", 21)
        );

        SortUser su = new SortUser();
        List<User> result = su.sortByAllFields(list);
        List<User> expect = List.of(
                new User("Ivan", 21),
                new User("Ivan", 25),
                new User("Petr", 20),
                new User("Petr", 22)
        );
        assertThat(result, is(expect));
    }

}
