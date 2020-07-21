package org.hiromats3.java;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

@ApplicationScoped
public class JavaParserService {

    public CommonTokenStream tokenize(String inputString) {
        Java8Lexer lexer = new Java8Lexer(CharStreams.fromString(inputString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return tokens;
    }

    public ParseTree createParseTree(CommonTokenStream tokens) {
        Java8Parser java8Parser = new Java8Parser(tokens);
        ParseTree tree = java8Parser.compilationUnit();
        return tree;
    }

    public Map<String, Object> parse(String inputString) {
        ParseTree tree = this.createParseTree(this.tokenize(inputString));

        ParseTreeWalker walker = new ParseTreeWalker();
        UppercaseMethodListener myTreeListener = new UppercaseMethodListener();

        walker.walk(myTreeListener, tree);

        Map<String, Object> result = new HashMap<>();
        result.put("UppercaseMethods", myTreeListener.getUppercaseMethods());

        return result;
    }
}