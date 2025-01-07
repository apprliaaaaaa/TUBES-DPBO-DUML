/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDiagram;

/**
 *
 * @author dell
 */
import java.util.ArrayList;
import java.util.List;
public class Method extends Element{
    private String returnType;
    private List<Attribute> params;

    public Method(int id, String name, String content, String returnType) {
        super(id, "Method", name, content);
        this.returnType = returnType;
        this.params = new ArrayList<>();
    }
}
