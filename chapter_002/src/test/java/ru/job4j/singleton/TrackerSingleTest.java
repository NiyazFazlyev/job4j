package ru.job4j.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {
    @Test
    public void whenCreate2TrackerSingleFirst() {
        TrackerSingleFirst tracker1 = TrackerSingleFirst.INSTANCE;
        TrackerSingleFirst tracker2 = TrackerSingleFirst.INSTANCE;
        boolean result = tracker1.equals(tracker2);
        assertThat(result, is(true));
    }

    @Test
    public void whenCreate2TrackerSingleSecond() {
        TrackerSingleSecond tracker1 = TrackerSingleSecond.getInstance();
        TrackerSingleSecond tracker2 = TrackerSingleSecond.getInstance();
        boolean result = tracker1.equals(tracker2);
        assertThat(result, is(true));
    }

    @Test
    public void whenCreate2TrackerSingleThird() {
        TrackerSingleThird tracker1 = TrackerSingleThird.getInstance();
        TrackerSingleThird tracker2 = TrackerSingleThird.getInstance();
        boolean result = tracker1.equals(tracker2);
        assertThat(result, is(true));
    }

    @Test
    public void whenCreate2TrackerSingleFourth() {
        TrackerSingleFourth tracker1 = TrackerSingleFourth.getInstance();
        TrackerSingleFourth tracker2 = TrackerSingleFourth.getInstance();
        boolean result = tracker1.equals(tracker2);
        assertThat(result, is(true));
    }
}
