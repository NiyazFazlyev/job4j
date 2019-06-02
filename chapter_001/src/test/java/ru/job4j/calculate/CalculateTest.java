package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Niyaz Fazlyev
 * @version 1
 * @since 02.06.2019
 */
public class CalculateTest {
 /**
 * Test echo.
 */

	@Test
	 public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Niyaz Fazlyev";
		String expect = "Echo, echo, echo : Niyaz Fazlyev"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	 }

}