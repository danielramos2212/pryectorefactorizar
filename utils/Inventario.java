package utils;
public class Inventario {
    public double calcularTotalInventario(int numeroProductos, double precioUnitario,
                                          int mesesCatalogo, int diasDesdeUltimaVenta, int stockAnual, String tipoCategoria) {
// Cálculo del valor base del inventario
        double valorBase = numeroProductos * precioUnitario;
// Descuento por antigüedad (si lleva más de 12 meses
// en catálogo)
        double descuentoAntiguedad = 0;
        if (mesesCatalogo > 12) {
            descuentoAntiguedad = valorBase * 0.15;
        }
// Penalización por baja rotación (más de 60 días sin vender)
        double penalizacionRotacion = 0;
        if (diasDesdeUltimaVenta > 60) {
            penalizacionRotacion = valorBase * 0.10;
        }
// Bonificación por stock alto (más de 100 unidades)
        double bonificacionStock = 0;
        if (stockAnual > 100) {
            bonificacionStock = valorBase * 0.05;
        }
// Ajuste por tipo de categoría
        double ajusteCategoria = 0;
        if (tipoCategoria.equals("premium")) {
            ajusteCategoria = valorBase * 0.20;
        } else if (tipoCategoria.equals("basica")) {
            ajusteCategoria = -valorBase * 0.05;
        }
// Cálculo final
        return valorBase - descuentoAntiguedad - penalizacionRotacion + bonificacionStock + ajusteCategoria;
    }
}
