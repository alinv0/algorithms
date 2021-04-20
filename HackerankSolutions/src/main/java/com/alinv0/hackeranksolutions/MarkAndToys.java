package com.alinv0.hackeranksolutions;

import java.util.Arrays;

public class MarkAndToys {
    public static final int d = 2;
    public int[] heap;
    public int[] sorted;
    public int heapsize;

    public boolean isFull() {
        return heapsize == heap.length;
    }

    public int parent(int i) {
        return (i - 1) / d;
    }

    public void insert(int x) {
        if (isFull()) {
            return;
        }

        heap[heapsize] = x;
        heapifyUp(heapsize);
        heapsize++;
    }

    public void heapifyUp(int i) {
        int temp = heap[i];
        while (i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
            heap[i] = temp;
        }
    }

    public boolean isEmpty() {
        return heapsize == 0;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapsize) {
            child = maxChild(i);
            if (temp < heap[child]) {
                heap[i] = heap[child];
            } else {
                break;
            }
            i = child;
        }
        heap[i] = temp;
    }

    private int delete(int x) {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }
        int key = heap[x];
        heap[x] = heap[heapsize - 1];
        heapsize--;
        heapifyDown(x);
        return key;
    }

    public int[] sort() {
        sorted = new int[heapsize];
        int i=0;
        while(heapsize > 0) {
            sorted[i++] = delete(0);
        }
        return sorted;
    }

    // Complete the maximumToys function below.
    int maximumToys(int[] prices, int k) {
        if (k == 0) {
            return 0;
        }

        heapsize = 0;
        heap = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            insert(prices[i]);
        }

        sort();

        int sum = 0;
        int count = 0;
        for (int i = sorted.length - 1; i > 0; i--) {
            if (sorted[i] + sum < k) {
                count++;
                sum += sorted[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] prices = {3, 7, 2, 9, 4};
        MarkAndToys m = new MarkAndToys();
        System.out.println(m.maximumToys(prices, 15));
        Arrays.stream(m.sorted).forEach(System.out::print);
    }
}
