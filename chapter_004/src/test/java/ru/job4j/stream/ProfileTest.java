package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    @Test
    public void whenGetAddresses() {
        Address address1 = new Address("New York", "Victoriya", 36, 12);
        Address address2 = new Address("Kazan", "Arbuzova", 5, 114);
        Profile prof1 = new Profile(address1);
        Profile prof2 = new Profile(address2);
        List<Profile> profiles = new ArrayList<>(Arrays.asList(prof1, prof2));
        List<Address> expect = new ArrayList<>(Arrays.asList(address1, address2));
        List<Address> result = Profile.collect(profiles);
        assertThat(result, is(expect));

    }
}
