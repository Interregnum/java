package amazonPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap.
 * @author Mengchao Zhong
 */
public class Heap {

	private List<Point> heap;

	/**
	 * Constructor of {@link Heap}.
	 */
	public Heap() {
		super();
		this.heap = new ArrayList<Point>();
		this.heap.add(new Point(0, 0));
	}
	
	/**
	 * Constructor of {@link Heap}.
	 * @param list
	 */
	public Heap(List<Point> list) {
		super();
		this.heap = new ArrayList<Point>();
		this.heap.add(new Point(0, 0));
		this.heap = build(list);
	}

	/**
	 * Return size of heap.
	 * @return
	 */
	public int size() {
		return this.heap == null ? 0 : this.heap.size();
	}

	/**
	 * Build heap;
	 * @param list
	 * @return
	 */
	public List<Point> build(List<Point> list) {
		for(Point node : list) {
			insert(node);
		}
		return this.heap;
	}
	
	/**
	 * Insert Point to heap.
	 * @param node
	 */
	public void insert(Point node) {
		if(null == node) {
			return;
		}
		this.heap.add(node);
		percolateUp(node);
	}
	
	/**
	 * Percolate up.
	 * @param node
	 */
	public void percolateUp(Point node) {
		if(null == node) {
			return;
		}
		
		for(int i = this.heap.size() - 1; i > 1; i /= 2) {
			if(node.compareTo(this.heap.get(i / 2)) > 0) {
				return;
			}
			else if(node.compareTo(this.heap.get(i / 2)) < 0) {
				this.heap.set(i, this.heap.get(i / 2));
				this.heap.set(i / 2, node);
			}
			else {
				this.heap.remove(this.heap.size() - 1);
				return;
			}
		}
		this.heap.set(1, node);
	}
	
	/**
	 * Delete minimum point in the heap.
	 * @return
	 */
	public Point deleteMin() {
		if(this.heap.size() < 2) {
			return null;
		}
		Point node = this.heap.get(1);
		percolateDown(node);
		return node;
	}
	
	/**
	 * Percolate down.
	 * @param node
	 */
	public void percolateDown(Point node) {
		if(null == node) {
			return;
		}
		int i = 0;
		for(i = 1; i <= this.heap.size() / 2 - 1;) {
			Point left = this.heap.get(2 * i);
			Point right = this.heap.get(2 * i + 1);
			
			if(null != left && null != right) {
				this.heap.set(i, left.compareTo(right) > 0 ? right : left);
				i = left.compareTo(right) > 0 ? 2 * i + 1 : 2 * i;
			}
			else if (null != right) {
				this.heap.set(i, right);
				i = 2 * i + 1;
			}
			else if (null != left) {
				this.heap.set(i, left);
				i = 2 * i;
			}
			else {
				break;
			}
		}
		this.heap.set(i, this.heap.get(this.heap.size() - 1));
		this.heap.remove(this.heap.size() - 1);
	}
}
