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
        System.out.println(address1.toString());
        List<Profile> profiles = new ArrayList<>(Arrays.asList(prof1, prof2));
        List<Address> expect = new ArrayList<>(Arrays.asList(address1, address2));
        List<Address> result = Profile.collect(profiles);
        assertThat(result, is(expect));

    }

    @Test
    public void whenGetUniqueAddresses() {
        Address address1 = new Address("New York", "Victoriya", 36, 12);
        Address address2 = new Address("Kazan", "Arbuzova", 5, 114);
        Profile prof1 = new Profile(address1);
        Profile prof2 = new Profile(address2);
        Profile prof3 = new Profile(address2);
        System.out.println(address1.toString());
        List<Profile> profiles = new ArrayList<>(Arrays.asList(prof1, prof2, prof3));
        List<Address> expect = new ArrayList<>(Arrays.asList(address2, address1));
        List<Address> result = Profile.uniqueCollect(profiles);
        assertThat(result, is(expect));

    }
}
