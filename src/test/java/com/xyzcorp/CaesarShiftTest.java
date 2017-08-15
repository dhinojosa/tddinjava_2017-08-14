package com.xyzcorp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CaesarShiftTest {

	//Inputs: String (string to be encoded), int (shift)
	//Output: String (string that has encoded)

	@Test
	public void testEmptyStringWithShiftOf0() {
		CaesarShift cs = new CaesarShift(0);
		String result = cs.encode("");
		assertEquals("", result);		
	}

	@Test
	public void testOneCharWithShiftOf0() {
		CaesarShift cs = new CaesarShift(0);
		String result = cs.encode("a");
		assertEquals("a", result);
	}

	@Test
	public void testOneCharWithShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		String result = cs.encode("a");
		assertEquals("b", result);
	}

	@Test
	public void testSmallZWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("z")).isEqualTo("a");
	}


	@Test
	public void testSmallZWithAShiftOf26times4() {
		CaesarShift cs = new CaesarShift(26 * 4);
		assertThat(cs.encode("z")).isEqualTo("z");
	}


	@Test
	public void testSmallZWithAShiftOf26times4plus1() {
		CaesarShift cs = new CaesarShift((26 * 4) + 1);
		assertThat(cs.encode("z")).isEqualTo("a");
	}


	@Test
	public void testThatStringIsNullClassicRightWay() {
		CaesarShift cs = new CaesarShift(1);
		try {
			cs.encode(null);
			fail("This line should never be evaluated");
		} catch (NullPointerException e) {
			assertThat(e).hasMessage(CaesarShift.THE_STRING_CANNOT_BE_NULL_MSG);
		}
	}


	@Test(expected = NullPointerException.class)
	public void testThatStringIsNullExpectedExceptionWrongWay() {
		CaesarShift cs = new CaesarShift(1);
		cs.encode(null);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testThatStringIsNullUsingJUnitRuleRightWay() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage(CaesarShift.THE_STRING_CANNOT_BE_NULL_MSG);
		CaesarShift cs = new CaesarShift(1);
		cs.encode(null);
	}

	@Test
	public void testThatStringIsNullUsingAssertJFunctionRightWay() {
		CaesarShift cs = new CaesarShift(1);
		assertThatThrownBy(() -> cs.encode(null))
		    .hasMessage(CaesarShift.THE_STRING_CANNOT_BE_NULL_MSG)
		    .isInstanceOf(NullPointerException.class);		
	}
	
	@Test
	public void testUpperCaseAWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("A")).isEqualTo("B");
	}
	
	@Test
	public void testUpperCaseZWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("Z")).isEqualTo("A");
	}

	@Test
	public void testSpecialCharacterWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("!")).isEqualTo("!");
	}

	//GreenBar
	@Test
	public void testNegativeOfSmallBNegativeShiftOf1() {
		CaesarShift cs = new CaesarShift(-1);
        assertThat(cs.encode("b")).isEqualTo("a");
	}

	@Test
	public void testNegativeOfSmallANegativeShiftOf1() {
		CaesarShift cs = new CaesarShift(-1);
		assertThat(cs.encode("a")).isEqualTo("z");
	}

	@Test
	public void testDecodeEmptyStringWithShiftOf0() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.decode("")).isEqualTo("");
	}

	@Test
	public void testOneCharWithDecodeShiftOf0() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.decode("a")).isEqualTo("a");
	}

	@Test
	public void testOneCharDecodeShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("b")).isEqualTo("a");
	}

	@Test
	public void testThatStringIsNullDecodeUsingAssertJFunctionRightWay() {
		CaesarShift cs = new CaesarShift(1);
		assertThatThrownBy(() -> cs.decode(null))
				.hasMessage(CaesarShift.THE_STRING_CANNOT_BE_NULL_MSG)
				.isInstanceOf(NullPointerException.class);
	}

	@Test
	public void testUpperCaseADecodeWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("A")).isEqualTo("Z");
	}

	@Test
	public void testDecodeSpecialCharacterWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("!")).isEqualTo("!");
	}

	@Test
	public void testEncodeStringShiftOf0() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.encode("Hello")).isEqualTo("Hello");
	}

	@Test
	public void testEncodeStringShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("Hello")).isEqualTo("Ifmmp");
	}

	@Test
	public void testDecodeStringShiftOf0() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.decode("Ifmmp")).isEqualTo("Ifmmp");
	}

	@Test
	public void testDecodeStringShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("Ifmmp")).isEqualTo("Hello");
	}

	@Test
	public void testEncodeDecodeStringShiftOf4() {
		CaesarShift cs = new CaesarShift(4);
		assertThat(cs.decode(cs.encode("Hello World!"))).isEqualTo("Hello World!");
	}
}
