package com.example;

import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class AvoidMyApiKeyRule extends AbstractJavaRule {
    private static final String MY_API_KEY = "myApiKey123";

    public Object visit(ASTLiteral node, Object data) {
        String image = node.getImage();
        if (image != null && image.contains(MY_API_KEY)) {
            addViolation(data, node);
        }
        return super.visit(node, data);
    }
}
