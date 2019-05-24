/************************************************************************
 * Created: 13/04/2018                                                  *
 * Author: Breogan Costa                                                *
 ************************************************************************/

import adt.graph.undirected.Graph;
import adt.graph.undirected.GraphNode;
import adt.trees.BinarySearchTree;
import javalibs.ComparatorTests;
import lombok.extern.java.Log;

import java.util.*;

@Log
public class AppController {

  public static void main(String[] args) {
    test1Graph();

    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    list
  }

  private static void testsComparator() {
    ComparatorTests<Integer> komparator = new ComparatorTests<>(2, 5);
    komparator.compareToTests();
  }

  private static void test1BinaryTree() {
    /*
                      6
                    /   \
                   /     \
                 4         8
               /   \      /  \
              /     \    /    \
             2       5  7      9
     */
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(6);
    binarySearchTree.insert(4);
    binarySearchTree.insert(8);
    binarySearchTree.insert(2);
    binarySearchTree.insert(5);
    binarySearchTree.insert(7);
    binarySearchTree.insert(9);
    System.out.println("Deep First Search");
    binarySearchTree.deepFirst(binarySearchTree);
    System.out.println("Breadth First Search");
    binarySearchTree.breadthFirst(binarySearchTree);
  }

  private static void test2BinaryTree() {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(1);
    binarySearchTree.insert(2);
    binarySearchTree.insert(3);
    binarySearchTree.insert(4);
    binarySearchTree.insert(5);
    binarySearchTree.insert(6);
    binarySearchTree.deepFirst(binarySearchTree);
    System.out.println("Looking for values 2, 10 and 4");
    //System.out.println(binarySearchTree.find(binarySearchTree, 1));
    binarySearchTree.find(binarySearchTree, 2).ifPresent(
            bst -> System.out.println(bst.getData()));

    binarySearchTree.find(binarySearchTree, 10).ifPresent(
            bst -> System.out.println(bst.getData()));

    binarySearchTree.find(binarySearchTree, 4).ifPresent(
            bst -> System.out.println(bst.getData()));
  }

  private static void test3BinaryTree() {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(2);
    binarySearchTree.insert(5);
    binarySearchTree.insert(6);
    binarySearchTree.insert(1);
    binarySearchTree.insert(3);
    binarySearchTree.insert(4);
    binarySearchTree.insert(7);
    binarySearchTree.insert(11);
    binarySearchTree.insert(8);
    binarySearchTree.insert(9);
    binarySearchTree.insert(10);
    binarySearchTree.deepFirst(binarySearchTree);
    System.out.println("Looking for values 2, 10 and 4");
//    Optional<BinarySearchTree<Integer>> value = binarySearchTree.find(binarySearchTree, 10);
    binarySearchTree.find(binarySearchTree, 2).ifPresent(
            bst -> System.out.println(bst.getData()));

    binarySearchTree.find(binarySearchTree, 10).ifPresent(
            bst -> System.out.println(bst.getData()));

    binarySearchTree.find(binarySearchTree, 4).ifPresent(
            bst -> System.out.println(bst.getData()));
  }

  private static void test4BinaryTree() {
    /*
                      7
                    /   \
                   /     \
                  5       20
                /        /  \
               /        /    \
              4       18     25
             /       /  \      \
            2      11   19     33
          /  \      \          /
         1    3      14       28
                    /  \       \
                   12  15       31
                                 \
                                 32
     */
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(7);
    binarySearchTree.insert(5);
    binarySearchTree.insert(20);
    binarySearchTree.insert(4);
    binarySearchTree.insert(2);
    binarySearchTree.insert(1);
    binarySearchTree.insert(3);
    binarySearchTree.insert(18);
    binarySearchTree.insert(25);
    binarySearchTree.insert(11);
    binarySearchTree.insert(19);
    binarySearchTree.insert(14);
    binarySearchTree.insert(12);
    binarySearchTree.insert(15);
    binarySearchTree.insert(33);
    binarySearchTree.insert(28);
    binarySearchTree.insert(31);
    binarySearchTree.insert(32);
    binarySearchTree.breadthFirst(binarySearchTree);
    System.out.println("Height " + binarySearchTree.getHeight());
    System.out.println("Removing 7");
    binarySearchTree.delete(32);
    System.out.println("Height " + binarySearchTree.getHeight());
    //binarySearchTree.breadthFirst(binarySearchTree);
  }

  private static void test5BinaryTree() {
    /*
                  80
                  /
                 4
                / \
               2   14
              /   /  \
             -1  6   15
               \  \    \
                0  9    16
                  /  \
                 8   13
                     /
                    12
     */
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(7);
    binarySearchTree.insert(5);
    binarySearchTree.insert(20);
    binarySearchTree.insert(4);
    binarySearchTree.insert(2);
    binarySearchTree.insert(1);
    binarySearchTree.insert(3);
    binarySearchTree.insert(18);
    binarySearchTree.insert(25);
    binarySearchTree.insert(11);
    binarySearchTree.insert(19);
    binarySearchTree.insert(14);
    binarySearchTree.insert(12);
    binarySearchTree.insert(15);
    binarySearchTree.insert(33);
    binarySearchTree.insert(28);
    binarySearchTree.insert(31);
    binarySearchTree.breadthFirst(binarySearchTree);
    System.out.println("Removing 7");
    binarySearchTree.delete(7);
    binarySearchTree.breadthFirst(binarySearchTree);
  }

  private static void test1Graph() {
    /*
                10   33
                / \
               1   9
                \ /  \
                 8   0
                /   /
               12  7
              /   /  \
             2 - 3   6
                 |   |
                 4   5
     */
    GraphNode n10, n1, n9, n8, n0, n12, n7, n2, n3, n6, n4, n5, n33;
    GraphNode n34;

    n34 = new GraphNode(34, Arrays.asList());
    n4 = new GraphNode(4, Arrays.asList());
    n5 = new GraphNode(5, Arrays.asList());
    n3 = new GraphNode(3, Arrays.asList(n4));
    n2 = new GraphNode(2, Arrays.asList(n3));
    n6 = new GraphNode(6, Arrays.asList(n5));
    n12 = new GraphNode(12, Arrays.asList(n2));
    n7 = new GraphNode(7, Arrays.asList(n3));
    n0 = new GraphNode(0, Arrays.asList(n7));
    n8 = new GraphNode(8, Arrays.asList(n12));
    n1 = new GraphNode(1, Arrays.asList(n8));
    n9 = new GraphNode(9, Arrays.asList(n8));
    n10 = new GraphNode(10, Arrays.asList(n1, n9));
    n33 = new GraphNode(33, Arrays.asList(n34));

    Graph graph = new Graph();
    graph.setNodes(Set.of(n10, n1, n9, n8, n0, n12, n7, n2, n3, n6, n4, n5, n33, n34));
    System.out.println("Finding 3 from 10");
    List<GraphNode> path = graph.findPath(n10, n3);
    printGraphNodesPath(path);

    System.out.print("Looking for 33 from 10. ");
    path = graph.findPath(n10, n33);
    printGraphNodesPath(path);
    System.out.print("Looking for 34 from 10. ");
    path = graph.findPath(n10, n34);
    printGraphNodesPath(path);
    System.out.print("Looking for 34 from 33. ");
    path = graph.findPath(n33, n34);
    printGraphNodesPath(path);
  }

  private static void printGraphNodesPath(List<GraphNode> path) {
    if( path.isEmpty() ) {
      System.out.println("No path found.");
      return;
    }
    System.out.println("Found path/s: ");
    Collections.reverse(path);
    for( GraphNode item : path ) {
      System.out.print(item.getNodeId() + " ");
    }
    System.out.println();
  }

  private static void mainTrangalleiro() {
//    LOG.info("hello trangallo");
//
//    Trangallo trangallo = new Trangallo(16,15,35);
//
//    System.out.println(trangallo.getContainerCapacityCC());
//    System.out.println(trangallo.getHeightCm());
  }
}
