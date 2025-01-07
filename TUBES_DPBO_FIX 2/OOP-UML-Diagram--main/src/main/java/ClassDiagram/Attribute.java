/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDiagram;

/**
 *
 * @author dell
 */
public class Attribute extends  Element{
    
   private String tipeData;

    public Attribute(int id, String name, String tipeData) {
        super(id, "Attribute", name, null);
        this.tipeData = tipeData;
    }

    public String getTipeData() {
        return tipeData;
    }

    public void updateTipeData(String tipeData) {
        this.tipeData = tipeData;
    }
    
}
