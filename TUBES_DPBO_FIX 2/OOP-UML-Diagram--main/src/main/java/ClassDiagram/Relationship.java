/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDiagram;

/**
 *
 * @author dell
 */
public class Relationship extends Element{
    private int fromId;
    private int toId;

    public Relationship(int id, String name, int fromId, int toId) {
        super(id, "Relationship", name, null);
        this.fromId = fromId;
        this.toId = toId;
    }
   
    public void updateFromId(int fromId) {
        this.fromId = fromId;
    }

    public void updateToId(int toId) {
        this.toId = toId;
    }
}
