package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortByAge() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Niyaz", 25);
        User user2 = new User("Ivan", 21);
        User user3 = new User("Misha", 20);
        User user4 = new User("Artem", 21);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        SortUser su = new SortUser();
        Set<User> result = su.sort(list);
        User[] expect = new User[]{user3, user4, user2, user1};
        assertThat(result.toArray(new User[4]), is(expect));
    }

    @Test
    public void whenSortByNameLength() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Niyaz", 25);
        User user2 = new User("Ivan", 21);
        User user3 = new User("Misha", 20);
        User user4 = new User("Yan", 21);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        SortUser su = new SortUser();
        List<User> result = su.sortNameLength(list);
        List<User> expect = new ArrayList<>(Arrays.asList(user4, user2, user1, user3));
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortByAllFields() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Ivan", 25);
        User user2 = new User("Ivan", 21);
        User user3 = new User("Petr", 22);
        User user4 = new User("Petr", 20);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        SortUser su = new SortUser();
        List<User> result = su.sortByAllFields(list);
        List<User> expect = new ArrayList<>(Arrays.asList(user2, user1, user4, user3));
        assertThat(result, is(expect));
    }

}
