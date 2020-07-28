package com.gupaoedu.vip.pattern.memento.editor;

import java.util.Stack;

/**
 * Created by Tom.
 */
public class DraftsBox {
    private final Stack<ArticleMemento> STACK = new Stack<ArticleMemento>();

    public ArticleMemento getMemento(){
        ArticleMemento articleMemento = STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento){
        STACK.push(articleMemento);
    }

}
