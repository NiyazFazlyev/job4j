package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void listConvertToHashMap() {
        UserConvert userConvert = new UserConvert();
        ArrayList<User> list = new ArrayList<>();
        User user1 = new User(1, "Niyaz");
        User user2 = new User(2, "Damir");
        list.add(user1);
        list.add(user2);
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, user1);
        expect.put(2, user2);
        assertThat(result, is(expect));
    }
}
