package com.whs.javacode.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class NodeS<T> {
	
    private List<NodeS<T>> children = new ArrayList<NodeS<T>>();
    private NodeS<T> parent = null;
    private T data = null;

    public NodeS(T data) {
        this.data = data;
    }

    public NodeS(T data, NodeS<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<NodeS<T>> getChildren() {
        return children;
    }

    public void setParent(NodeS<T> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(T data) {
    	NodeS<T> child = new NodeS<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(NodeS<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }
}