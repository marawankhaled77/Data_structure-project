public class LinkedListSingle {
public Node head;

public LinkedListSingle()
{
    head = null;
}




public boolean isEmpty() {
if (head == null)
{
    return true;
}    else return false;

}




public void add(Object data) {
    Node node =new Node(data);

    if (isEmpty())
    {
        head = node;
    }
    else
    {
        Node temp=head;
        while (temp.next != null)
        {
        temp = temp.next;
        }
    temp.next = node;
    }
}
public void deleteFromHead() {
if (isEmpty()) {
    System.out.println("List is empty");
    return;
}
head = head.next;
}



public void endDelete() {
Node temp=head;
while (temp.next.next != null) {
    temp=temp.next;
}
    temp.next = null;

}



public void display() {
    Node temp=head;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;

    }
    System.out.println("null");
}




public void deleteIn(int data) {
    if (isEmpty())
    {
        return;
    }
    else if (head.data.equals(data)) {
        head = head.next;
    }
    else
    {
    Node temp=head;
    Node prev=null;
    while (!temp.data.equals(data) ) {
        prev=temp;
        temp = temp.next;
    }
    prev.next=temp.next;
    }
}
    public void DeleteApp(int data) {
        if (isEmpty()) {
            System.out.println("Error: List is empty. Cannot delete appointment.");
            return;
        }

        Appointment headData = (Appointment) head.data;

        if (headData.getAppointmentID() == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Appointment tempData = (Appointment) temp.data;
            if (tempData.getAppointmentID() == data) {
                if (prev != null) {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Error: Appointment with ID " + data + " not found.");
    }

public void insertFirst(int data) {
    Node newNode = new Node(data);
 if (isEmpty()) {
     head = newNode;
 }
 else
 {
   newNode.next = head;
 }



}






}
