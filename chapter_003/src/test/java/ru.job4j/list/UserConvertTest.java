package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void listConvertToHashMap() {
        UserConvert userConvert = new UserConvert();
        User user1 = new User(1, "Niyaz");
        User user2 = new User(2, "Damir");
        List<User> list = List.of(user1, user2);
        Map<Integer, User> result = userConvert.process(list);
        Map<Integer, User> expect = Map.of(1, user1,2, user2);
        assertThat(result, is(expect));
    }
}
