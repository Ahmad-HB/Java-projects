
public interface IlinkedList {
	
	void addFirst(int val);
    void addLast(int val);
    void printLinkedList();
    void removeFirst();
    void removeLast();
    boolean search(int val);
    void deleteSpecificElement(int val);
    void addAtPosition(int val, int pos);
    void addZeroNode();
}
