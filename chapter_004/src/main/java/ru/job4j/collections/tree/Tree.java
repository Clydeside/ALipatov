package ru.job4j.collections.tree;

import java.util.*;

public class Tree<E extends  Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(Node<E> root) {
        this.root = root;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> elem = findBy(parent);
        elem.get().add(new Node(child));
        return true;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> node = data.poll();
            List<Node<E>> children = node.leaves();
            if (children.size() > 2) {
                result = false;
                break;
            }
            children.forEach(data::offer);
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
