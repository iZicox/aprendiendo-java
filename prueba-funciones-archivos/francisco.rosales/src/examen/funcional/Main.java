package examen.funcional;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a1 = {2};
		int[] a2 = {1,3};
		double a = findMedianSortedArrays(a1,a2);
		System.out.println(a);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> lista = new ArrayList<Integer>();
        Arrays.asList(nums1).stream().forEach(c -> {
        	for (Integer integer : c) {
				lista.add(integer);
			}
        });
        Arrays.asList(nums2).stream().forEach(c -> {
        	for (Integer integer : c) {
				lista.add(integer);
			}
        });
        							;
        
        return lista.stream()
        				.mapToDouble(c -> c)
        				.average()
        				.orElseThrow();
    }

}
