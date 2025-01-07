/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDiagram;

/**
 *
 * @author dell
 */
public abstract class Element {
    protected int id;
    protected String type;
    protected String nama;
    protected String konten;

    public Element(int id, String type, String nama, String konten) {
        this.id = id;
        this.type = type;
        this.nama = nama;
        this.konten = konten;
    }

    public void updateNama(String nama) {
        this.nama = nama;
    }

    public void updateKonten(String content) {
        this.konten = konten;
    }
}
