
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	
	public void swapNode(DListIterator i1, DListIterator i2) throws Exception {
		if(this.isEmpty())
			throw new Exception("empty list");
		if(i1.currentNode == null || i2.currentNode == null)
			throw new Exception("null node found");
		DListNode p1 = i1.currentNode.previousNode;
		DListNode n1 = i1.currentNode.nextNode;
		DListNode p2 = i2.currentNode.previousNode;
		DListNode n2 = i2.currentNode.nextNode;
		p1.nextNode = i2.currentNode;
		n1.previousNode = i2.currentNode;
		p2.nextNode = i1.currentNode;
		n2.previousNode = i1.currentNode;
		i1.currentNode.nextNode = n2;
		i1.currentNode.previousNode = p2;
		i2.currentNode.nextNode = n1;
		i2.currentNode.previousNode = p1;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		if(lst.isEmpty()) return;
		DListIterator i2 = new DListIterator(lst.header);
		DListNode p = i2.currentNode.previousNode;
		DListNode n = i2.currentNode.nextNode;
		p.nextNode = i1.currentNode.nextNode;
		n.previousNode = i1.currentNode;
		i1.currentNode.nextNode.previousNode = p;
		i1.currentNode.nextNode = n;	
	}

	// implement this method
	public void gender(String g) throws Exception {
		if(this.isEmpty())
			throw new Exception("empty list");
		DListIterator itr = new DListIterator(header);
		DListIterator save = new DListIterator(header);
		while (itr.currentNode.nextNode != header) {
			Object v = itr.next();
			if(!(v instanceof Student))
				throw new Exception();
			Student s = (Student)v;
			if(s.getSex().equals(g)) {
				this.insert(s, save);
				this.removeAt(itr);
				save.next();
			}
		}
	}

}
