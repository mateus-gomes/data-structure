package data_structures.trees.binarysearch;

public class BinarySearchTree {

    private BinaryTreeNode rootNode;

    public BinarySearchTree(int value) {
        this.rootNode = new BinaryTreeNode(value);
    }

    public BinaryTreeNode getRootNode() {
        return rootNode;
    }

    public void insert(int value){
         BinaryTreeNode currentNode = rootNode;
         boolean wasInserted = false;

         while(!wasInserted){
             if(currentNode.getValue() <= value){
                 if(currentNode.getRight() == null){
                     currentNode.setRight(new BinaryTreeNode(value));
                     wasInserted = true;
                 } else{
                     currentNode = currentNode.getRight();
                 }
             }else {
                 if(currentNode.getLeft() == null){
                     currentNode.setLeft(new BinaryTreeNode(value));
                     wasInserted = true;
                 } else{
                     currentNode = currentNode.getLeft();
                 }
             }
         }
    }

    public BinaryTreeNode lookup(int value){
        BinaryTreeNode currentNode = rootNode;
        boolean wasFound = false;

        while(!wasFound){
            if(currentNode.getLeft() == null && currentNode.getRight() == null){
                wasFound = true;
            }

            if(currentNode.getValue() < value){
                currentNode = currentNode.getRight();
            }else if(currentNode.getValue() > value){
                currentNode = currentNode.getLeft();
            } else if(currentNode.getValue() == value){
                return currentNode;
            }
        }

        return null;
    }

    public void remove(int value){
        BinaryTreeNode currentNode = rootNode;
        BinaryTreeNode previousNode = null;
        boolean wasFound = false;

        while(!wasFound){
            if(currentNode.getLeft() == null && currentNode.getRight() == null){
                wasFound = true;
            }

            if(currentNode.getValue() < value){
                previousNode = currentNode;
                currentNode = currentNode.getRight();
            }else if(currentNode.getValue() > value){
                previousNode = currentNode;
                currentNode = currentNode.getLeft();
            } else if(currentNode.getValue() == value){
                if(currentNode.getRight() == null && currentNode.getLeft() == null){
                    if(previousNode.getRight().getValue() == currentNode.getValue()){
                        previousNode.setRight(null);
                    } else {
                        previousNode.setLeft(null);
                    }
                    return;
                }

                if(currentNode.getRight() == null){
                    if (previousNode == null) {
                        this.rootNode = currentNode.getLeft();
                    }
                }else if(currentNode.getLeft() == null){
                    if (previousNode == null) {
                        this.rootNode = currentNode.getRight();
                    }
                }

                wasFound = true;
                currentNode.setValue(findFinalLeft(currentNode, previousNode));
            }
        }
    }

    private Integer findFinalLeft(BinaryTreeNode currentNode, BinaryTreeNode previousNode){
        boolean wasFound = false;
        boolean isFirst = true;

        while(!wasFound){
            if(currentNode.getLeft() == null && currentNode.getRight() == null){
                wasFound = true;
            }

            if(isFirst){
                if(currentNode.getRight().getLeft() == null){
                    BinaryTreeNode nextRightNode = currentNode.getRight();
                    currentNode.setRight(null);
                    return nextRightNode.getValue();
                }

                previousNode = currentNode;
                currentNode = currentNode.getRight();
                isFirst = false;
            } else {
                if(currentNode.getLeft() == null){
                    previousNode.setLeft(null);
                    return currentNode.getValue();
                }else{
                    previousNode = currentNode;
                    currentNode = currentNode.getLeft();
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(9);

        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        System.out.println(tree.getRootNode());

//        System.out.println(tree.lookup(20));

        tree.remove(9);

        System.out.println(tree.getRootNode());
    }
}
