
public class SimpleQueue implements Queue {

	private int size;
	private volatile CircleBuffer queue;

	public SimpleQueue(int size) {
		this.size = size;
		this.queue = new CircleBuffer(size);
	}

	@Override
	public synchronized boolean enqueue(int item) {
		try {
			while (this.queue.size() == this.size) {
				wait();
			}
			if (this.queue.isEmpty()) {
				notify();
			}
			this.queue.enqueue(item);
		} catch (Exception ex) {
			return false;
		}

		return true;

	}

	@Override
	public synchronized int dequeue() {
		try {
			while (this.queue.isEmpty()) {
				wait();
			}

			if (this.queue.size() == this.size) {
				notify();
			}

			return (int) this.queue.dequeue();
		} catch (Exception ex) {
			return -1;
		}

	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
