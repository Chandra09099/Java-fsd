package com.demo;

public class LinkedList {
    // Node class declaration
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // Head of the linked list

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // Method to delete a node with a given key
    public void deleteByKey(int key) {
        Node currNode = head, prev = null;

        if (currNode != null && currNode.data == key) {
            head = currNode.next;
            System.out.println(key + " found and deleted");
            return;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        } else {
            System.out.println(key + " not found");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);

        list.printList();
        list.deleteByKey(1);
        list.printList();
        list.deleteByKey(4);
        list.printList();
        list.deleteByKey(10);
        list.printList();
    }
}
