package A1_Builder;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

class Variable {
    String type;
    String name;

    public Variable(String type, String name) {
        this.type = type;
        this.name = name;
    }
}

class CodeBuilder {
    String className;
    List<Variable> variables;

    public CodeBuilder(String className) {
        this.className = className;
        this.variables = new ArrayList<>();
    }

    public CodeBuilder addField(String name, String type) {
        variables.add(new Variable(type, name));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("public class " + className)
                .append("\n{");
        for (Variable v : variables) {
            sb.append("\n  public " + v.type + " " + v.name + ";");
        }
        sb.append("\n}");
        return sb.toString();
    }

}

class CodeBuilderExerciseDemo {
    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person");
        codeBuilder
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(codeBuilder);
    }
}
