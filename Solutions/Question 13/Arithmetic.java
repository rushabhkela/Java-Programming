import java.io.*;
import java.util.*;

public class Arithmetic {
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public static double applyOp(char op,double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("expression.txt");  
        BufferedReader br = new BufferedReader(fr);

        FileWriter op1 = new FileWriter("operators.txt");  
        PrintWriter pw1 = new PrintWriter(op1);
        FileWriter op2 = new FileWriter("operands.txt");  
        PrintWriter pw2 = new PrintWriter(op2);
        int cnt = 1;
        String line = br.readLine();
        while(line!=null)
        {
            pw1.println("EXPRESSION " + (cnt));
            pw2.println("EXPRESSION " + (cnt++));
            String s = "";
            int operators = 0;
            int operands = 0;
            String exp = "";
            int i;
            for(i = 0; i < line.length(); i++) { 
                char k = line.charAt(i);
                exp += k;
                if(Character.isDigit(k)) {
                    s += k;
                } 
                else {
                    pw1.print(s + " ");
                    operators++;
                    s = "";
                    pw2.print(k + " ");
                    operands++;
                } 
            }  
            pw1.print(s);
            operators++;
            pw1.println("\nCount of operators: " + operators + "\n");
            pw2.println("\nCount of operands: " + operands + "\n");

            char[] tokens = exp.toCharArray();
            Stack<Double> values = new Stack<Double>();
            Stack<Character> ops = new Stack<Character>();
    
            for (i = 0; i < tokens.length; i++)
            {
                if (tokens[i] == ' ')
                    continue;
                if (tokens[i] >= '0' && tokens[i] <= '9')
                {
                    StringBuffer sbuf = new StringBuffer();
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Double.parseDouble(sbuf.toString()));
                    i--;
                }
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);
                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.pop();
                }
                else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
                {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.push(tokens[i]);
                }
            }

            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            System.out.println("\nEvaluated Expression " + (cnt-1) + " : " + values.pop());

            line = br.readLine();
        }
        pw1.flush();
        pw1.close();
        pw2.flush();
        pw2.close();
    }
}
