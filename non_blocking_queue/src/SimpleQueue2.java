
public class SimpleQueue2 implements Queue {

	private volatile CircleBuffer queue;

	public SimpleQueue2(int size) {
		this.queue = new CircleBuffer(size);
	}

	@Override
	public boolean enqueue(int item) {
		return this.queue.enqueue(item);
	}

	@Override
	public int dequeue() {
			return (int) this.queue.dequeue();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
