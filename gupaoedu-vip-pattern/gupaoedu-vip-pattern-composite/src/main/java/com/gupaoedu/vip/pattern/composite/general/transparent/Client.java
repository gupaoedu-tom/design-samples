package com.gupaoedu.vip.pattern.composite.general.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        // 来一个根节点
        Component root = new Composite("root");
        // 来一个树枝节点
        Component branchA = new Composite("---branchA");
        Component branchB = new Composite("------branchB");
        // 来一个叶子节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);
        branchA.addChild(leafA);
        branchA.addChild(branchB);
        branchB.addChild(leafB);

        String result = root.operation();
        System.out.println(result);

    }

    static abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract String operation();

        public boolean addChild(Component component) {
            throw new UnsupportedOperationException("addChild not supported!");
        }

        public boolean removeChild(Component component) {
            throw new UnsupportedOperationException("removeChild not supported!");
        }

        public Component getChild(int index) {
            throw new UnsupportedOperationException("getChild not supported!");
        }
    }

    // 树节点
    static class Composite extends Component {
        private List<Component> components;

        public Composite(String name) {
            super(name);
            this.components = new ArrayList<Component>();
        }

        @Override
        public String operation() {
            StringBuilder builder = new StringBuilder(this.name);
            for (Component component : this.components) {
                builder.append("\n");
                builder.append(component.operation());
            }
            return builder.toString();
        }

        public boolean addChild(Component component) {
            throw new UnsupportedOperationException("addChild not supported!");
        }

        public boolean removeChild(Component component) {
            throw new UnsupportedOperationException("removeChild not supported!");
        }

        public Component getChild(int index) {
            throw new UnsupportedOperationException("getChild not supported!");
        }
    }

    //叶子节点
    static class Leaf extends Component {

        public Leaf(String name) {
            super(name);
        }

        @Override
        public String operation() {
            return this.name;
        }
    }

}
