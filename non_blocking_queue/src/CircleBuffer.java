
public class CircleBuffer {
	private int[] items;
	
	private int head = 0;
	private int tail = 0;
	private int mod = 0;
	
	public CircleBuffer(int size) {
		this.mod = size -1;
		this.items = new int[size];
	}
	
	public boolean enqueue(int i) {
		if(size() == mod) {
			return false;
		}
		int h = this.head;
		this.items[h] = i;
		this.head = (h + 1) & mod;
		return true;
	}
	
	public int dequeue() {
		if (this.head == this.tail) {
			return -1;
		}
		
		int t = this.tail;
		int value = this.items[t];
		this.tail = (t + 1) & mod;
		return value;
	}
	
	public int size() {
		return this.head - this.tail;
	}
	
	public boolean isEmpty() {
		return this.head == this.tail;
	}
}
