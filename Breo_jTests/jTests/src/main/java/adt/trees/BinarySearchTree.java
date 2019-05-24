package adt.trees;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

  private BinarySearchTree leftChild;

  private BinarySearchTree rigthChild;

  private BinarySearchTree<T> parent;

  private T data;

  private int height;
  private int deepness;

  public BinarySearchTree(T value) {
    leftChild = null;
    rigthChild = null;
    data = value;
    //System.out.println("Preparing to insert " + value);
  }

  public BinarySearchTree(T value, BinarySearchTree leftBranch, BinarySearchTree rightBranch) {
    leftChild = leftBranch;
    rigthChild = rightBranch;
    data = value;
  }

  /**
   * Insert a new value. If existing in the tree, it will be ignored
   *
   * @param value to insert in the tree
   */
  public void insert(T value) {
    int height_max_below = this.insert(value, this);
    if( this.height < height_max_below ) {
      this.height = height_max_below;
    }
  }

  private int insert(T value, BinarySearchTree<T> parent) {
    int height_max_below = 0;

    BinarySearchTree<T> node = new BinarySearchTree<>(value);
    node.setParent(parent);
    if( this.data.compareTo(value) == -1 ) {
      if( rigthChild == null ) {
        rigthChild = node;
        height_max_below = 1;
      } else {
        height_max_below = rigthChild.insert(value, rigthChild);
      }
    } else if( this.data.compareTo(value) == 1 ) {
      if( leftChild == null ) {
        leftChild = node;
        height_max_below = 1;
      } else {
        height_max_below = leftChild.insert(value, leftChild);
      }
    }
    if( this.height < height_max_below ) {
      this.height = height_max_below;
    }
    return height_max_below + 1;
  }

  public void delete(T value) {
    this.delete(this, value);
  }

  public int delete(BinarySearchTree<T> tree, T value) {
    int deletedNodeHeight = 0;
    Optional<BinarySearchTree<T>> node2DelOpt = find(tree, value);
    if( node2DelOpt.isPresent() ) {
      BinarySearchTree<T> node2Del = node2DelOpt.get();
      deletedNodeHeight = node2Del.getHeight();
      // case 1: it is a leaf, just unreference it, and GC will do the job
      if( node2Del.getLeftChild() == null && node2Del.getRigthChild() == null ) {
        if( node2Del.getParent() != null ) {  // but it should not be a single-node-tree
          updateParentNode(node2Del, null);
          System.out.println("NO Successor ");
        }
      }
      // cases 2 and 3: is has only one subtree, replace by the other
      else if( node2Del.getLeftChild() == null ) {
        updateParentNode(node2Del, node2Del.getRigthChild());
        System.out.println("Successor: " + node2Del.getRigthChild());
      } else if( node2Del.getRigthChild() == null ) {
        updateParentNode(node2Del, node2Del.getLeftChild());
        System.out.println("Successor: " + node2Del.getLeftChild());
      }
      // case 4: it has 2 subtrees, replace it by the largest smallest in the right or the largest in the left to respect BST invariant
      else {
        BinarySearchTree<T> successor = findSmalletsLeaf(node2Del.getRigthChild());
        System.out.println("Successor: " + successor.getData());
        tree.setData(successor.getData());
        delete(node2Del.getRigthChild(), successor.getData());
      }
    }
    return 0;
    ///todo changeme
  }

  private void updateParentNode(BinarySearchTree<T> oldChild, BinarySearchTree<T> newChild) {
    if( isSonLeftHung(oldChild) ) {
      oldChild.getParent().setLeftChild(newChild);
    } else {
      oldChild.getParent().setRigthChild(newChild);
    }
  }

  /**
   * @param childNode, a node having a parent
   * @return true if the song hungs in the left side, false if the oposite
   */
  private Boolean isSonLeftHung(BinarySearchTree<T> childNode) {
    if( childNode.getParent().getLeftChild() == childNode ) {
      return true;
    } else {
      return false;
    }
  }

  public BinarySearchTree<T> findBiggestLeaf(BinarySearchTree<T> tree) {
    BinarySearchTree<T> bLeaf = tree;
    while( bLeaf.getRigthChild() != null ) {
      bLeaf = bLeaf.getRigthChild();
    }
    return bLeaf;
  }

  public BinarySearchTree<T> findSmalletsLeaf(BinarySearchTree<T> tree) {
    BinarySearchTree<T> sLeaf = tree;
    while( sLeaf.getLeftChild() != null ) {
      sLeaf = sLeaf.getLeftChild();
    }
    return sLeaf;
  }

  public Optional<BinarySearchTree<T>> find(BinarySearchTree<T> tree, T value) {
    Optional node;
    if( tree.getData().compareTo(value) == 0 ) {
      node = Optional.of(tree);
    } else if( tree.leftChild != null && tree.getData().compareTo(value) == 1 ) {
      node = find(tree.getLeftChild(), value);
    } else if( tree.rigthChild != null && tree.getData().compareTo(value) == -1 ) {
      node = find(tree.getRigthChild(), value);
    } else {
      System.out.println(value + " not found");
      return Optional.empty();
    }
    return node;
  }

  public void deepFirst(BinarySearchTree<T> tree) {
    System.out.println(tree.getData());
    if( tree.leftChild != null ) {
      deepFirst(tree.getLeftChild());
    }
    if( tree.rigthChild != null ) {
      deepFirst(tree.getRigthChild());
    }
  }

  public void breadthFirst(BinarySearchTree<T> tree) {
    Set<BinarySearchTree<T>> discovered = new HashSet<>();
    Queue<BinarySearchTree<T>> queue = new ArrayDeque<>();
    queue.add(tree);
    //System.out.println( "adding node " + tree.getData());
    while( !queue.isEmpty() ) {
      BinarySearchTree<T> fiNode = queue.remove();
      discovered.add(fiNode);
      System.out.println(fiNode.getData());
      if( fiNode.leftChild != null ) {
        //System.out.println( "adding left child " + fiNode.leftChild.getData());
        queue.add(fiNode.leftChild);
      }
      if( fiNode.rigthChild != null ) {
        //System.out.println( "adding rigth child " + fiNode.rigthChild.getData());
        queue.add(fiNode.rigthChild);
      }
    }
  }


//  public BinarySearchTree<T> find(BinarySearchTree<T> tree, T value) {
//    BinarySearchTree<T> node;
//    if (tree.getData().compareTo(value) == 0){
//      node = tree;
//    }
//    else if( tree.leftChild != null && tree.getData().compareTo(value) == 1){
//      return find(tree.getLeftChild(), value);
//    }
//
//    else if( tree.rigthChild != null &&
//            tree.getData().compareTo(value) == -1){
//      return find(tree.getRigthChild(), value);
//    }
//    else {
//      return null;
//    }
//    System.out.println("Returning " + node.getData());
//    return node;
//  }


  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public BinarySearchTree getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinarySearchTree leftBranch) {
    leftChild = leftBranch;
  }

  public void setRigthChild(BinarySearchTree rigthBranch) {
    rigthChild = rigthBranch;
  }

  public BinarySearchTree getRigthChild() {
    return rigthChild;
  }

  public BinarySearchTree<T> getParent() {
    return parent;
  }

  public void setParent(BinarySearchTree<T> parent) {
    this.parent = parent;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
