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

public class Class extends Element{
    private List<Attribute> attribut;
    private List<Method> methods;
    public Class(int id, String nama) {
        super(id, "Class", nama, null);
        this.attribut = new ArrayList<>();
        this.methods = new ArrayList<>();
    }
    public void TambahAttribute(Attribute attribut) {
        this.attribut.add(attribut);
    }
    public void HapusAttribute(Attribute attribut) {
        this.attribut.remove(attribut);
    }
    public void TambahMethod(Method method) {
        this.methods.add(method);
    }
    public void HapusMethod(Method method) {
        this.methods.remove(method);
    }

}
