package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(n -> n.address).collect(Collectors.toList());
    }

    public static List<Address> uniqueCollect(List<Profile> profiles) {
        return profiles.stream()
                .map(n -> n.address)
                .distinct()
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
    }

    public Address getAddress() {
        return address;
    }
}
