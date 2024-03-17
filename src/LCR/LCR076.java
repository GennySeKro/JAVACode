package LCR;

public class LCR076 {
    /*
    数组中的第k个最大元素
     */

    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {//将前k个元素放入堆中
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {//遍历剩余元素，如果比堆顶元素大，就替换堆顶元素
            if (nums[i] > heap.peek()) {
                heap.replace(nums[i]);
            }
        }
        return heap.peek();
    }

    class MinHeap {//最小堆
        int[] array;
        int size;

        public MinHeap(int capacity) {
            array = new int[capacity];
        }

        public int peek() {
            return array[0];
        }

        //替换堆顶元素，并保持堆的性质
        public void replace(int replaced) {
            array[0] = replaced;
            down(0);
        }

        //向堆中添加一个元素，并保持堆的性质。
        public void offer(int offered) {
            array[size] = offered;
            up(size);
            size++;
        }

        //将指定位置的元素向上移动，以保持堆的性质。
        public void up(int index) {
            int child = index;
            while (child > 0) {
                int parent = (child - 1) >> 1;
                if (array[child] < array[parent]) {
                    swap(child, parent);
                    child = parent;
                } else {
                    break;
                }
            }
        }

        //将指定位置的元素向下移动，以保持堆的性质。
        public void down(int index) {
            int left = index * 2 + 1;
            int right = left + 1;
            int min = index;
            if (left < size && array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != index) {
                swap(min, index);
                down(min);
            }
        }

        //交换堆中两个位置的元素。
        public void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}
