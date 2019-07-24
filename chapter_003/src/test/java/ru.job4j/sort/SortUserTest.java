package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
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

}
