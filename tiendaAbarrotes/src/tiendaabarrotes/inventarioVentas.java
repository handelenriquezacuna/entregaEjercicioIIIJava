/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaabarrotes;

import javax.swing.JOptionPane;

/**
 *
 * @author hande
 */
public class inventarioVentas {

    private String productName;
    private int numProduct;
    private String dayName;


    /*
    Metodos para construir logicas dentro del codigo
     */
    public void VentasDias() {
        inventarioVentas ventas = new inventarioVentas();
        inventarioVentas[][] productos = ventas.inventario();
        int mayorVentas = 0;
        String strmayorVentas = "";
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[j].length; j++) {
                String dayTotalProductos = productos[i][j].getDayName();
                if (dayTotalProductos == productos[i][j].getDayName()) {
                    int totalDayProduct = 0;
                    totalDayProduct = productos[i][j].getNumProduct() + totalDayProduct;
                    System.out.println(productos[i][j].getDayName() + " se vendio " + totalDayProduct);
                    if (totalDayProduct >= mayorVentas) {
                        strmayorVentas = productos[i][j].getDayName() + " se vendio " + totalDayProduct;
                    }
                }
            }
        }
        System.out.println("El dia con ventas mayores es " + strmayorVentas);
    }

    public inventarioVentas[][] inventario() {
        inventarioVentas semanaInventario = new inventarioVentas();
        int matrixSize = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos productos va ingresar?"));
        inventarioVentas[][] ingresoProductos = new inventarioVentas[7][matrixSize];
        for (int i = 0; i < ingresoProductos.length; i++) {
            String nameDay = semanaInventario.dayName(i);
            String nomProducto = JOptionPane.showInputDialog("¿Cual es el producto?");
            for (int j = 0; j < ingresoProductos[i].length; j++) {
                int numProduct = Integer.parseInt(JOptionPane.showInputDialog("¿Numero de ventas del producto?"));
                ingresoProductos[i][j] = new inventarioVentas(nomProducto, numProduct, nameDay);
            }
        }
        return ingresoProductos;
    }

    public String dayName(int i) {
        String resultado = "";
        switch (i) {
            case 0:
                resultado = EnumDays.Lunes.name();
                break;

            case 1:
                resultado = EnumDays.Martes.name();
                break;
            case 2:
                resultado = EnumDays.Miercoles.name();
                break;
            case 3:
                resultado = EnumDays.Jueves.name();
                break;
            case 4:
                resultado = EnumDays.Viernes.name();
                break;
            case 5:
                resultado = EnumDays.Sabado.name();
                break;
            case 6:
                resultado = EnumDays.Domingo.name();
                break;
            default:
                throw new AssertionError("Numero no valido");
        }
        return resultado;
    }

    /*
    Building Constructors for Arrays
     */
    public inventarioVentas() {

    }

    public inventarioVentas(String productName, int numProduct, String dayName) {
        this.productName = productName;
        this.numProduct = numProduct;
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return "inventarioVentas{" + "productName=" + productName + ", numProduct=" + numProduct + ", dayName=" + dayName + '}';
    }

    /*
    Getters & Setters for the application
     */
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumProduct() {
        return numProduct;
    }

    public void setNumProduct(int numProduct) {
        this.numProduct = numProduct;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
