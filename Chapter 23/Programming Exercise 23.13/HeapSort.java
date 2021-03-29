/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarksort;

import java.util.ArrayList;

/**
 *
 * @author martinfall
 */
public class HeapSort {

    /**
     * Sorts a list using the heap sort algorithm.
     *
     * @param list
     */
    public static void heapSort(Integer[] list) {
        // Create a Heap of integers
        Heap heap = new Heap(list);

        // Remove elements from the heap and rewrite list
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
