package org.hiromats3;

import javax.inject.Singleton;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.hiromats3.java.*;

/**
 * Parser Management Service.
 */
@Singleton
public class ParserService {

    public String parseJava(String inputString) {
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromString(inputString));
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser java8Parser = new Java8Parser(tokens);
        ParseTree tree = java8Parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        UppercaseMethodListener uppercaseMethodListener = new UppercaseMethodListener();
        walker.walk(uppercaseMethodListener, tree);

        return uppercaseMethodListener.getErrors().get(0);
    }
}