/*
 * Copyright 2015 Hubrick
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubrick.raml.codegen.common;

import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionImpl;
import com.sun.codemodel.JFormatter;

/**
 * This class is a substitute for {@link JExpression#plus(JExpression)} in order to avoid unnecessary parentheses.
 */
public class BinaryOperator extends JExpressionImpl {

    private final String operator;
    private final JExpression left;
    private final JExpression right;

    private BinaryOperator(String operator, JExpression left, JExpression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public static BinaryOperator of(String operator, JExpression left, JExpression right) {
        return new BinaryOperator(operator, left, right);
    }

    @Override
    public void generate(JFormatter f) {
        f.g(left).p(operator).g(right);
    }

}
