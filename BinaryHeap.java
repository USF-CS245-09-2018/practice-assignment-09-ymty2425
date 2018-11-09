public class BinaryHeap{
	private int [] arr;
	private int size;

	public BinaryHeap(){
		arr = new int[10];
		size = 0;
	}

	public void swap(int[] arr, int i, int j){
		int temp  = arr[i];
		arr[i] = arr[j];
		arr[j]  = temp;
	}

	public void add(int pri){
		if(size == arr.length){
			grow_array();
		}
		arr[size] = pri;
		++size;
		int i = size - 1;
		int parent = (i-1)/2;
		while(i > 0 && arr[i] < arr[parent]){
			swap(arr,i,parent);
			i = parent;
			parent = (i -1)/2;

		}
	}

	public int remove(){
		int pri = arr[0];
		arr[0] = arr[size - 1];
		--size;
		if (size != 0) {
			shiftdown(0);
		}
		
		return pri;
	}

	public void shiftdown(int parent){
		int child = parent * 2 + 1;

		if (child >= size){
			return;
		}
		if (arr[child + 1] < arr[child]){
			child++;
		}
		if (arr[parent] > arr[child]){
			swap(arr, child, parent);
			shiftdown(child);
		}
	}

	public void grow_array(){
		int [] newArr = new int[arr.length * 2];
		for (int i = 0;i < arr.length ;i++ ) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}	
}