public class CircularLinkedList {

    private NodeType head;
    private NodeType currentPos;

    // Constructor
    public CircularLinkedList() {
        this.head = null;
        this.currentPos = null;
    } // SortedLinkedList

    /**
     * get head value
     * 
     * @return NodeType head
     */
    public NodeType getHead() {
        return head;
    } // getHead

    /**
     * Print the list of values
     */
    public void printList() {
        currentPos = head;
        if (head == null) {
            System.out.println("This is a empty list");
            return;
        } 
        do {
            currentPos = currentPos.next;
            System.out.print(currentPos.info.getValue() + " ");
        } while (currentPos != head);
        System.out.println();
    } // printList

    /**
     * Get the length of the current list
     */
    public int getLength() {
        NodeType temp = new NodeType();
        temp = head;
        int len = 0;
        do {
            temp = temp.next;
            len++;
        } while (temp != head);
        return len;
    } // getLength

    /**
     * Insert a item with into the list and in sorted order
     * 
     * @param item - ItemType
     */
    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType();
        newNode.info = item;
        currentPos = head;
        if (head == null) { // insert in a empty list
            head = newNode;
            newNode.next = head;
        } else if (item.compareTo(head.info) == 1 && item.compareTo(head.next.info) != 0) {
            newNode.next = head.next;
            head.next = newNode;
            head = newNode;
        } else if (item.compareTo(head.info) == -1) {
            while (currentPos.next != head && item.compareTo(currentPos.next.info) == 1) {
                currentPos = currentPos.next;
            } // while
            if (item.compareTo(currentPos.next.info) == 0) {
                System.out.println("Item already exist");
                return;
            } else {
                newNode.next = currentPos.next;
                currentPos.next = newNode;
            } //if/else
         } else {
            System.out.println("Item already exist");
         }
         currentPos = head;
    } // insertItem

    /**
     * Delete existing item from the list
     * 
     * @param item - ItemType
     */
    public void deleteItem(ItemType item) {
        currentPos = head;
        NodeType prevPos = currentPos;
        if (head == null) { // check empty list
            System.out.println("The list is Empty item can't not be deleted");
            return;
        } else if (searchItem(item) == -1) { // look to see if item is in the list
            System.out.println("The item is not present in the list");
            return;
        } else if (item.compareTo(head.info) == 0) { // delete the only node
            if (head.next == head) {
                head = null;
            } else {
                do {
                    prevPos = prevPos.next;
                } while (prevPos.next != head); // do/while
                prevPos.next = currentPos.next;
                head = prevPos; 
            } // if/else
        } else {
            currentPos = currentPos.next;
            while (prevPos.next != head) {
                if (item.compareTo(currentPos.info) == 0) {
                    prevPos.next = currentPos.next;
                } // if
                prevPos = prevPos.next;
                currentPos = currentPos.next;
            } // while
        } // else
    } // deleteItem

    /**
     * search through the list and return the index of that value
     * 
     * @param item - ItemType
     * @return int index of searched item
     */
    public int searchItem(ItemType item) {
        NodeType temp = new NodeType();
        temp = head;
        int index = 1;
        do {
            temp = temp.next;
            if (item.compareTo(temp.info) == 0) {
                return index;
            }
            index++;
        } while (temp != head); // do/while
        return -1;
    } // searchItem

    /**
     * Reversed the linked list
     * 
     * @param list - CircularLinkedList
     * @return reversed CircularLinkedList
     */
    public void reverseList(CircularLinkedList list) {
        NodeType prevPos = null;
        NodeType temp = head;
        NodeType tempHead = head;
        if (head == null) {
            head = null;
        } else if (head.next == head) {
            head = head;
        } else {
            head = tempHead.next;
            do {
                temp = currentPos.next;
                currentPos.next = prevPos;
                prevPos = currentPos;
                currentPos = temp;
            } while (currentPos != tempHead);
            temp.next = prevPos;
        } // if/else
    } // reverseList

} // CircularLinkedList
