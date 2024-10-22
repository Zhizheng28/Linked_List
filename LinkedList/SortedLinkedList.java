public class SortedLinkedList {

    private NodeType head;
    private NodeType currentPos;

    //Constructor
    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    } // SortedLinkedList

    /*
     * get head value
     * @return NodeType head
     */
    public NodeType getHead() {
        return head;
    } // getHead

    /*
     * Print the list of values
     */
    public void printList() {
        NodeType temp = new NodeType();
        temp = head;
        while (temp != null) {
            System.out.print(temp.info.getValue() + " ");
            temp = temp.next;
        } // while
        System.out.println();
    } // printList

    /*
     * Get the length of the current list
     */
    public int getLength() {
        NodeType temp = new NodeType();
        temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        } // while
        return len;
    } // getLength
    
    
    /*
     * Insert a item with into the list and in sorted order
     * @param item - ItemType
     */
    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType();
        newNode.info = item;
        currentPos = head;
        if (head == null) { // insert in a empty list
            head = newNode;
            currentPos = head;
        } else {
            while (currentPos != null && item.compareTo(currentPos.info) != 0) {
                if (item.compareTo(currentPos.info) == -1) { // insert before
                    newNode.next = currentPos;
                    head = newNode;
                    return;
                }
                if (currentPos.next == null) { // insert at the end
                    if (item.compareTo(currentPos.info) == 1) {
                        currentPos.next = newNode;
                        return;
                    } else {
                        currentPos = head;
                    }
                } else {
                    if (item.compareTo(currentPos.info) == 1 && item.compareTo(currentPos.next.info) == -1) { //insert in between
                        newNode.next = currentPos.next;
                        currentPos.next = newNode;
                        return;
                    } else {
                        currentPos = currentPos.next; // move current position to next and check
                    }
                } // if/else
            } // while
            currentPos = head;
            System.out.println("Sorry. You cannot insert the duplicate item"); // print duplicate
        } // if/else
    } // insertItem

    /*
    * Delete existing item from the list
    * @param item - ItemType
    */
    public void deleteItem(ItemType item) {
        currentPos = head;
        NodeType prevLoc = currentPos;
        if (head == null) { // check empty list
            System.out.println("The list is Empty item can't not be deleted");
        } else if (searchItem(item) == -1) { // look to see if item is in the list
                System.out.println("Item Not Found");
                return;
        } else if (item.compareTo(currentPos.info) == 0) { // delete first value
            head = head.next;
        } else {
            do {
                prevLoc = currentPos;
                if (currentPos.next == null) { // delete only 1 value in list
                    currentPos = null;
                    return;
                } else { // move current position to next
                    currentPos = currentPos.next;
                }
            } while (item.compareTo(currentPos.info) != 0);
            prevLoc.next = currentPos.next; // connect list after deleting value
        } // else 
    } // deleteItem

    /*
     * search through the list and return the index of that value
     * @param item - ItemType
     * @return int index of searched item
     */
    public int searchItem(ItemType item) {
        NodeType temp = new NodeType();
        int index = 1;
        temp = head;
        while (temp != null) {
            if (item.compareTo(temp.info) == 0) {
                return index;
            } 
            index++;
            temp = temp.next;
        }
        return -1; // item is not in list
    } // searchItem

    /*
     * merge two list with no duplicates
     * @param list1, list2 - SortedLinkedList
     * @return a list that was merged into
     */
    public SortedLinkedList mergeListOG(SortedLinkedList list1, SortedLinkedList list2) {
        NodeType list2temp = head; // added change
        while (list2.currentPos != null) {
            list1.insertItem(list2.currentPos.info);
            list2.currentPos = list2.currentPos.next;

        }
        currentPos = head;
        return list1;
    } // mergeList

    public SortedLinkedList mergeList(SortedLinkedList list1, SortedLinkedList list2) {
        NodeType temp = list2.head;
        while (temp != null){
            int val = temp.info.getValue();
            ItemType tempItem = new ItemType(val);
            list1.insertItem(tempItem);
            temp = temp.next;
        }
        return list1;
    } // mergeList


    /*
     * delete alternate nodes from the list
     * @param delList - SortedLinkedList
     */
    public void deleteAlternateNodes(SortedLinkedList delList) {
        int counter = 1;
        int len = delList.getLength(); 
        currentPos = head;
        if (head == null) { // if list is null
            return;
        }
        if (head.next == null) { // if only 1 element in the list
            return;
        }
        while (currentPos != null && counter <= len + 1) {
            if (counter % 2 != 0 && counter != 0) { // delete even index value
                delList.deleteItem(delList.currentPos.next.info);
                currentPos = currentPos.next;
            } else if (currentPos.next == null) { // reach end of the list
                break;
            }
            counter++;
        }
    } // deleteAlternateNodes

} // SortedLinkedList