package Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java_cup.runtime.Symbol;
import Language.Scanner;
public class ScannerTest {
    public static void main(String[] args) throws Exception {
        try {
            String input = readInput("./Inputs/Input1.olc");
            Scanner scanner = new Scanner(
                new BufferedReader(
                    new StringReader(input)
                )
            );
            System.out.println(input);
            Symbol sym;
            System.out.println("TOKEN" + " ".repeat(25 - "TOKEN".length()) + "LINE" + " ".repeat(6 - "LINE".length()) + "COLUMN" + " ".repeat(8 - "COLUMN".length()) + "TYPE");
            do {
                sym = scanner.next_token();
                System.out.println(sym.value + " ".repeat(25 - String.valueOf(sym.value).length()) + sym.left + " ".repeat(6 - String.valueOf(sym.left).length()) + sym.right + " ".repeat(8 - String.valueOf(sym.right).length()) + Language.Sym.terminalNames[sym.sym]);
            } while(sym.value != null);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public static String readInput(String path) {
        try {
            File archivo = new File(path);
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            
            String texto = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea + "\n";
            }
            br.close();
            fis.close();
            return texto;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return "";
    }
}