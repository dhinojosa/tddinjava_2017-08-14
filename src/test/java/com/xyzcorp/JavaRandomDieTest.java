package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.mockito.Mockito.when;

public class JavaRandomDieTest {

	@Test
	@Category(value=UnitTest.class)
	public void testDefaultIs1() throws Exception {
		Die die = new JavaRandomDie(new Random());
		assertThat(die.getPips()).isEqualTo(1);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRollOfA4() {
		Random stub = new Random() {
			@Override
			public int nextInt(int bound) {
				return 3;
			}
		};

		Die die = new JavaRandomDie(stub);
		Die copyDie = die.roll();
		assertThat(copyDie.getPips()).isEqualTo(4);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testDefaultIs1WithConstructorWithRandom() {
		Random stub = new Random() {
			@Override
			public int nextInt() {
				return 4;
			}
		};

		Die die = new JavaRandomDie(stub);
		assertThat(die.getPips()).isEqualTo(1);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRollOfA3EasyMock() {
		Random mock = createMock(Random.class);

		// rehearse
		expect(mock.nextInt(6)).andReturn(2);

		// replay(EasyMock Only)
		replay(mock);

		// run test
		Die die = new JavaRandomDie(mock);
		Die copyDie = die.roll();
		assertThat(copyDie.getPips()).isEqualTo(3);

		// verify
		verify(mock);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRollOfA3Mockito() {
		Random mock = Mockito.mock(Random.class);

		// rehearse
		when(mock.nextInt(6)).thenReturn(2);

		// run test
		Die die = new JavaRandomDie(mock);
		Die copyDie = die.roll();
		assertThat(copyDie.getPips()).isEqualTo(3);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRollOfTwiceUsingMockito() {
		Random mock = Mockito.mock(Random.class);

		// rehearse
		when(mock.nextInt(6)).thenReturn(2, 3);

		// run test
		Die die = new JavaRandomDie(mock);
		Die copyDie = die.roll().roll();
		assertThat(copyDie.getPips()).isEqualTo(4);
	}

	@Test
	@Category(value=IntegrationTest.class)
	public void testIntegrationWithARealRandom() {
		Random random = new Random();
		Die die = new JavaRandomDie(random);
		for (int i = 0; i < 1000000; i++) {
			assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
		}
	}

	@Test
	@Category(value=UnitTest.class)
	public void testBUG401Mockito() {
		Random mock = Mockito.mock(Random.class);

		// rehearse
		when(mock.nextInt(7)).thenReturn(5);

		// run test
		Die die = new JavaRandomDie(mock);
		Die copyDie = die.roll();
		assertThat(copyDie.getPips()).isGreaterThan(0).isLessThan(7);
	}
	
	
	@Test
	@Category(value=UnitTest.class)
	public void testBUG401EasyMock() {
		Random mock = createMock(Random.class);

		// rehearse
		expect(mock.nextInt(6)).andReturn(4);

		// replay(EasyMock Only)
		replay(mock);

		// run test
		Die die = new JavaRandomDie(mock);
		Die copyDie = die.roll();
		assertThat(copyDie.getPips()).isGreaterThan(0).isLessThan(7);

		// verify
		verify(mock);
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testBUG401EasyMockWithZero() {
		Random mock = createMock(Random.class);

		// rehearse
		expect(mock.nextInt(6)).andReturn(0);

		// replay(EasyMock Only)
		replay(mock);

		// run test
		Die die = new JavaRandomDie(mock);
		Die copyDie = die.roll();
		assertThat(copyDie.getPips()).isGreaterThan(0).isLessThan(7);

		// verify
		verify(mock);
	}
}




