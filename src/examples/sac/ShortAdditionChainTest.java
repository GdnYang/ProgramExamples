package examples.sac;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class ShortAdditionChainTest {
	
	@Test
	public final void testGen_binary() {
		// N = 9,  smallest number of multiplication = 4
		// Computed Addition Chain [1, 2, 4, 5, 9]
		List<Integer> setForN = ShortAdditionChain.gen_binary(9);
		assertEquals(4, setForN.size()-1);
		
		// N = 15, smallest number of multiplication = 6 
		// Computed Addition Chain  [1, 2, 3, 4, 7, 8, 15]
		setForN = ShortAdditionChain.gen_binary(15);
		assertEquals(5, setForN.size()-1);
		
		// N = 40, smallest number of multiplication = 6 
		// Computed Addition Chain [1, 2, 3, 5, 10, 20, 40]
		setForN = ShortAdditionChain.gen_binary(40);
		assertEquals(6, setForN.size()-1);
		
		// N = 91, smallest number of multiplication = 10
		// Computed Addition Chain [1, 2, 3, 5, 6, 11, 22, 23, 45, 46, 91]
		setForN = ShortAdditionChain.gen_binary(91);
		assertEquals(9, setForN.size()-1);
		
		// N = 999, smallest number of multiplication = 16
		// Computed Addition Chain [1, 2, 3, 4, 7, 8, 15, 16, 31, 62, 124, 125, 249, 250, 499, 500, 999]
		setForN = ShortAdditionChain.gen_binary(999);
		assertEquals(13, setForN.size()-1);
		
		// N = 1087, smallest number of multiplication = 16
		// Computed Addition Chain [1, 2, 4, 8, 16, 17, 33, 34, 67, 68, 135, 136, 271, 272, 543, 544, 1087]
		setForN = ShortAdditionChain.gen_binary(1087);
		assertEquals(14, setForN.size()-1);
		
		
		// N = 31415, smallest number of multiplication = 19 but computed result = 24 
		// Computed Addition Chain [1, 2, 3, 4, 7, 8, 15, 30, 31, 61, 122, 123, 245, 490, 491,
		//                          981, 982, 1963, 3926, 3927, 7853, 7854, 15707, 15708, 31415]
		// therefore, for n > 1087, it only give a short but not shortest answer !
		setForN = ShortAdditionChain.gen_binary(31415);
		assertEquals(19, setForN.size()-1); 
	}

	@Test
	public final void testGen_trinary() {
		// N = 9,  smallest number of multiplication = 4
		// Computed Addition Chain [1, 2, 3, 6, 9]
		List<Integer> setForN = ShortAdditionChain.gen_trinary(9);
		assertEquals(4, setForN.size()-1);
		
		// N = 15, smallest number of multiplication = 5 
		// Computed Addition Chain [1, 2, 3, 5, 10, 15]
		setForN = ShortAdditionChain.gen_trinary(15);
		assertEquals(5, setForN.size()-1);
		
		// N = 40, smallest number of multiplication = 6 
		// Computed Addition Chain [1, 2, 3, 5, 10, 20, 40]
		setForN = ShortAdditionChain.gen_trinary(40);
		assertEquals(6, setForN.size()-1);
		
		// N = 91, smallest number of multiplication = 9
		// Computed Addition Chain [1, 2, 3, 5, 10, 15, 30, 45, 46, 91]
		setForN = ShortAdditionChain.gen_trinary(91);
		assertEquals(9, setForN.size()-1);
		
		// N = 999, smallest number of multiplication = 13
		// Computed Addition Chain [1, 2, 3, 6, 9, 18, 19, 37, 74, 111, 222, 333, 666, 999]
		setForN = ShortAdditionChain.gen_trinary(999);
		assertEquals(13, setForN.size()-1);
		
		// N = 1087, smallest number of multiplication = 14
		// Computed Addition Chain [1, 2, 3, 5, 10, 15, 30, 45, 90, 91, 181, 362, 543, 544, 1087]
		setForN = ShortAdditionChain.gen_trinary(1087);
		assertEquals(14, setForN.size()-1);
		
		// This method no longer give the shortest addition chain after 1087.
		// e.g. N = 31415, smallest number of multiplication = 19 but computed result = 22 
		// Computed Addition Chain [1, 2, 3, 6, 9, 18, 27, 54, 55, 109, 218, 327, 654, 981, 982, 
		//                          1963, 3926, 3927, 7853, 7854, 15707, 15708, 31415]
		// therefore, for n > 1087, it only give a short but not shortest answer !
		setForN = ShortAdditionChain.gen_trinary(31415);
		assertEquals(19, setForN.size()-1); 
	}

	@Test
	public final void testGen_quadrinary() {
		// N = 9,  smallest number of multiplication = 4
		// Computed Addition Chain [1, 2, 3, 6, 9]
		List<Integer> setForN = ShortAdditionChain.gen_quadrinary(9);
		assertEquals(4, setForN.size()-1);
		
		// N = 15, smallest number of multiplication = 5 
		// Computed Addition Chain [1, 2, 3, 5, 10, 15]
		setForN = ShortAdditionChain.gen_quadrinary(15);
		assertEquals(5, setForN.size()-1);
		
		// N = 40, smallest number of multiplication = 6 
		// Computed Addition Chain [1, 2, 3, 5, 10, 20, 40]
		setForN = ShortAdditionChain.gen_quadrinary(40);
		assertEquals(6, setForN.size()-1);
		
		// N = 91, smallest number of multiplication = 9
		// Computed Addition Chain [1, 2, 3, 5, 10, 15, 30, 45, 46, 91]
		setForN = ShortAdditionChain.gen_quadrinary(91);
		assertEquals(9, setForN.size()-1);
		
		// N = 999, smallest number of multiplication = 13
		// Computed Addition Chain [1, 2, 3, 6, 9, 18, 19, 37, 74, 111, 222, 333, 666, 999]
		setForN = ShortAdditionChain.gen_quadrinary(999);
		assertEquals(13, setForN.size()-1);
		
		// N = 1087, smallest number of multiplication = 14
		// Computed Addition Chain [1, 2, 3, 5, 10, 15, 30, 45, 90, 91, 181, 362, 543, 544, 1087]
		setForN = ShortAdditionChain.gen_quadrinary(1087);
		assertEquals(14, setForN.size()-1);
		
		// This method no longer give the shortest addition chain after 1087.
		// e.g. N = 31415, smallest number of multiplication = 19 but computed result = 21 
		// Computed Addition Chain [1, 2, 3, 4, 7, 14, 15, 29, 58, 87, 174, 175, 349, 698, 
		//                          1047, 2094, 3141, 3142, 6283, 12566, 18849, 31415]
		// therefore, for n > 1087, it only give a short but not shortest answer !
		setForN = ShortAdditionChain.gen_quadrinary(31415);
		assertEquals(19, setForN.size()-1); 
	}

}
