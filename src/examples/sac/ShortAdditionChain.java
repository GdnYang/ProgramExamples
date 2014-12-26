package examples.sac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

public class ShortAdditionChain {

	public static void main(String args[]) {
		
		//int nx = 9;
		//int nx = 15;
		//int nx = 40;
		//int nx = 91;
		//int nx = 999;
		//int nx = 1087;
		int nx = 31415;
		
		System.out.println("Generate Short Addition Chain for Positive Integer = " + nx);
		List<Integer> bin_listSet = gen_binary(nx);
		System.out.println("Binary --- Addition Chain "+ bin_listSet);
		System.out.println("Small Number of Multiplications = "+ (bin_listSet.size()-1));
	
		List<Integer> tri_listSet = gen_trinary(nx);
		System.out.println("Trinary --- Addition Chain "+ tri_listSet);
		System.out.println("Small Number of Multiplications = "+ (tri_listSet.size()-1));
		
		List<Integer> quad_listSet = gen_quadrinary(nx);
		System.out.println("Quadrinary --- Addition Chain "+ quad_listSet);
		System.out.println("Small Number of Multiplications = "+ (quad_listSet.size()-1));
	}
	
	
	
	/**
	 * Generate addition chain by "original" Binary method:
	 * 
	 * if nx is even, then put nx/2 in the set
	 * else (nx is odd), then put nx/2 + 1 and nx/2 in the set
	 * 
	 * @param nx
	 * @return List<Integer> list
	 */
	
	public static List<Integer> gen_binary(int nx) {
		Integer ne = new Integer(nx);
		Set<Integer> retSet = new HashSet<Integer>();
		retSet.add(ne);
		while(ne != 1) {
			if (ne%2 == 0) {
				ne = ne/2;
				retSet.add(ne);
			} else {
				ne = ne/2;
				retSet.add(ne + 1);
				retSet.add(ne);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(retSet);
		Collections.sort(list);
		return list;
	}
	
	/**
	 * Generate short addition chain by "Trinary" method:
	 * 
	 * if nx is even, then put nx/2 in the set
	 * else if nx is divisible by 3, then put 2*(nx/3) and (nx/3);
	 * else (nx is odd and not divisible by 3), then put nx/2 + 1 and nx/2 in the set
	 * 
	 * @param nx
	 * @return List<Integer> list
	 */
	
	public static List<Integer> gen_trinary(int nx) {
		Integer ne = new Integer(nx);
		Set<Integer> retSet = new HashSet<Integer>();
		retSet.add(ne);
		while(ne != 1) {
			if (ne%2 == 0) {
				ne = ne/2;
				retSet.add(ne);
			} else if (ne%3 == 0) {
				ne = ne/3;
				retSet.add(2*ne);
				retSet.add(ne);
			} else {
				ne = ne/2;
				retSet.add(ne + 1);
				retSet.add(ne);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(retSet);
		Collections.sort(list);
		return list;
	}
	
	/**
	 * Generate short addition chain by "Quadrinary" method:
	 * 
	 * if nx is even, then put nx/2 in the set
	 * else if nx is divisible by 3, then put 2*(nx/3) and (nx/3);
	 * else if nx is divisible by 5, then put 3*(nx/5) and 2*(nx/5);
	 * else (nx is odd and not divisible either 3 or 5), then put nx/2 + 1 and nx/2 in the set
	 * 
	 * @param nx
	 * @return List<Integer> list
	 */
	
	public static List<Integer> gen_quadrinary(int nx) {
		Integer ne = new Integer(nx);
		Set<Integer> retSet = new HashSet<Integer>();
		retSet.add(ne);
		while(ne != 1) {
			if (ne%2 == 0) {
				ne = ne/2;
				retSet.add(ne);
			} else if (ne%3 == 0) {
				ne = ne/3;
				retSet.add(2*ne);
				retSet.add(ne);
			} else if (ne%5 == 0) {
				ne = ne/5;
				retSet.add(3*ne);
				retSet.add(2*ne);
				ne = 2*ne;
			} else {
				ne = ne/2;
				retSet.add(ne + 1);
				retSet.add(ne);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(retSet);
		Collections.sort(list);
		return list;
	}
}
