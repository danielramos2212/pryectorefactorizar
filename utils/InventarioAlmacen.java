package utils;
public class InventarioAlmacen {
    private static final int LIMITE_MESES_ANTIGUEDAD = 12;
    private static final double PORCENTAJE_DESCUENTO_ANTIGUEDAD = 0.15;
    private static final int LIMITE_DIAS_ROTACION = 60;
    private static final double PORCENTAJE_PENALIZACION_ROTACION = 0.10;
    private static final int LIMITE_STOCK_ALTO = 100;
    private static final double PORCENTAJE_BONIFICACION_STOCK = 0.05;
    private static final double PORCENTAJE_AJUSTE_PREMIUM = 0.20;
    private static final double PORCENTAJE_AJUSTE_BASICA = -0.05;
    public double calcularTotalInventario(int numeroProductos, double precioUnitario,
                                          int mesesCatalogo, int diasDesdeUltimaVenta, int stockAnual, String tipoCategoria) {
// Cálculo del valor base del inventario
        double valorBase = numeroProductos * precioUnitario;
// Descuento por antigüedad (si lleva más de 12 meses
// en catálogo)
        double descuentoAntiguedad = calcularDescuentoAntiguedad(mesesCatalogo, valorBase);
// Penalización por baja rotación (más de 60 días sin vender)
        double penalizacionRotacion = calcularPenalizacionRotacion(diasDesdeUltimaVenta, valorBase);
// Bonificación por stock alto (más de 100 unidades)
        double bonificacionStock = clacularBonificacionStock(stockAnual, valorBase);
// Ajuste por tipo de categoría
        double ajusteCategoria = clacularAjusteCategoria(tipoCategoria, valorBase);
// Cálculo final
        return valorBase - descuentoAntiguedad - penalizacionRotacion + bonificacionStock + ajusteCategoria;
    }

    private static double clacularAjusteCategoria(String tipoCategoria, double valorBase) {
        double ajusteCategoria = 0;
        if (tipoCategoria.equals("premium")) {
            ajusteCategoria = valorBase * PORCENTAJE_AJUSTE_PREMIUM;
        } else if (tipoCategoria.equals("basica")) {
            ajusteCategoria = -valorBase * PORCENTAJE_AJUSTE_BASICA;
        }
        return ajusteCategoria;
    }

    private static double clacularBonificacionStock(int stockAnual, double valorBase) {
        double bonificacionStock = 0;
        if (stockAnual > LIMITE_STOCK_ALTO) {
            bonificacionStock = valorBase * PORCENTAJE_BONIFICACION_STOCK;
        }
        return bonificacionStock;
    }

    private static double calcularPenalizacionRotacion(int diasDesdeUltimaVenta, double valorBase) {
        double penalizacionRotacion = 0;
        if (diasDesdeUltimaVenta > LIMITE_DIAS_ROTACION) {
            penalizacionRotacion = valorBase * PORCENTAJE_PENALIZACION_ROTACION;
        }
        return penalizacionRotacion;
    }

    private static double calcularDescuentoAntiguedad(int mesesCatalogo, double valorBase) {
        double descuentoAntiguedad = 0;
        if (mesesCatalogo > LIMITE_MESES_ANTIGUEDAD) {
            descuentoAntiguedad = valorBase * PORCENTAJE_DESCUENTO_ANTIGUEDAD;
        }
        return descuentoAntiguedad;
    }
}
