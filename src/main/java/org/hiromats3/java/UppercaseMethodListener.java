package org.hiromats3.java;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UppercaseMethodListener extends Java8BaseListener {

    private List<String> uppercaseMethods = new ArrayList<String>();

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        String methodName = node.getText();

        if (Character.isUpperCase(methodName.charAt(0))){
            uppercaseMethods.add(methodName);
        }
    }

    public List<String> getUppercaseMethods(){
        return Collections.unmodifiableList(uppercaseMethods);
    }
}